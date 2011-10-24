package com.jostrander.wiimoteadvanced;

import com.jostrander.wiimoteadvanced.listeners.DefaultListener;

import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;


public class WiimoteManager {
	public static Boolean isConnected = false;
	public static Boolean rumbleOnConnect = false;
	private static Wiimote wiimote;
	public static void connect() {
		if (!isConnected) {
			Wiimote[] wiimotes = WiiUseApiManager.getWiimotes(1, rumbleOnConnect);
			try {
				wiimote = wiimotes[0];
				isConnected = true;
				GUI.connectedtf.setText("Wiimote "+wiimote.getId());
				wiimote.addWiiMoteEventListeners(new DefaultListener());
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("No Wiimotes Found!");
			}
		} else {
			System.out.println("WiiMotes already Connected!");
		}
	}
	public static void requestUpdate() {
		wiimote.getStatus();
	}
}