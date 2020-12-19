package com.example.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 处理login =》 boot 的验证
 * 
 * @author zhoucheng
 *
 */
@Component
public class SjKeyVaildService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public String H5_LOGINKEY = "de4738c57fdaeeafac85389bf463a5c3";

	/**
	 * 创建签
	 * 
	 * @param uid
	 * @param agent
	 * @param time
	 * @param ad
	 * @return
	 */
	public String createShengjieLoginSign(String uid, String agent, String time, String ad) {
		String str = uid + agent + time + ad + H5_LOGINKEY;
		return MD5Util.getInstance().md5(str);
	}

	/**
	 * 验签
	 * 
	 * @param uid
	 * @param agent
	 * @param time
	 * @param sign
	 * @param ad
	 * @return
	 */
	public Boolean isVaildShengjieLoginSign(String uid, String agent, String time, String sign, String ad) {

		String str = uid + agent + time + ad + H5_LOGINKEY;
		String key = MD5Util.getInstance().md5(str);
		if (sign.equals(key)) {
			return true;
		}
		return false;
	}

}