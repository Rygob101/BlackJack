package buttons;

import java.io.IOException;

import javax.imageio.ImageIO;

public class PlusMinusButton extends SuperButton{
	int value;
	
	public PlusMinusButton() {
		
		x = 700;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/buttons/PlusMinus.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		scale = 3;
		width = scale * 60;
		height = scale * 20;
	}
}
