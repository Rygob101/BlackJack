package buttons;

import java.io.IOException;

import javax.imageio.ImageIO;

public class BetButton extends SuperButton{
	public BetButton() {
		x = 660;
		y = 150;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/buttons/Bet.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		scale = 3;
		width = scale * 90;
		height = scale * 20;
	}
}
