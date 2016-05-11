package com.tz.service.pay;

import java.util.Map;

import com.tz.util.pay.weixin.response.WXResponse;

/**
 * 商品管理
 * @title : 
 * @description : 
 * @projectname : yida-api
 * @classname : IOrderService
 * @version 1.0
 * @author : chenhaisheng
 * @createtime : 2015-12-2 下午01:06:15
 */
public interface IPayService {

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
	Integer alipayCallback(String notify_time, String notify_type,
			String notify_id, String sign_type, String sign,
			String out_trade_no, String subject, String payment_type,
			String trade_no, String trade_status, String seller_id,
			String seller_email, String buyer_id, String buyer_email,
			Double total_fee, Integer quantity, Double price, String body,
			String gmt_create, String gmt_payment, String is_total_fee_adjust,
			String use_coupon, String discount, String refund_status,
			String gmt_refund);
	
	/**
	 * 微信支付回调
	 * @param response
	 * @param total_fee
	 * @param map
	 * @return
	 */
	Integer recordPayOfWeixin(WXResponse response, String total_fee,
			Map<String, Object> map);
	
	
	
	
	/**
	 * 校验通知有效性
	 * @param notifyId
	 * @return
	 */
	public boolean checkNotify(String notifyId);

	

	
	
}
