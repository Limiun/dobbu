package com.example.demo.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;

public final class CommonUtils {

	public static <T> T defaultValue(T t, T defaultValue) {
		if (t == null)
			return defaultValue;
		return t;
	}

	/**
	 * 集合去重
	 * 
	 * <p>
	 * Title: removeDuplicate
	 * </p>
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param list
	 * @return
	 * 
	 * @author 夏侯衡
	 */
	public static List<Object> removeDuplicate(List<Object> list) {
		if (CollectionUtils.isEmpty(list))
			return list;
		HashSet<Object> h = new HashSet<Object>(list);
		list.clear();
		list.addAll(h);
		return list;
	}

	/**
	 * 数组去重
	 * 
	 * <p>
	 * Title: removeDuplicate
	 * </p>
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param arr
	 * @return
	 * 
	 * @author 夏侯衡
	 * @date 2018年11月15日
	 */
	public static Object[] removeDuplicate(Object[] arr) {
		if (arr == null || arr.length < 1)
			return arr;
		HashSet<Object> set = new HashSet<Object>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		arr = set.toArray();
		return arr;
	}

	/**
	 * 解析前端统一上传的平台&区服
	 * 
	 * <p>
	 * Title: getAgentServers
	 * </p>
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param typeAndServer
	 * @return
	 * 
	 * @author 夏侯衡
	 * @date 2018年11月16日
	 */
	public static Map<String, List<Integer>> getAgentServers(String typeAndServer) {
		Map<String, List<Integer>> typeAndServers = new HashMap<>();
		try {
			if (StringUtils.isBlank(typeAndServer)) {
				return typeAndServers;
			}
			Map<String, Object> typeAndServerMap = JSON.parseObject(typeAndServer);
			for (Map.Entry<String, Object> map : typeAndServerMap.entrySet()) {
				Map<String, Object> serverMap = JSON.parseObject(map.getValue().toString());
				List<Integer> servers = new ArrayList<>();
				Set<String> set = serverMap.keySet();
				for (String str : set) {
					servers.add(Integer.valueOf(str));
				}
				typeAndServers.put(map.getKey(), servers);
			}
			return typeAndServers;
		} catch (Exception e) {
			return typeAndServers;
		}

	}

	/**
	 * 设置下载文件中文件的名称
	 * 
	 * @param filename
	 * @param request
	 * @return
	 */
	public static String encodeFilename(String filename, HttpServletRequest request) {
		/**
		 * 获取客户端浏览器和操作系统信息 在IE浏览器中得到的是：User-Agent=Mozilla/4.0 (compatible; MSIE 6.0;
		 * Windows NT 5.1; SV1; Maxthon; Alexa Toolbar)
		 * 在Firefox中得到的是：User-Agent=Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN;
		 * rv:1.7.10) Gecko/20050717 Firefox/1.0.6
		 */
		String agent = request.getHeader("USER-AGENT");
		try {
			if ((agent != null) && (-1 != agent.indexOf("MSIE"))) {
				String newFileName = URLEncoder.encode(filename, "UTF-8");
				newFileName = StringUtils.replace(newFileName, "+", "%20");
				if (newFileName.length() > 150) {
					newFileName = new String(filename.getBytes("GB2312"), "ISO8859-1");
					newFileName = StringUtils.replace(newFileName, " ", "%20");
				}
				return newFileName;
			}
			if ((agent != null) && (-1 != agent.indexOf("Mozilla")))
				return MimeUtility.encodeText(filename, "UTF-8", "B");

			return filename;
		} catch (Exception ex) {
			return filename;
		}
	}

	/**
	 * 
	 * 
	 * <p>
	 * Title: objToDou
	 * </p>
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param obj
	 * @return
	 * 
	 * @author 夏侯衡
	 * @date 2018年12月12日
	 */
	public static Double objToDou(Object obj) {
		if (obj == null)
			return 0D;
		// System.out.println("objToDou"+obj.toString());
		try {
			return Double.valueOf(String.valueOf(obj));
		} catch (Exception e) {
			return 0D;
		}
	}

	/**
	 * Double 保留两位小数
	 * 
	 * <p>
	 * Title: DoubleKeep2
	 * </p>
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return Double arg1/arg2
	 * 
	 * @author 夏侯衡
	 * @date 2018年12月12日
	 */
	public static Double DoubleKeep2(Double arg1, Double arg2) {
		// System.out.println("DoubleKeep2 arg1:"+arg1+"----arg2"+arg2);
		if (arg1 == null || arg2 == null || arg1 == 0 || arg2 == 0)
			return 0.00;
		BigDecimal a = new BigDecimal(arg1 / arg2);
		return a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 计算百分比
	 * 
	 * <p>
	 * Title: ADivideBPercent
	 * </p>
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param arg1
	 * @param arg2
	 * @return String arg1/arg2
	 * 
	 * @author 夏侯衡
	 * @date 2018年12月12日
	 */
	public static String ADivideBPercent(Double arg1, Double arg2) {
		// System.out.println("ADivideBPercent arg1:"+arg1+"----arg2"+arg2);
		if (arg1 == null || arg2 == null)
			return "-";
		BigDecimal a = new BigDecimal(arg1);
		BigDecimal b = new BigDecimal(arg2);
		String percent = b == null ? "-"
				: b.compareTo(new BigDecimal(0)) == 0 ? "-"
						: a == null ? "0.00%"
								: a.multiply(new BigDecimal(100)).divide(b, 2, BigDecimal.ROUND_HALF_UP) + "%";
		return percent;
	}

	/**
	 * 对象转map
	 * 
	 * <p>
	 * Title: objectToMap
	 * </p>
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 * 
	 * @author 夏侯衡
	 * @date 2019年3月21日
	 */
	public static Map<String, Object> objectToMap(Object obj) {
		if (obj == null) {
			return null;
		}

		Map<String, Object> map = new HashMap<String, Object>();

		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			field.setAccessible(true);
			try {
				if (field.getType() == Date.class) {
					Date date = (Date) field.get(obj);
					map.put(field.getName(), DateUtil.format(date));
				} else {
					map.put(field.getName(), field.get(obj) != null ? String.valueOf(field.get(obj)) : field.get(obj));
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;

	}

	public static String getRemortIP(HttpServletRequest request) {
		String Xip = request.getHeader("X-Real-IP");
		String ip = request.getHeader("x-forwarded-for");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = Xip;
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
