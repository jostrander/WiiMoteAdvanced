package com.jostrander.wiimoteadvanced;

import com.jostrander.wiimoteadvanced.chrome.GUI;
import com.jostrander.wiimoteadvanced.helpers.ScreenManager;
import com.jostrander.wiimoteadvanced.helpers.WiimoteManager;

public class WiiMoteAdvanced {
	public static boolean isRunningFromJar = false;
	
	public static void main(String[] args) {
		System.out.println("Starting WiiMoteAdvanced...");
		//new LibraryLoader();
		System.loadLibrary("wiiuse");
		System.loadLibrary("wiiusej");
		ScreenManager.init();
		WiimoteManager.connect();
		GUI.init();
		GUI.showOptions();
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					if (WiimoteManager.isConnected) {
						WiimoteManager.requestUpdate();
					}
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		t.start();
	}
}
