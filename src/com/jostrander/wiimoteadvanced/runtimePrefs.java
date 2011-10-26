package com.jostrander.wiimoteadvanced;

import java.util.prefs.Preferences;

public class runtimePrefs {
	public static Preferences prefs;
	static {
		new runtimePrefs();
	}
	runtimePrefs() {
		prefs = Preferences.userNodeForPackage(this.getClass());
	}
}
