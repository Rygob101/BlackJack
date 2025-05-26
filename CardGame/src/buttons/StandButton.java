package buttons;

import java.io.IOException;

import javax.imageio.ImageIO;

public class StandButton extends SuperButton{

	public StandButton() {
		x = 100;
		y = 320;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/buttons/Stand.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		scale = 3;
		width = 60 * scale;
		height = 20 * scale;
	}
}
