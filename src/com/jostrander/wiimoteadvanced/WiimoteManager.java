package com.jostrander.wiimoteadvanced;

import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;


public class WiimoteManager {
	public static Boolean isConnected = false;
	public static Boolean rumbleOnConnect = false;
	public static void init() {
		if (!isConnected) {
			Wiimote[] wiimotes = WiiUseApiManager.getWiimotes(1, rumbleOnConnect);
			Wiimote wiimote;
			try {
				wiimote = wiimotes[0];
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("No Wiimotes Found!");
			}
		}
	}
}