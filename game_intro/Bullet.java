package game_intro;
import java.awt.Graphics;
import javax.swing.ImageIcon;
public class Bullet extends Sprite implements GameConstants {
	 boolean isVisible;
	 //Image imge;
	public Bullet(int x, int y){
		this.x = x ;
		this.y = y;
		this.speed = 10;
		this.w = 30;
		this.h = 30;
		this.isVisible = true;
		img = new ImageIcon(Bullet.class.getResource(POWERFIRE)).getImage();
	}
	public void outOfScreen(){
		if(x>=GAME_WIDTH){
		isVisible = false;
		}
	}
	public void move(){
		x+=speed;
		outOfScreen();
	}
	
	/*
	public void drawBullet(Graphics g){
		g.setColor(Color.BLACK);
		g.fillOval(x, y, w, h);
	}*/
	
	
	//This is done here to draw the image
	public void drawBullet(Graphics g){
		g.drawImage(img, x, y, w, h, null);
	}
}