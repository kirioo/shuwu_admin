package com.tz.web.oss;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.tz.util.MobleMessage;

@Controller
@RequestMapping("server/oss")
public class OSSController {
	private static final long serialVersionUID = 5522372203700422672L;

	@RequestMapping("/getOssToken")
	public void uploadObject(HttpServletRequest request,
			HttpServletResponse response) {
		String endpoint = OSSConfig.OSS_ADDRESS;
		String accessId = OSSConfig.ACCESS_KEY_ID;
		String accessKey = OSSConfig.ACCESS_KEY_SECRET;
		String bucket = OSSConfig.OSS_IMG_BUCKET;
		String dir = OSSConfig.OSS_IMG_BUCKET;
		String host = "http://" + bucket + "." + endpoint;/*
														 * "http://" + bucket +
														 * "." + endpoint;
														 */
		OSSClient client = new OSSClient(endpoint, accessId, accessKey);
		try {
			long expireTime = 30;
			long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
			Date expiration = new Date(expireEndTime);
			PolicyConditions policyConds = new PolicyConditions();
			policyConds.addConditionItem(
					PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
			policyConds.addConditionItem(MatchMode.StartWith,
					PolicyConditions.COND_KEY, dir);

			String postPolicy = client.generatePostPolicy(expiration,
					policyConds);
			byte[] binaryData = postPolicy.getBytes("utf-8");
			String encodedPolicy = BinaryUtil.toBase64String(binaryData);
			String postSignature = client.calculatePostSignature(postPolicy);

			Map<String, String> respMap = new LinkedHashMap<String, String>();
			respMap.put("accessid", accessId);
			respMap.put("policy", encodedPolicy);
			respMap.put("signature", postSignature);
			// respMap.put("expire", formatISO8601Date(expiration));
			respMap.put("dir", dir);
			respMap.put("host", host);
			respMap.put("expire", String.valueOf(expireEndTime / 1000));
			JSONObject ja1 = JSONObject.fromObject(respMap);
			System.out.println(ja1.toString());
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "GET, POST");
			response(request, response, ja1.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void response(HttpServletRequest request,
			HttpServletResponse response, String results) throws IOException {
		String callbackFunName = request.getParameter("callback");
		if (callbackFunName == null || callbackFunName.equalsIgnoreCase(""))
			response.getWriter().println(results);
		else
			response.getWriter().println(
					callbackFunName + "( " + results + " )");
		response.setStatus(HttpServletResponse.SC_OK);
		response.flushBuffer();
	}

	/**
	 * 获取OSS操作权限
	 * 
	 * @param httpPram
	 * @return
	 */
	@RequestMapping("_getOSSsign")
	@ResponseBody
	public MobleMessage doOSSToken(String httpPram, String url, String videoUrl) {
		MobleMessage message = new MobleMessage();

		String tuken = OSSBacketUtils.getTuken(httpPram, url);
		if (null != tuken) {
			String kuozhanming = url.substring(url.lastIndexOf(".") + 1);
			String name = url.substring(url.lastIndexOf("/") + 1);
			// ResultBean addImg = imgResourceService.addImg(name, kuozhanming,
			// name, url, 0L);
			message.setCode(0);
			message.setResult(true);
			Map<String, String> response = new HashMap<String, String>();
			response.put("sign", tuken);
			response.put("time", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss",
					Locale.CHINESE).format(new Date()));
			message.setResponse(response);
		} else {
			message.setCode(6);
			message.setErrorMessage("获取token失败");
			message.setResult(false);
		}
		return message;
	}
}
