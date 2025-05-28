package buttons;

import java.awt.Graphics2D;

import main.GameScreen;

public class ButtonManager {
	
	GameScreen gs;
	public HitButton hb;
	public StandButton sb;
	public DealButton db;
	
	
	public ButtonManager(GameScreen gs) {
		this.gs = gs;
		
		hb = new HitButton();
		sb = new StandButton();
		db = new DealButton();
	}
	
	public void drawButton(Graphics2D g2, SuperButton button) {
		g2.drawImage(button.image, button.x, button.y, button.width, button.height, null);
	}
	
	public void drawAllButtons(Graphics2D g2) {
		drawButton(g2, hb);
		drawButton(g2, sb);
		drawButton(g2, db);

	}
}
