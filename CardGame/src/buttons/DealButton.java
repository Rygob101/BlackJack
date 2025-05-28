package buttons;

import java.io.IOException;

import javax.imageio.ImageIO;

	public class DealButton extends SuperButton{
		
		public DealButton() {
		x = 700;
		y = 220;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/buttons/Deal.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		scale = 3;
		width = scale * 60;
		height = scale * 20;
	}
}