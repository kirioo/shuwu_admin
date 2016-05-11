package com.tz.service.pay.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.ImBean;
import com.tz.bean.Order;
import com.tz.bean.PayInfo;
import com.tz.dao.order.IOrderMapper;
import com.tz.dao.payinfo.IPayInfoMapper;
import com.tz.service.pay.IPayService;
import com.tz.util.pay.weixin.SignUtil;
import com.tz.util.pay.weixin.response.WXResponse;


@Service
public class PayServiceImpl implements IPayService{
	

	@Autowired
	private IOrderMapper orderMapper;
	
	@Autowired
	private IPayInfoMapper payInfoMapper;
	
	@Override
	public Integer alipayCallback(String notify_time, String notify_type,
			String notify_id, String sign_type, String sign,
			String out_trade_no, String subject, String payment_type,
			String trade_no, String trade_status, String seller_id,
			String seller_email, String buyer_id, String buyer_email,
			Double total_fee, Integer quantity, Double price, String body,
			String gmt_create, String gmt_payment, String is_total_fee_adjust,
			String use_coupon, String discount, String refund_status,
			String gmt_refund) {
		try {
			if(!checkNotify(notify_id)){
				return 0;		//假冒支付宝的回调
			}
			Order order = new Order();
			order.setId(out_trade_no);
			order = orderMapper.get(order);
			order.setState(2);//改为待发货状态
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date date = sdf.parse(gmt_payment);
				order.setPayTime(date);
				System.out.println(sdf.parse(gmt_payment));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				return 0;
			}
			orderMapper.update(order);
			PayInfo payInfo = new PayInfo();
			payInfo.setId(UUID.randomUUID().toString());
			payInfo.setOrderId(out_trade_no);
			payInfo.setPayType(1);//支付宝支付方式
			payInfo.setState(1);
			payInfo.setTradeNo(trade_no);//支付宝交易号
			payInfoMapper.save(payInfo);
//		OrderInfoPo order = getUnique(OrderInfoPo.class, f1);
//		if(null == order){
//			return -1;		//订单不存在
//		}
//		if(order.getOrderStatus().equals(ATTContents.ORDER_STATUS2)){
//			return 2;		//重复的支付
//		}
//		UserInfoPo user = super.getUnique(UserInfoPo.class, Factor.create("id", C.Eq, order.getUserId()));
//		if(null == user){
//			return 3;		//用户挂了
//		}
//		order.setOrderStatus(ATTContents.ORDER_STATUS2);
//		order.setPayType(ATTContents.PAY_TYPE1);
//		order.setUpdateTime(System.currentTimeMillis());
//		update(order);		//支付成功
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}			
	}

	@Override
	public Integer recordPayOfWeixin(WXResponse response, String total_fee,
			Map<String, Object> map) {
		try {
			if(!SignUtil.checkNotify(map)){
				System.out.println("微信支付签名不通过");
				return 0;		//假冒微信的回调
			}
//		String orderId = response.getOut_trade_no();
//		Factor f1 = Factor.create("id", C.Eq, orderId);
//		OrderInfoPo order = getUnique(OrderInfoPo.class, f1);
//		if(null == order){
//			System.out.println("订单不存在");
//			return -1;		//订单不存在
//		}
//		if(order.getOrderStatus().equals(ATTContents.ORDER_STATUS2)){
//			return 2;		//重复的支付
//		}
//		UserInfoPo user = super.getUnique(UserInfoPo.class, Factor.create("id", C.Eq, order.getUserId()));
//		if(null == user){
//			return 3;		//用户挂了
//		}
//		order.setOrderStatus(ATTContents.ORDER_STATUS2);
//		order.setPayType(ATTContents.PAY_TYPE1);
//		order.setUpdateTime(System.currentTimeMillis());
//		update(order);		//支付成功
			Order order = new Order();
			order.setId(map.get("out_trade_no").toString());
			order = orderMapper.get(order);
			String transaction_id = map.get("transaction_id").toString();//微信支付订单号
			String time_end = map.get("time_end").toString();
			order.setState(2);//改为待发货状态
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			try {
				order.setPayTime(sdf.parse(time_end));
				System.out.println(sdf.parse(time_end));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				return 0;
			}
			orderMapper.update(order);
			PayInfo payInfo = new PayInfo();
			payInfo.setId(UUID.randomUUID().toString());
			payInfo.setOrderId(map.get("out_trade_no").toString());
			payInfo.setPayType(2);//支付宝支付方式
			payInfo.setState(1);
			payInfo.setTradeNo(transaction_id);//微信交易号
			payInfoMapper.save(payInfo);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	
	@Override
	public boolean checkNotify(String notifyId) {
		// TODO Auto-generated method stub
		String url = "https://mapi.alipay.com/gateway.do?service=notify_verify&partner=2088812951314112&notify_id="+notifyId;
		HttpGet get = new HttpGet(url);
		ImBean result = toRun(get);
		if(result.getCode() == 200){
			if(result.getValue().equalsIgnoreCase("true")){
				return true;
			}
		}
		return false;
	}

	private ImBean toRun(HttpGet get) {
		String val = "";
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try{
			get.addHeader("ContentType", "application/json");
			response = client.execute(get);
			val = EntityUtils.toString(response.getEntity());
		}catch(Exception e){
			
		}finally{
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new ImBean(response.getStatusLine().getStatusCode(),val);
	}
	public static void main(String[] args){
		String time = "20141030133525";
		Date date;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			date = sdf.parse(time);
		}catch(Exception e){
			date = new Date();
		}
		System.out.println(date.getTime());
	}
}
