package buttons;

import java.awt.Graphics2D;

import chips.GreenChip;
import chips.RedChip;
import chips.WhiteChip;
import main.GameScreen;

public class ButtonManager {
	
	GameScreen gs;
	public HitButton hb;
	public StandButton sb;
	public DealButton db;
	public PlusMinusButton pm1;
	public PlusMinusButton pm2;
	public PlusMinusButton pm3;
	public WhiteChip wc;
	public RedChip rc;
	public GreenChip gc;
	public BetButton bb;
	
	
	public ButtonManager(GameScreen gs) {
		this.gs = gs;
		
		hb = new HitButton();
		sb = new StandButton();
		db = new DealButton();
		pm1 = new PlusMinusButton();
		pm1.y = 300;
		pm1.value = 1;
		pm2 = new PlusMinusButton();
		pm2.y = 370;
		pm2.value = 5;
		pm3 = new PlusMinusButton();
		pm3.y = 440;
		pm3.value = 10;
		wc = new WhiteChip();
		rc = new RedChip();
		gc = new GreenChip();
		bb = new BetButton();
	}
	
	public void drawButton(Graphics2D g2, SuperButton button) {
		g2.drawImage(button.image, button.x, button.y, button.width, button.height, null);
	}
	
	public void drawAllButtons(Graphics2D g2) {
		drawButton(g2, hb);
		drawButton(g2, sb);
		drawButton(g2, db);
		drawButton(g2, pm1);
		drawButton(g2, pm2);
		drawButton(g2, pm3);
		wc.draw(g2);
		rc.draw(g2);
		gc.draw(g2);
		drawButton(g2, bb);
	}
}
