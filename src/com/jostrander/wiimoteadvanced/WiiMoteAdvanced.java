package com.jostrander.wiimoteadvanced;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JDialog;

public class WiiMoteAdvanced {
	public static ArrayList<JDialog> screens = new ArrayList<JDialog>();
	public static boolean isRunningFromJar = false;
	public static int SystemBIT = 0;
	public static void main(String[] args) {
		/*
		 * We need to know a few things before we can run the program. 1. How
		 * Many Displays? Which one is going to be used? 2. Where does the GUI
		 * need to go? Load from preferences. or default to lower right; 3. Now
		 * load the libraries. 4. Load the GUI. 5. Wait for user input.
		 */
		URL pathCheckURL = WiiMoteAdvanced.class.getResource("WiiMoteAdvanced.class");
		String pathCheckString = pathCheckURL.toString();
		String pathtome = ClassLoader.getSystemClassLoader().getResource(".").getPath();
		if (pathCheckString.startsWith("jar:")) {
			//Find the libraries and extract them;
			if (System.getProperty("sun.arch.data.model").equals("32")) {
				System.setProperty("java.library.path", pathtome+"x86/");
			}
			if (System.getProperty("sun.arch.data.model").equals("64")) {
				System.setProperty("java.library.path", pathtome+"x64/");
			}
			isRunningFromJar = true;
		} else {
			if (System.getProperty("sun.arch.data.model").equals("32")) {
				System.setProperty("java.library.path", pathtome+"com/wiiuse/x86/");
			}
			if (System.getProperty("sun.arch.data.model").equals("64")) {
				System.setProperty("java.library.path", pathtome+"com/wiiuse/x64/");
			}
		}
		System.out.println(System.getProperty("java.library.path"));
		System.loadLibrary("wiiuse");
		System.loadLibrary("wiiusej");
		// Screen and preferences here.
		//GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//GraphicsDevice[] gs = ge.getScreenDevices();
		/*if (gs.length < 1)
			System.exit(0);
		if (gs.length == 1) {
			// Only one display, so can only be shown on the main display...so
			// do that here.
			int height = gs[0].getDisplayMode().getHeight();
			int width = gs[0].getDisplayMode().getWidth();
			String idstring = gs[0].getIDstring();
			WiimoteManager.connect();
		} else {
			// check prefs here to see if anything has changed, if not select
			// previous setup.
			// if changed, prompt again.
			for (int i = 0; i < gs.length; i++) {
				Rectangle bounds = gs[i].getDefaultConfiguration().getBounds();
				new screenSelector(i, bounds);
			}
			WiimoteManager.connect();
		}*/
		WiimoteManager.connect();
		GUI.init();
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					WiimoteManager.requestUpdate();
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
