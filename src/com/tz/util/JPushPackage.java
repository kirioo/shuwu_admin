package com.tz.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.support.JdbcUtils;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;


/** 
 * @title : 
 * @description : 
 * @projectname : csb-mobile-webapp
 * @classname : JPushPackage
 * @version 1.0
 * @author : chenhaisheng
 * @createtime : 2016-5-5 上午10:23:38 
 */
public class JPushPackage {
	protected static final Logger LOG = LoggerFactory.getLogger(JPushPackage.class);
	private static String APP_KEY;
	private static String MASTER_SECRET;
    static{
    	InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("JgConfig.properties");
    	Properties p = new Properties();
    	try{
    	    p.load(inputStream);
    	    APP_KEY = p.getProperty("appKey");
    	    MASTER_SECRET = p.getProperty("masterSecret");
    	} catch (IOException e1){
    		e1.printStackTrace();
    	}
    }
    static JPushClient client = new JPushClient(MASTER_SECRET, APP_KEY);
    
	public static void sendToAndroid(String title , String alert , Map<String, String> map , String registrationId){
        try {
        	PushResult result = client.sendAndroidNotificationWithRegistrationID(title, alert, map, registrationId);
        	LOG.info("Got result - " + result);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
        }
	}
	public static void sendToIOS(String alert , Map<String, String> map , String registrationId){
		try {
			PushResult result = client.sendIosNotificationWithRegistrationID(alert, map, registrationId);
			LOG.info("Got result - " + result);
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
		}
	}
	public static void sendAll(String alert){
		try {
			PushResult result = client.sendNotificationAll(alert);
			LOG.info("Got result - " + result);
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
		}
	}
}
