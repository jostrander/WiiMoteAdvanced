package com.jostrander.wiimoteadvanced.helpers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LibraryLoader {
	public static final boolean LOADED_EMBEDDED_LIBRARY;

	static {
		LOADED_EMBEDDED_LIBRARY = LoadEmbeddedLibrary();
	}

	private static boolean LoadEmbeddedLibrary() {
		String arch = System.getProperty("os.arch");
		new File(".").getAbsolutePath();
		try {
			if (arch == null) {
				System.out.println("nulllllllll");
			}
			if (arch.equals("i386")) {
				Extract32bit();
			} else if (arch.equals("amd64")) {
				Extract64bit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	private static void Extract64bit() {
		try {
			Unpack("x64","wiiuse");
			Unpack("x64","WiiUseJ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void Extract32bit() {
		try {
			Unpack("x86","wiiuse");
			Unpack("x86","WiiUseJ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private static void Unpack(String arch, String lib) throws IOException, UnsatisfiedLinkError {
		File temp1 = File.createTempFile(lib, ".dll",new File("."));
		temp1.deleteOnExit();
		InputStream in1 = ClassLoader.getSystemResourceAsStream("com/wiiuse/"+arch+"/"+lib+".dll");
		OutputStream out1 = new BufferedOutputStream(new FileOutputStream(temp1));
		int len = 0;
		byte[] buffer = new byte[8192];
		while ((len = in1.read(buffer)) > -1)
			out1.write(buffer, 0, len);
		out1.close();
		in1.close();
		System.out.println(temp1.getAbsolutePath());
		System.load(temp1.getAbsolutePath());
		temp1.delete();
	}
}
