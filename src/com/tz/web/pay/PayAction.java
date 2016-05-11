package com.tz.web.pay;

import java.io.BufferedReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tz.service.pay.IPayService;
import com.tz.util.pay.weixin.response.WXResponse;
/**
 * 订单操作
 * @title : 
 * @description : 
 * @projectname : yida-api
 * @classname : OrderAction
 * @version 1.0
 * @author : chenhaisheng
 * @createtime : 2015-12-3 上午09:45:31
 */

@Controller
@RequestMapping(value = "Server/pay")
public class PayAction {

	private static final Logger logger = LoggerFactory.getLogger(PayAction.class);
	
	@Autowired
	private IPayService payService;
	
	
	/**
	 * 支付宝回调接口
	 * @param notify_time
	 * @param notify_type
	 * @param notify_id
	 * @param sign_type
	 * @param sign
	 * @param out_trade_no
	 * @param subject
	 * @param payment_type
	 * @param trade_no
	 * @param trade_status
	 * @param seller_id
	 * @param seller_email
	 * @param buyer_id
	 * @param buyer_email
	 * @param total_fee
	 * @param quantity
	 * @param price
	 * @param body
	 * @param gmt_create
	 * @param gmt_payment
	 * @param is_total_fee_adjust
	 * @param use_coupon
	 * @param discount
	 * @param refund_status
	 * @param gmt_refund
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/IAlipayCallback", method = RequestMethod.POST)
	public String alipayCallback(String notify_time, String notify_type,String notify_id, String sign_type, String sign,
			String out_trade_no, String subject, String payment_type,String trade_no, String trade_status, String seller_id,
			String seller_email, String buyer_id, String buyer_email,Double total_fee, Integer quantity, Double price, String body,
			String gmt_create, String gmt_payment, String is_total_fee_adjust,String use_coupon, String discount, String refund_status,
			String gmt_refund){
		logger.info("******************** start alipayCallback ***************************");
		//邮费Postage、优惠券Coupon、补充说明Supplement
		Integer recordPay = payService.alipayCallback(notify_time, notify_type, notify_id, sign_type, sign, out_trade_no, subject, payment_type, 
				trade_no, trade_status, seller_id, seller_email, buyer_id, buyer_email, total_fee, quantity, price, 
				body, gmt_create, gmt_payment, is_total_fee_adjust, use_coupon, discount, refund_status, gmt_refund);
		if(!recordPay.equals(1)){
			logger.info("******************** end alipayCallback ***************************");
			return "fail";
		}
		logger.info("******************** end alipayCallback ***************************");
		return "success";
	}
	
	/**
	 * 微信支付回调
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/IRecordPayOfWeixin", method = RequestMethod.POST)
	public String recordPayOfWeixin(HttpServletRequest req){
		logger.info("******************** start recordPayOfWeixin ***************************");
		WXResponse response = new WXResponse();
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		StringBuffer bxml = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = req.getReader();
			while((line = reader.readLine()) != null) {
				bxml.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject jsonObj = (JSONObject) new net.sf.json.xml.XMLSerializer().read(bxml.toString());
		String appid = (String)jsonObj.get("appid");
		String bank_type = (String)jsonObj.get("bank_type");
		String cash_fee = (String)jsonObj.get("cash_fee");
		String fee_type = (String)jsonObj.get("fee_type");
		String is_subscribe = (String)jsonObj.get("is_subscribe");
		String mch_id = (String)jsonObj.get("mch_id");
		String nonce_str = (String)jsonObj.get("nonce_str");
		String openid = (String)jsonObj.get("openid");
		String trade_type = (String)jsonObj.get("trade_type");
		String transaction_id = (String)jsonObj.get("transaction_id");
		String time_end = (String)jsonObj.get("time_end");
		String out_trade_no = (String) jsonObj.get("out_trade_no");//订单id
		String result_code = (String) jsonObj.get("result_code");//支付结果
		String return_code = (String) jsonObj.get("return_code");//返回结果
		String sign = (String)jsonObj.get("sign");//签名
		String total_fee = (String)jsonObj.get("total_fee");//支付金额（单位为分）
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appid", appid);
		map.put("bank_type", bank_type);
		map.put("cash_fee", cash_fee);
		map.put("fee_type", fee_type);
		map.put("is_subscribe", is_subscribe);
		map.put("mch_id", mch_id);
		map.put("nonce_str", nonce_str);
		map.put("openid", openid);
		map.put("trade_type", trade_type);
		map.put("transaction_id", transaction_id);
		map.put("time_end", time_end);
		map.put("out_trade_no", out_trade_no);
		map.put("result_code", result_code);
		map.put("return_code", return_code);
		map.put("sign", sign);
		map.put("total_fee", total_fee);
		response.setOut_trade_no(out_trade_no);
		response.setResult_code(result_code);
		response.setReturn_code(return_code);
		Integer recordPay = payService.recordPayOfWeixin(response,total_fee,map);
		if(recordPay.equals(1)){
			logger.info("******************** end recordPayOfWeixin ***************************");
			return "<xml> <return_code>SUCCESS</return_code><return_msg>OK</return_msg></xml>";
		}
		logger.info("******************** end recordPayOfWeixin ***************************");
		return "<xml> <return_code>FAIL</return_code><return_msg>"+recordPay+"</return_msg></xml>";
	}
	
}
