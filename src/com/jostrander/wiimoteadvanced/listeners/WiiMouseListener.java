package com.jostrander.wiimoteadvanced.listeners;

import java.awt.Rectangle;

import wiiusej.values.IRSource;
import wiiusej.wiiusejevents.physicalevents.IREvent;
import wiiusej.wiiusejevents.physicalevents.MotionSensingEvent;
import wiiusej.wiiusejevents.physicalevents.WiimoteButtonsEvent;

import com.jostrander.wiimoteadvanced.helpers.MouseController;
import com.jostrander.wiimoteadvanced.helpers.ScreenManager;
import com.jostrander.wiimoteadvanced.helpers.WiimoteManager;

public class WiiMouseListener extends DefaultListener {

	@Override
	public void onButtonsEvent(WiimoteButtonsEvent e) {
		if (!e.isButtonAHeld() && !e.isButtonBHeld()) {
			if (e.isButtonAPressed()) {
				MouseController.click(false);
			} else if (e.isButtonBPressed()) {
				MouseController.click(true);
			}
		}
	}
	public WiiMouseListener() {
		WiimoteManager.enableIR();
	}
	@Override
	public void onIrEvent(IREvent e) {
		Rectangle r = ScreenManager.currentScreenRect;
		IRSource[] list = e.getIRPoints();
		if (list.length > 0) {
			int x1 = (int) list[0].getX();
			int y1 = (int) list[0].getY();
			System.out.println(x1+" "+y1);
			int mousex = (int) Math.round(((double) x1 / r.width) * r.width)+r.x;
			int mousey = (int) Math.round(((double) y1 / r.height) * r.height)+r.y;
			System.out.println(mousex+" "+mousey);
			MouseController.moveMouse(mousex, mousey);
		}
	}

	@Override
	public void onMotionSensingEvent(MotionSensingEvent arg0) {
		// TODO Auto-generated method stub
		super.onMotionSensingEvent(arg0);
	}
}
