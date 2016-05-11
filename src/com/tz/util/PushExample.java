package com.tz.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.support.JdbcUtils;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.ClientConfig;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

/**
 * 相当威武霸气的一键式推送Uitl
 * @author 郭胜凯
 *
 */
public class PushExample {
    protected static final Logger LOG = LoggerFactory.getLogger(PushExample.class);
	private static String APP_KEY;
	private static String MASTER_SECRET;
    //public static final String REGISTRATION_ID = "03075814096";
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
    //test
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", "Bank");
		sendToAndroid("XXX银行向您发送了面试通知",map,"0302b58419e");//0302b58419e
//		sendAll("我再测试一下全体推送~~~");03075814096
	}
	
	public static void sendAll(String message){
		 ClientConfig config = ClientConfig.getInstance();
	     config.setPushHostName("https://api.jpush.cn");
	     JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, 3, null, config);
	     try {
	    	 PushResult result = jpushClient.sendNotificationAll(message);
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
	
	/**
	 * 推送给某个用户
	 * @param message
	 * @param pram
	 * @param registId
	 */
    public static void sendToAndroid(String message, Map<String, String> pram, String registId) {
        ClientConfig config = ClientConfig.getInstance();
        config.setPushHostName("https://api.jpush.cn");
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, 3, null, config);
        try {
            PushResult result = jpushClient.sendAndroidNotificationWithRegistrationID(null, message, pram, registId);
            //======================================要改的===========================================
            //由于IOS端暂时没有Apple开发证书，所以无法连同IOS一起推送，暂时只推送Android
//        	jpushClient.send
//        	PushPayload pushPayload = buildPushObject_all_alias_alert();
//        	PushResult result = jpushClient.sendPush(pushPayload);
            //======================================要改的===========================================
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
    
    public static void sendToIOS(String message, Map<String, String> pram, String registId){
    	 ClientConfig config = ClientConfig.getInstance();
         config.setPushHostName("https://api.jpush.cn");
         JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, 3, null, config);
         try {
//             PushResult result = jpushClient.sendIosMessageWithRegistrationID(title, message, registId);
             PushResult result = JPushClient.sendIosNotificationWithRegistrationID(message, pram, registId);
             
             //======================================要改的===========================================
             //由于IOS端暂时没有Apple开发证书，所以无法连同IOS一起推送，暂时只推送Android
//         	jpushClient.send
//         	PushPayload pushPayload = buildPushObject_all_alias_alert();
//         	PushResult result = jpushClient.sendPush(pushPayload);
             //======================================要改的===========================================
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
    
    public static PushPayload buildPushObject_android_and_ios() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.tag("tag1"))
                .setNotification(Notification.newBuilder()
                		.setAlert("alert content")
                		.addPlatformNotification(AndroidNotification.newBuilder()
                				.setTitle("Android Title").build())
                		.addPlatformNotification(IosNotification.newBuilder()
                				.incrBadge(1)
                				.addExtra("extra_key", "extra_value").build())
                		.build())
                .build();
    }
    public static PushPayload buildPushObject_all_alias_alert() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias("alias1"))
                .setNotification(Notification.alert("alias1"))
                .build();
    }



}

