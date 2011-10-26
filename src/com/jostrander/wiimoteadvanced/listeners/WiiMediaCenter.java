package com.jostrander.wiimoteadvanced.listeners;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import wiiusej.wiiusejevents.physicalevents.WiimoteButtonsEvent;

public class WiiMediaCenter extends DefaultListener {
	Robot robot;

	@Override
	public void onButtonsEvent(WiimoteButtonsEvent e) {
		try {
			robot = new Robot();
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		if (!e.isButtonBHeld()) {
			if (e.isButtonLeftPressed()) {
				robot.keyPress(KeyEvent.VK_LEFT);
				robot.keyRelease(KeyEvent.VK_LEFT);
			}
			if (e.isButtonRightPressed()) {
				robot.keyPress(KeyEvent.VK_RIGHT);
				robot.keyRelease(KeyEvent.VK_RIGHT);
			}
			if (e.isButtonUpPressed()) {
				robot.keyPress(KeyEvent.VK_UP);
				robot.keyRelease(KeyEvent.VK_UP);
			}
			if (e.isButtonDownPressed()) {
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
			}
			if (e.isButtonAPressed()) {
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			}
		} else {
			if (e.isButtonLeftPressed()) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_B);
				robot.keyRelease(KeyEvent.VK_B);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}
			if (e.isButtonRightPressed()) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_F);
				robot.keyRelease(KeyEvent.VK_F);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}
			if (e.isButtonUpPressed()) {
				robot.keyPress(KeyEvent.VK_F10);
				robot.keyRelease(KeyEvent.VK_F10);
			}
			if (e.isButtonDownPressed()) {
				robot.keyPress(KeyEvent.VK_F9);
				robot.keyRelease(KeyEvent.VK_F9);
			}
		}
	}
}
