package game_intro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Enemy extends Sprite implements GameConstants {
	ArrayList<Bullet2> bulletList = new ArrayList<>();
	 boolean isVisible ;
	 public int health2=200;
	public Enemy(int x , Image image, int speed){
		this.x = x;
		this.img = image;
		this.y = 170;
		this.speed = speed;
		h = w = 150;
		isVisible = true;
	}
	Board board;
	public void drawEnemy(Graphics g){
		g.drawImage(img, x, y, w, h, null);
		move();
		changeDirection();
	}
	public void EnergyBar2(Graphics g){
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("VEGETA", GAME_WIDTH - 200, 30);
		g.setColor(Color.BLACK);
		g.fillRect(1000,30, health2,34);
	}
	public void move(){
		y +=speed;
	}
	public void changeDirection(){
		if(y>=(FLOOR-60)){
			speed = speed * -1;
		}
		else
		if(y<=0)
		{
			speed = speed * -1;
		}
	}
	public void fire(){
		Bullet2 bullet = new Bullet2(x + w/8, y + h /2);
		bulletList.add(bullet);
	}
}