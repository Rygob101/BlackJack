package buttons;

import java.io.IOException;

import javax.imageio.ImageIO;

public class HitButton extends SuperButton{
	
	public HitButton() {
		x = 100;
		y = 220;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/buttons/Hit.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		scale = 3;
		width = scale * 60;
		height = scale * 20;
		
	}
}
