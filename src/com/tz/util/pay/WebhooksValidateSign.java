package com.tz.util.pay;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @title : 验证webhooks 消息是否通过
 * @description : 
 * @projectname : zoua
 * @classname : WebhooksValidateSign
 * @version 1.0
 * @author : xiongliang
 * @createtime : 2015年9月2日 下午3:59:15
 */
public class WebhooksValidateSign {

	private static final String FILE_PATH = WebhooksValidateSign.class.getResource("/webhooks").getPath() + "my-server.pub";
	
	
	/**
	 * 验证签名
	 * @param data
	 * @param sigBytes
	 * @param publicKey
	 * @return
	 * @throws Exception 
	 */
	public static boolean verifyData(String event, String sign) throws Exception {
		Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initVerify(getPubKey());
		signature.update(event.getBytes());
		return signature.verify(Base64.decodeBase64(sign));
	}
	
	
	
	/**
	 * 获得公钥
	 * @return
	 * @throws Exception
	 */
	public static PublicKey getPubKey() throws Exception {
		// read key bytes
		FileInputStream in = new FileInputStream(FILE_PATH);
		byte[] keyBytes = new byte[in.available()];
		in.read(keyBytes);
		in.close();
		String pubKey = new String(keyBytes, "UTF-8");
		pubKey = pubKey.replaceAll("(-+BEGIN PUBLIC KEY-+\\r?\\n|-+END PUBLIC KEY-+\\r?\\n?)", "");
		keyBytes = Base64.decodeBase64(pubKey);
		// generate public key
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(spec);
		return publicKey;
	}
}
