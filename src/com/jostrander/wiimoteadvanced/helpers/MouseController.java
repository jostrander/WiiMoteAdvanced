package com.jostrander.wiimoteadvanced.helpers;

import java.awt.AWTException;
import java.awt.Robot;

public class MouseController {
	public static void moveMouse(int x, int y) {
		Robot robot;
		try {
			robot = new Robot();
			robot.mouseMove(x, y);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
