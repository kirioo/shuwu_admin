package com.tz.web.oss;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.springframework.jdbc.support.JdbcUtils;

import com.aliyun.oss.OSSClient;



public class OSSConfig {
	public final static String ACCESS_KEY_ID = getConfig("access_key");
	
	public final static String ACCESS_KEY_SECRET = getConfig("access_key_secret");

	public final static String OSS_IMG_BUCKET = getConfig("bucket_img");
	
	public final static String OSS_VIDEO_BUCKET = getConfig("bucket_video");
	
	public final static String OSS_ADDRESS = getConfig("address");
	
//	public final static AliyunClient aliyunTMSClient =  new DefaultAliyunClient("http://mts.aliyuncs.com", ACCESS_KEY_ID,ACCESS_KEY_SECRET);
	
	public final static String OSS_LOCATION = getConfig("location");
	
	public final static OSSClient aliyunOSSClient =  ATTContents.OSS_CLIENT;
            
	
	@SuppressWarnings("unused")
	private static Date thisDate = new Date();
	
	//===========
	

	
	
	
	
	
	
	
	
	
	private static String getConfig(String string) {
		// TODO Auto-generated method stub
		InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("OSSConfig.properties");
    	Properties prop = new Properties();
    	try {
			prop.load(inputStream);
			if(string.equals("access_key")){
				return prop.getProperty("OSS_ACCESS_KEY_ID").trim();
			}else if (string.equals("access_key_secret")) {
				return prop.getProperty("OSS_ACCESS_KEY_SECRET").trim();
			}else if (string.equals("bucket_img")) {
				return prop.getProperty("OSS_BUCKET_IMG").trim();
			}else if (string.equals("bucket_video")) {
				return prop.getProperty("OSS_BUCKET_VIDEO").trim();
			}else if (string.equals("address")) {
				return prop.getProperty("OSS_ADDRESS").trim();
			}else if (string.equals("location")) {
				return prop.getProperty("OSS_LOCATION").trim();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return null;
	}
	

	/**
	 * 制作客户端操作OSS签名
	 * @return
	 */
	public static String getSign(String encryptText,String url){
		String ossSign;
//		OSSClient client = new OSSClient(endpoint, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
		//…………
//		String webDate = "Thu "+DateUtil.format(thisDate, "MM")+" Nov "+DateUtil.format(thisDate, "yyyy hh:mm:ss")+" GMT";
//		String dataString = "/neiquan-image/2015_10_12_18_35_54_abc_287.png?";
//		String encryptText = "POST\n"
//			+"\n"
//			+"Mon, 12 Oct 2015 10:35:55 GMT"+"\n"
//			+dataString;
//		
////		EEE MMM dd HH:mm:ss zzz yyyy
//		String wenDate = DateUtil.format(thisDate, "EEE, MMM yyyy dd HH:mm:ss zzz");
//		String pram = "POST\n"
//		+
//		encryptText += "\n"+url;
		byte[] hashString = null;
		try {
			hashString = HMACSHA1.HmacSHA1Encrypt(encryptText, ACCESS_KEY_SECRET);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ossSign = Base64.encodeBase64String(hashString);
//		System.out.println(dataString);
		return ossSign;
	}
	
	public static void main(String[] args){
//		System.out.println(getSign("sssss"));
		System.out.println(getSign("123748237847283", null));
		
		
		
		byte[] hashString = null;
		try {
			hashString = HMACSHA1.HmacSHA1Encrypt("GET&%2F&AccessKeyId%3Dtestid%26Action%3DAssumeRole%26Format%3DJSON%26RoleArn%3Dacs%253Aram%253A%253A1234567890123%253Arole%252Ffirstrole%26RoleSessionName%3Dclient%26SignatureMethod%3DHMAC-SHA1%26SignatureNonce%3D571f8fb8-506e-11e5-8e12-b8e8563dc8d2%26SignatureVersion%3D1.0%26Timestamp%3D2015-09-01T05%253A57%253A34Z%26Version%3D2015-04-01", "testsecret&");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ossSign = Base64.encodeBase64String(hashString);
		System.out.println(ossSign);
	}
}
