package com.example.demo.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String formact_ss = "yyyy-MM-dd HH:mm:ss";
	public static String formact_mm = "yyyy-MM-dd HH:mm";
	public static String formact_dd = "yyyy-MM-dd";
	public static String formact_mmss = "yyyy-MM-dd";

	/**
	 * 时间转换
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date format(String dateStr) {
		if (StringUtils.isNotBlank(dateStr)) {
			SimpleDateFormat formatter = new SimpleDateFormat(formact_ss);
			try {
				return formatter.parse(dateStr);
			} catch (ParseException e) {
				SimpleDateFormat formattermm = new SimpleDateFormat(formact_mm);
				try {
					return formattermm.parse(dateStr);
				} catch (ParseException e1) {
					SimpleDateFormat formatterdd = new SimpleDateFormat(formact_dd);
					try {
						return formatterdd.parse(dateStr);
					} catch (ParseException e2) {
						return null;
					}
				}
			}
		}
		return null;

	}

	public static String format(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat formatter = new SimpleDateFormat(formact_ss);
		return formatter.format(date);

	}

	public static String loadNow() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(formact_mmss);
		return formatter.format(date);
	}

	/**
	 * 时间戳字符串格式化
	 * 
	 * <p>
	 * Title: format
	 * </p>
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param dateLong
	 *            时间戳字符串
	 * @param format
	 *            yyyy-MM-dd HH:mm:ss
	 * @return
	 * 
	 * @author 夏侯衡
	 * @date 2018年12月12日
	 */
	public static String format(String dateLong, String format) {
		if (StringUtils.isBlank(dateLong))
			return "";
		Long time;
		try {
			time = Long.valueOf(dateLong);
			if(time<1)
				return "";
			if (dateLong.length() == 10)
				time = time * 1000;
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			 Calendar instance = Calendar.getInstance();
		        instance.setTimeInMillis(time);
			return formatter.format(instance.getTime());
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 获取指定时间的当月第一天
	 * 
	 * <p>
	 * Title: firstDayForMonth
	 * </p>
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param theDate
	 * @return
	 */
	public static Date firstDayOfMonth(Date theDate) {
		// 规定返回日期格式
		SimpleDateFormat sf = new SimpleDateFormat(formact_ss);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(theDate);
		// 设置为第一天
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		String day_first = sf.format(calendar.getTime());
		// 打印本月第一天
		System.out.println("这个月第一天:" + day_first + "---" + calendar.getTime().getTime());
		return calendar.getTime();
	}

	/**
	 * 获取指定日期的当月最后一天
	 * 
	 * <p>
	 * Title: endDayForMonth
	 * </p>
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param theDate
	 * @return
	 */
	public static Date lastDayOfMonth(Date theDate) {
		// 获取Calendar
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(theDate);
		// 设置日期为本月最大日期
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		// 设置日期格式
		SimpleDateFormat sf = new SimpleDateFormat(formact_ss);
		String ss = sf.format(calendar.getTime());
		System.out.println("这个月最后一天:" + ss + "---" + calendar.getTime().getTime());
		return calendar.getTime();
	}

	public static Date loadToday() {
		// 获取Calendar
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		// 设置日期为本月最大日期
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取过去时间
	 * 
	 * @param dateType
	 *            日期类型
	 * @param date
	 *            日期
	 * @return
	 */
	public static Date setStartDate(int dateType, int date) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(dateType, date);
		Date m = c.getTime();
		return m;
	}

	/**
	 * 获取零晨时间
	 * 
	 * @param date
	 *            时间
	 * @return
	 */
	public static Date getZeroMorning(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date zero = calendar.getTime();
		return zero;
	}

	/**
	 * 比较时间是否是同一天
	 * 
	 * <p>
	 * Title: sameDate
	 * </p>
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 * 
	 * @author 夏侯衡
	 * @date 2019年4月11日
	 */
	public static boolean sameDay(Date d1, Date d2) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		// fmt.setTimeZone(new TimeZone()); // 如果需要设置时间区域，可以在这里设置
		return fmt.format(d1).equals(fmt.format(d2));
	}

	/**
	 * 两个时间相差得天数
	 * 
	 * <p>
	 * Title: differentDays
	 * </p>
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * 
	 * @author 夏侯衡
	 * @date 2019年4月11日
	 */
	public static int differentDays(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int day1 = cal1.get(Calendar.DAY_OF_YEAR);
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);

		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		if (year1 != year2) // 不同年
		{
			int timeDistance = 0;
			for (int i = year1; i < year2; i++) {
				if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) // 闰年
				{
					timeDistance += 366;
				} else // 不是闰年
				{
					timeDistance += 365;
				}
			}

			return timeDistance + (day2 - day1);
		} else // 同一年
		{
			return day2 - day1;
		}
	}

	/**
	 * 获取到今天的最后一秒 23:59:59
	 * 
	 * <p>
	 * Title: getTodayEndSS
	 * </p>
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * 
	 * @author 夏侯衡
	 * @date 2019年4月12日
	 */
	public static Date loadTodayEndSS() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		// 设置日期为本月最大日期
		// calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static void main(String[] args) {
		System.out.println(DateUtil.format(DateUtil.loadTodayEndSS()));
	}

}
