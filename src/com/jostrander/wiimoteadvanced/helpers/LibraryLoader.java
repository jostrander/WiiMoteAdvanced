package com.jostrander.wiimoteadvanced.helpers;

import java.io.File;
import java.io.IOException;

public class LibraryLoader {
	public static final boolean LOADED_EMBEDDED_LIBRARY;
	
	static {
		LOADED_EMBEDDED_LIBRARY = LoadEmbeddedLibrary();
	}
	private static boolean LoadEmbeddedLibrary() {
		String arch = System.getProperty("os.arch.data.model");
		try {
			System.loadLibrary("wiiuse");
			System.loadLibrary("wiiusej");	
		} catch (UnsatisfiedLinkError e) {
			try {
				final File LibFile1 = File.createTempFile("wiiuse", ".dll");
				LibFile1.deleteOnExit();	
			} catch(UnsatisfiedLinkError ee) {
				
			} catch (IOException eee) {
				e.printStackTrace();
			}
			
		}
		return true;
	}
}
