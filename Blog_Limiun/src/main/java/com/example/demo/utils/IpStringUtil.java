package com.example.demo.utils;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * ip字符串工具
 * 
 * @author ynb
 */
public class IpStringUtil {
	private IpStringUtil() {
	}

	/**
	 * 获得Http请求中获取请求的实际IP地址
	 * @param request
	 * @return
	 */
	public static String getRemoteIP(HttpServletRequest request) {
		String ip =null;
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Forwarded-For");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip != null) {
			//对于通过多个代理的情况，最后IP为客户端真实IP,多个IP按照','分割
			int position = ip.indexOf(",");
			if (position > 0) {
				ip = ip.substring(0, position);
			}
		}
		return ip;
	}
	/**
	 * 判断ip1是否是ip2,ip1可以为正则表达式
	 */
	public static boolean is(String ip1, String ip2) {
		if (ip1 == ip2) {
			return true;
		}
		if (ip1 == null || ip2 == null) {
			return false;
		}
		if (ip1.equals(ip2)) {
			return true;
		}
		return ip2.matches(ip1);
	}

	/**
	 * 将ip字符串列表转换成set集合
	 * 
	 * @param ipList ip列表
	 * @return ip字符串集合
	 */
	public static Set<String> toSet(String ipList) {
		String[] ips = ipList.split(";|；");
		HashSet<String> set = new HashSet<>(ips.length * 2);
		for (String ip : ips) {
			set.add(ip);
		}
		return set;
	}

	/**
	 * 判断ip字符串列表中是否包含指定ip,ip字符串列表中可以配置正则
	 * 
	 * @param ipList ip字符串列表
	 * @param ip     指定ip
	 * @return true表示包含，false表示不包含
	 */
	public static boolean contains(String ipList, String ip) {
		if(StringUtils.hasText(ip)) {
			String[] ips = ipList.split(";|；");
			for (String ip1 : ips) {
				if (is(ip, ip1)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 判断ip字符串列表中是否包含指定ip,ip字符串列表中可以配置正则
	 * 
	 * @param ipList ip字符串列表
	 * @param ip     指定ip
	 * @return true表示包含，false表示不包含
	 */
	public static boolean contains(Collection<String> ipList, String ip) {
		for (String ip1 : ipList) {
			if (is(ip, ip1)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 检查指定ip是否在指定ip白名单列表中，如果白名单为空，则返回true
	 * 
	 * @param allowIpList ip白名单列表
	 * @param ip          指定ip
	 * @return true表示包含，false表示不包含
	 */
	public static boolean containsAllowIP(String allowIpList, String ip) {
		if (StringUtils.hasText(allowIpList)) {
			return contains(allowIpList, ip);
		}
		return true;
	}
}
