package com.jostrander.wiimoteadvanced.listeners;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import wiiusej.wiiusejevents.physicalevents.WiimoteButtonsEvent;

public class WiiPresentationListener extends DefaultListener {
	Robot robot;

	@Override
	public void onButtonsEvent(WiimoteButtonsEvent e) {
		try {
			robot = new Robot();
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		// TODO Auto-generated method stub
		if (e.isButtonLeftPressed()) {
			robot.keyPress(KeyEvent.VK_LEFT);
			robot.keyRelease(KeyEvent.VK_LEFT);
		}
		if (e.isButtonRightPressed()) {
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyRelease(KeyEvent.VK_RIGHT);
		}
	}

}
