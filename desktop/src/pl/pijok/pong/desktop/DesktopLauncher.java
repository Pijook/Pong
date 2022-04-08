package pl.pijok.pong.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pl.pijok.pong.Pong;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Pong!";
		config.width = 640;
		config.height = 480;
		config.foregroundFPS = 60;
		config.backgroundFPS = 60;

		new LwjglApplication(new Pong(), config);
	}
}
