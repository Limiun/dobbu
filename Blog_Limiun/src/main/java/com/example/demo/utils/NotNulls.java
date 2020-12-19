package com.example.demo.utils;

public class NotNulls {
	
	private NotNulls() {}
	
	public static <T> T select(T o1,T o2) {
		if(o1!=null)return o1;
		if(o2!=null)return o2;
		throw new NullPointerException();
	}
	
	public static Byte select(Byte b) {
		return select(b,(byte)0);
	}
	
	public static Short select(Short s) {
		return select(s,(short)0);
	}
	
	public static Integer select(Integer i) {
		return select(i,0);
	}
	
	public static Long select(Long l) {
		return select(l,0L);
	}
	
	public static Float select(Float f) {
		return select(f,0F);
	}
	
	public static Double select(Double d) {
		return select(d,0D);
	}
	
	public static Character select(Character c) {
		return select(c,' ');
	}
	
	public static String select(String s) {
		return select(s,"");
	}
	
}
