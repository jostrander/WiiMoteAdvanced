package com.jostrander.wiimoteadvanced;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JDialog;

public class WiiMoteAdvanced {
	public static ArrayList<JDialog> screens = new ArrayList<JDialog>();

	public static void main(String[] args) {
		/*
		 * We need to know a few things before we can run the program. 1. How
		 * Many Displays? Which one is going to be used? 2. Where does the GUI
		 * need to go? Load from preferences. or default to lower right; 3. Now
		 * load the libraries. 4. Load the GUI. 5. Wait for user input.
		 */
		System.loadLibrary("wiiuse");
		System.loadLibrary("wiiusej");
		// Screen and preferences here.
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		if (gs.length < 1)
			System.exit(0);
		if (gs.length == 1) {
			// Only one display, so can only be shown on the main display...so
			// do that here.
			int height = gs[0].getDisplayMode().getHeight();
			int width = gs[0].getDisplayMode().getWidth();
			String idstring = gs[0].getIDstring();
			System.out.println("1 Graphics Device Found.");
			System.out.println(width + "x" + height + " " + idstring);

		} else {
			// check prefs here to see if anything has changed, if not select
			// previous setup.
			// if changed, prompt again.
			for (int i = 0; i < gs.length; i++) {
				Rectangle bounds = gs[i].getDefaultConfiguration().getBounds();
				new screenSelector(i, bounds);
			}
		}
		GUI.init();
		WiimoteManager.connect();
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
