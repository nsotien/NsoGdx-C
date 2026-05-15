package com.monkey.nso;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.monkey.nso.NSO;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.title = ("CUONGNSO");

		// Read window size from arg: --size=small | hd | fullhd
		String size = "small"; // default
		for (String a : arg) {
			if (a.startsWith("--size=")) {
				size = a.substring("--size=".length()).toLowerCase();
			}
		}

		if (size.equals("fullhd")) {
			config.width = 2560;
			config.height = 1440;
		} else if (size.equals("hd")) {
			config.width = 1920;
			config.height = 1080;
		} else {
			// small (default)
			config.width = 1600;
			config.height = 900;
		}

		config.resizable = false;
		config.addIcon("iconapp.png", Files.FileType.Internal);
		new LwjglApplication(new NSO(), config);
	}
}
