package com.jostrander.wiimoteadvanced;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class WiiMoteAdvanced {
	private static JDialog screens[];

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
				String idstring = gs[i].getIDstring();
				showScreenHint(i, bounds, idstring.replace('\\', ' '));
			}
		}
		GUI.init();
		WiimoteManager.connect();
		Runnable r = new Runnable() {

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
			
		};
	}

	private static void showScreenHint(int id, Rectangle r, String name) {
		try {
			screens[id] = new JDialog();
			JDialog hinter = screens[id];
			JLabel label = new JLabel("Device " + id
					+ "\nClick on a screen to select it.");
			label.setForeground(new Color(255, 255, 255));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			hinter.setUndecorated(true);
			hinter.setAlwaysOnTop(true);
			hinter.setBackground(new Color(0, 0, 0, 100));
			hinter.setLocation(r.x, r.y);
			hinter.setSize(new Dimension(r.width, r.height));
			hinter.add(label);
			hinter.setVisible(true);
		} catch (NullPointerException e) {
			System.err.println(e.getMessage());
		}
	}
}
