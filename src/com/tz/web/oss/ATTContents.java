package com.tz.web.oss;

import com.aliyun.oss.OSSClient;

public class ATTContents {

	/**
	 * OSS客户端
	 */
	public static final OSSClient OSS_CLIENT = new OSSClient(
			OSSConfig.OSS_ADDRESS, OSSConfig.ACCESS_KEY_ID,
			OSSConfig.ACCESS_KEY_SECRET);

}
