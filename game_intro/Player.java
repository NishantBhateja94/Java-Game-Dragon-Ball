package game_intro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Player extends Sprite implements GameConstants,PlayerState {
	ArrayList<Bullet> bulletList = new ArrayList<>();
	private boolean isJump ;
	private int acc;
	SpriteLoader sl = new SpriteLoader();
	BufferedImage moves[];
	BufferedImage fireAttack[];
	BufferedImage Powerup[];
	BufferedImage Loadfire[];
	int currentState ;
	//Board board;
	//Player player;
	//Bullet2 bullet;
	public int health=200;
	public void drawPlayer(Graphics g){
		if(currentState==PlayerState.MOVE){
			drawStandingMoves(g);
			}
			else
			if(currentState == PlayerState.FIRE_ATTACK){
				drawFireAttack(g);
				}
			else
				if(currentState == PlayerState.POWERUP){
					drawPower(g);
				}
				else
					if(currentState == PlayerState.LOADFIRE){
						drawload(g);
					}
	}
	
	public Player(){
		currentState = PlayerState.MOVE;
		sl.loadImage();
		 moves  = sl.standingMoves();
		 fireAttack = sl.fireAttack();
		 Powerup = sl.PowerUp();
		 Loadfire = sl.LoadFire();
		x = 122;
		w = 120;      
		h = 150;
		y = FLOOR - (h-80);
		img = new ImageIcon(Player.class.getResource(PLAYER_IMG)).getImage();
	
	}
	int load=0;
	public void LoadPower(){
		currentState=LOADFIRE;
			}
	public void drawload(Graphics g){
		g.drawImage(Loadfire[load],x,y,w,h,null);
		load++;
		if(load>1){
			load=0;
			currentState = MOVE;
		}
	}
	
	public void drawPower(Graphics g){
		
		g.drawImage(Powerup[power], x, y, w, h, null);
		power++;
		if(power>2){
			power=0;
			currentState=MOVE;
		}
	}
	int power=0;
	public void setPower(){
		currentState=POWERUP;
			
	}
	public void EnergyBar(Graphics g){
		g.setFont(new Font("Arial",Font.BOLD,20));
		//g.setFont(new Font ("Berlin Sans FB Demi",Font.BOLD,20));
		g.drawString("GOKU", GAME_WIDTH - 1150, 30);
		
		g.setColor(Color.GREEN);
		g.fillRect(100,35,health, 30);
//        if(board.isCollision2(Player player,Bullet2 bullet)){
//        	g.fillRect(100,35, 100, 30);
//        }
        	}
	
	public void setFireAttack(){
		currentState = FIRE_ATTACK;
		moveCount =0;
		fireCount = 0;
	}
	

	
	int fireCount;
	public void drawFireAttack(Graphics g){
		speed = 10;
		g.drawImage(fireAttack[fireCount], x, y, w, h, null);
		fireCount++;
		move();
		if(fireCount>4){
			fireCount=0;
			speed = 0;
			currentState = MOVE;
		}
	} 
		

   	int moveCount=0;
	public void drawStandingMoves(Graphics g){
		currentState = PlayerState.MOVE;
		fireCount = 0;
		power=0;
		g.drawImage(moves[moveCount], x, y, w, h, null);
		
		moveCount++;
		if(moveCount>0){
			moveCount=0;
		}
	}
	
	public void fire(){
		
		Bullet bullet = new Bullet(x + w, y + h /4);
		bulletList.add(bullet);
	}
	
//	public void drawPlayer(Graphics g){
//		g.drawImage(img, x, y, w, h, null);
//	}
	public void move(){
		x += speed+10;
	}
	
	public void jump(){
		if(!isJump){
		acc = -25;
		 y = y + acc;
		isJump = true;
		}
	}
	public void fall(){
		if(y<(FLOOR - (h-85))){
			acc = acc + GRAVITY;
			y = y + acc;
		}
		if(y>=(FLOOR - (h-22))){
			isJump = false;
		}
	}
}