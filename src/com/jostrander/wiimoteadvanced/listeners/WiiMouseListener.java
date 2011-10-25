package com.jostrander.wiimoteadvanced.listeners;

import java.awt.Rectangle;

import wiiusej.wiiusejevents.physicalevents.IREvent;
import wiiusej.wiiusejevents.physicalevents.MotionSensingEvent;

import com.jostrander.wiimoteadvanced.runtimePrefs;
import com.jostrander.wiimoteadvanced.helpers.WiimoteManager;

public class WiiMouseListener extends DefaultListener {

	public WiiMouseListener() {
		WiimoteManager.enableIR();
	}
	@Override
	public void onIrEvent(IREvent e) {
		WiimoteManager.startRumble();
		Rectangle r = runtimePrefs.screenDims;
		double heightRatio = 768/r.height;
		double widthRatio = 1024/r.width;
		double x = (e.getAx()*heightRatio);
		double y = (e.getAy()*widthRatio);
		System.out.println(r.height+"x"+r.width+" "+x+"x"+y);
		WiimoteManager.stopRumble();
	}

	@Override
	public void onMotionSensingEvent(MotionSensingEvent arg0) {
		// TODO Auto-generated method stub
		super.onMotionSensingEvent(arg0);
	}
}
