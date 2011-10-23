package com.jostrander.wiimoteadvanced;

public class WiiMoteAdvanced {
	public static void main(String[] args) {
		/*
		 * We need to know a few things before we can run the program. 1. How
		 * Many Displays? Which one is going to be used? 2. Where does the GUI
		 * need to go? Load from preferences. or default to lower right; 3. Now
		 * load the libraries. 4. Load the GUI. 5. Wait for user input.
		 */
		System.loadLibrary("wiiuse");
		System.loadLibrary("wiiusej");
		GUI.init();
		WiimoteManager.init();
	}
}
