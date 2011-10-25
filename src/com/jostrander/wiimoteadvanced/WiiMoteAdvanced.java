package com.jostrander.wiimoteadvanced;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JDialog;

import com.jostrander.wiimoteadvanced.chrome.GUI;
import com.jostrander.wiimoteadvanced.helpers.LibraryLoader;
import com.jostrander.wiimoteadvanced.helpers.WiimoteManager;

public class WiiMoteAdvanced {
	public static ArrayList<JDialog> screens = new ArrayList<JDialog>();
	public static boolean isRunningFromJar = false;
	public static int SystemBIT = 0;
	
	public static void main(String[] args) {
		new LibraryLoader();
		/*
		 * We need to know a few things before we can run the program. 1. How
		 * Many Displays? Which one is going to be used? 2. Where does the GUI
		 * need to go? Load from preferences. or default to lower right; 3. Now
		 * load the libraries. 4. Load the GUI. 5. Wait for user input.
		 */
		// Screen and preferences here.
		// GraphicsEnvironment ge =
		// GraphicsEnvironment.getLocalGraphicsEnvironment();
		// GraphicsDevice[] gs = ge.getScreenDevices();
		/*
		 * if (gs.length < 1) System.exit(0); if (gs.length == 1) { // Only one
		 * display, so can only be shown on the main display...so // do that
		 * here. int height = gs[0].getDisplayMode().getHeight(); int width =
		 * gs[0].getDisplayMode().getWidth(); String idstring =
		 * gs[0].getIDstring(); WiimoteManager.connect(); } else { // check
		 * prefs here to see if anything has changed, if not select // previous
		 * setup. // if changed, prompt again. for (int i = 0; i < gs.length;
		 * i++) { Rectangle bounds =
		 * gs[i].getDefaultConfiguration().getBounds(); new screenSelector(i,
		 * bounds); } WiimoteManager.connect(); }
		 */
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
