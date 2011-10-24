package com.jostrander.wiimoteadvanced;

import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;

import com.jostrander.wiimoteadvanced.listeners.WiiMouseListener;


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
				wiimote.addWiiMoteEventListeners(new WiiMouseListener());
				
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
	public static void enableIR() {
		wiimote.activateIRTRacking();
	}
	public static void disableIR() {
		wiimote.deactivateIRTRacking();
	}
	public static void startRumble() {
		wiimote.activateRumble();
	}
	public static void stopRumble() {
		wiimote.deactivateRumble();
	}
}