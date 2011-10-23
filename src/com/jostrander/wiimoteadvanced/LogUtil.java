package com.jostrander.wiimoteadvanced;

public class LogUtil {
	public static boolean logging = true;
	public static void Log(String e) {
		if (logging == true)
			System.out.println(e);
	}
}
