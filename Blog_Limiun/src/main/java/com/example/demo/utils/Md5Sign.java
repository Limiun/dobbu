package com.example.demo.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.HtmlUtils;

import java.util.*;

public class Md5Sign {
	public static String H5_LOGINKEY = "de4738c57fdaeeafac85389bf463a5c3";
	/**
	 * 签名验证
	 * 
	 * <p>
	 * Title: verify
	 * </p>
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param params
	 * @return
	 * 
	 * @author 夏侯衡
	 * @date 2018年10月19日
	 */
	public static boolean verify(Map<String, String> params) {
		for (String key : params.keySet()) {
			String value = params.get(key);
			if (StringUtils.isNoneBlank(value)) {
				params.put(key, HtmlUtils.htmlUnescape(value));
			}
		}
		String sign = params.get("sign");
		if (StringUtils.isBlank(sign)) {
			System.out.println("sign 值为空");
			return false;
		}
		String timestamp = params.get("timestamp");
		Long timestampL = null;
		if (timestamp == null) {
			System.out.println("timestamp 值为空");
			return false;
		}
		try {
			timestampL = Long.parseLong(timestamp);
		} catch (NumberFormatException e) {
			System.out.println("timestamp 格式不对");
			return false;
		}
		if ((System.currentTimeMillis() - 1000L * 30) > timestampL) {
			System.out.println("请求超时");
			return false;
		}

		// 过滤空值、sign参数
		Map<String, String> sParaNew = paraFilter(params);
		// 获取待签名字符串
		String preSignStr = createLinkString(sParaNew);
		sign = params.get("sign");
		System.out.println("服务器接收:" + preSignStr);
		String serviceVeryfySign = MD5Util.getInstance().md5(preSignStr);
		return sign.equals(serviceVeryfySign);

	}

	/**
	 * 除去数组中的空值和签名参数
	 * 
	 * <p>
	 * Title: paraFilter
	 * </p>
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param sArray
	 * @return
	 * 
	 * @author 夏侯衡
	 * @date 2018年10月19日
	 */
	private static Map<String, String> paraFilter(Map<String, String> sArray) {
		Map<String, String> result = new HashMap<String, String>();
		if (sArray == null || sArray.size() <= 0) {
			return result;
		}
		for (String key : sArray.keySet()) {
			String value = sArray.get(key);
			if (value == null || value.equals("") || key.equalsIgnoreCase("sign")) {
				continue;
			}
			result.put(key, value);
		}
		return result;
	}

	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * <p>
	 * Title: createLinkString
	 * </p>
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 * 
	 * @author 夏侯衡
	 * @date 2018年10月19日
	 */
	private static String createLinkString(Map<String, String> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		String prestr = "";
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);
		    prestr = prestr + key + "=" + value + "&";
		}
		return prestr+"key="+H5_LOGINKEY;
	}

	public static String createSign(Map<String, String> params) {
		for (String key : params.keySet()) {
			String value = params.get(key);
			if (StringUtils.isNoneBlank(value)) {
				params.put(key, HtmlUtils.htmlUnescape(value));
			}
		}
		// 过滤空值
		Map<String, String> sParaNew = paraFilter(params);
		// 获取待签名字符串
		String preSignStr = createLinkString(sParaNew);
		return MD5Util.getInstance().md5(preSignStr);
	}
}
