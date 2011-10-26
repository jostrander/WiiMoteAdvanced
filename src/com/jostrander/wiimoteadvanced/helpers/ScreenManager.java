package com.jostrander.wiimoteadvanced.helpers;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JDialog;
import javax.swing.JLabel;

import com.jostrander.wiimoteadvanced.runtimePrefs;

public class ScreenManager {
	public static int currentScreen = -1;
	public static Rectangle currentScreenRect;
	private static ArrayList<JDialog> sdialogs = new ArrayList<JDialog>();

	public static void init() {
		System.out.println("Screen Manager Initializing...");
		if (runtimePrefs.prefs.getInt("currentScreen", -1) > -1) {
			currentScreen = runtimePrefs.prefs.getInt("currentScreen", -1);
		} else {
			selectScreen();
		}
		System.out.println("Selected Screen:"+currentScreen);
	}
	public static void selectScreen() {
		ScreenSelector();
	}

	private static void ScreenSelector() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		int i=0;
		for (GraphicsDevice gd : gs) {
			sdialogs.add(screen(gd.getDefaultConfiguration().getBounds(), i));
			gd.getDefaultConfiguration().getBounds();
			i++;
		}
	}
	private static JDialog screen(Rectangle r, final int Device) {
		JDialog something = new JDialog();
		JLabel label = new JLabel("<html><br>Click Here to use the Wiimote on this Screen.</html>");
		label.setForeground(Color.WHITE);
		something.setUndecorated(true);
		something.setAlwaysOnTop(true);
		something.setBackground(new Color(0,0,0,120));
		something.setSize(r.width,r.height);
		something.setLocation(r.x,r.y);
		something.add(label);
		something.setVisible(true);
		something.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				runtimePrefs.prefs.putInt("currentScreen", Device);
				currentScreen = Device;
				currentScreenRect = sdialogs.get(Device).getBounds();
				Iterator<JDialog> i = sdialogs.iterator();
				while (i.hasNext()) {
					i.next().setVisible(false);
				}
				sdialogs.clear();	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}	
		});
		return something;	
	}
}
