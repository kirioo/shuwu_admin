package com.tz.web.oss;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;

public class OSSBacketUtils {
	/**
	 * 创建文件夹，type：1=img，2=vido
	 */
	public static boolean createFolder(Integer OSSType, String folderName){
		String bucketName = OSSType==1?OSSConfig.OSS_IMG_BUCKET:OSSConfig.OSS_VIDEO_BUCKET;
		OSSClient client = ATTContents.OSS_CLIENT;
		//要创建的文件夹名称,在满足Object命名规则的情况下以"/"结尾
		String objectName = folderName+"/"; 
		ObjectMetadata objectMeta = new ObjectMetadata();
		/*这里的size为0,注意OSS本身没有文件夹的概念,这里创建的文件夹本质上是一个size为0的Object,dataStream仍然可以有数据
		 */
		byte[] buffer = new byte[0];
		ByteArrayInputStream in = new ByteArrayInputStream(buffer);  
		objectMeta.setContentLength(0);
		try {
		    client.putObject(bucketName, objectName, in, objectMeta);
		    return true;
		}catch(Exception e){
			return false;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static String getTuken(String pram,String url){
		return OSSConfig.getSign(pram,url);
	}
	
}
