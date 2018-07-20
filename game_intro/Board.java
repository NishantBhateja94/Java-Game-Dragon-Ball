package game_intro;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstants{
	Image bg;
	Player player ;
	Enemy enemies;
	//	Enemy enemies[] = new Enemy[MAX_ENEMY];
	Bullet2 bullet[] = new Bullet2[5];
	Enemy enem;
	Camera camera = new Camera();
	boolean isCtrl = false;
	public Board(){
		setSize(GAME_WIDTH,GAME_HEIGHT);

		bg = new ImageIcon(Board.class.getResource(BACKGROUND)).getImage();
		player = new Player();
		prepareEnemy();
		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_SPACE){

					player.LoadPower();	
					player.fire();

				}
				
			}
			public void keyPressed(KeyEvent e){
				//				
				if(e.getKeyCode()==KeyEvent.VK_G){
					isCtrl=true;
				}
				if(e.getKeyCode()==KeyEvent.VK_F && isCtrl ){
					player.setFireAttack();
					isCtrl=false;
					if(isCollision4(player, enemies)) {
					enemies.health2--;
					}
				}
				//				if(e.getKeyCode()==KeyEvent.VK_SPACE){
				//					int delay =10;
				//					try{
				//						Thread.sleep(delay);
				//						player.fire();
				//					}
				//					catch(InterruptedException e1){
				//						e1.printStackTrace();
				//					}
				//					
				//					}
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					player.setSpeed(25);
					player.move();
					camera.right();
					//camera.move();
				}

				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					camera.left();
					camera.move();
					//System.out.println("Left...");
					player.setSpeed(-25);
					player.move();
				}
				if(e.getKeyCode() == KeyEvent.VK_UP){
					player.jump();
				}
				if(e.getKeyCode() == KeyEvent.VK_W){
					player.setPower();
					if(player.health<200)
					player.health++;
				}
			}
		});

		//player.EnergyBar(g);
		gameLoop();


	}
	boolean  isGameOver2= false;
	private boolean isGameOver3;
	private void drawBullets(Graphics g){
		for(Bullet bullet : player.bulletList){
			if(bullet.isVisible){
				bullet.drawBullet(g);
				bullet.move();
				if(isCollision3(bullet, enemies))
				{
					enemies.health2--;
				}
				if(enemies.health2==0){
					isGameOver2= true;
				repaint();
				timer.stop();
				}
			}
		}
	}
	//protected Image img = new ImageIcon(Bullet.class.getResource(BLUEFIRE)).getImage();
	ArrayList<Bullet2> bulletLists = new ArrayList<>();
	private void drawBullets2(Graphics g){
		//for(Enemy enemy : enemies){

		for(Bullet2 bullet1 : enemies.bulletList){
			//int i1=0;
			bullet1.isVisible=true;
			//			if(i1<1){
			if(bullet1.isVisible){
				bullet1.drawBullet(g);
				bullet1.move();
				bullet1.isVisible=false;
				//i1++;
				//		continue;
				System.out.println("bullet1 is moving");

				if(isCollision2(player, bullet1))
					player.health--;
				//enemies.fire();
                 if(player.health==0){
                	 isGameOver3 = true;
                                   	 
     			repaint();
     			timer.stop();
                 }
			}
		}
		
		

//
//
//		}
		//		else
		//			if(!bullet1.isVisible)
		//		{
		//		for(int i1=0;i1<10;i1++)
		//		bullet1.isVisible=true;
		//		bullet1.drawBullet(g);
//		bullet1.move();
		//		break;
		//		}




	//}



	//	for(Enemy enemy : enemies){
	//		if(enemy.isVisible){
	//		
	//		enemy.fire();
	//		}
	//	
	//	public boolean isCollision(Player player , Enemy enemy){
	//		int xDistance = Math.abs(player.getX() - enemy.getX());
	//		int yDistance = Math.abs(player.getY() - enemy.getY());
	//		return xDistance<=(player.getW()-30) && yDistance<=(player.getH()-20);
	}
	public boolean isCollision(Player player, Enemy enemy){
		Rectangle rect1 = new Rectangle(player.getX(),player.getY(),player.getW(),player.getH());
		Rectangle rect2 = new Rectangle(enemy.getX(),enemy.getY(),enemy.getW(),enemy.getH());
		return rect1.intersects(rect2);
	}
	public boolean isCollision2(Player player, Bullet2 bullet2){
		Rectangle rect1 = new Rectangle(player.getX(),player.getY(),player.getW(),player.getH());
		Rectangle rect2 = new Rectangle(bullet2.getX(),bullet2.getY(),bullet2.getW(),bullet2.getH());
		System.out.println();
		return rect1.intersects(rect2);
	}
	public boolean isCollision3(Bullet bullet,Enemy enemy){
		Rectangle rect1 = new Rectangle(bullet.getX(),bullet.getY(),bullet.getW(),bullet.getH());
		Rectangle rect2 = new Rectangle(enemy.getX(),enemy.getY(),enemy.getW(),enemy.getH());
		System.out.println();
		return rect1.intersects(rect2);
	}
	public boolean isCollision4(Player player, Enemy enemy){
		Rectangle rect1 = new Rectangle(player.getX(),player.getY(),player.getW(),player.getH());
		Rectangle rect2 = new Rectangle(enemy.getX(),enemy.getY(),enemy.getW(),enemy.getH());
		return rect1.intersects(rect2);
	}
	boolean isGameOver = false;
//	public void checkCollision(){
//		//for(Enemy enemy: enemies){
//		//boolean result = isCollision(player, enemy);
//		//if(result == true){
//		if(isCollision(player, enemies)){
//			isGameOver = true;
//			repaint();
//			timer.stop();
//		}
//	}

	//	public void checkCollision2(){
	//		for(Bullet2 bullet2: bullet){
	//			//boolean result = isCollision(player, enemy);
	//			//if(result == true){
	//			if(isCollision2(player , bullet2)){
	//		
	//			}
	//		}
	//	}

	public void gameOver3(Graphics g){
		g.setColor(Color.RED);
		g.setFont(new Font("Arial",Font.BOLD,40));
		g.drawString("You Lose", GAME_WIDTH/2, GAME_HEIGHT/2);
	}
  public void gameOver2(Graphics g){
	  g.setColor(Color.GREEN);
		g.setFont(new Font("Arial",Font.BOLD,50));
		g.drawString("You Win", GAME_WIDTH/2, GAME_HEIGHT/2);
  }
	private void prepareEnemy(){
		Image enemy = null;
		int speed = 0;
		int x = 950;
		//		for(int  i= 0; i<MAX_ENEMY; i++){

		enemy = new ImageIcon(Board.class.getResource("vegeta.png")).getImage();


		//			else
		//			{
		//					enemy = new ImageIcon(Board.class.getResource("")).getImage();
		//				
		//			}
		speed = speed + 5;
		enemies= new Enemy(x, enemy, speed);
		//x += 350;
	}
	//}

	Timer timer;
	private void gameLoop(){
		timer  = new Timer(DELAY,(e)->{
			repaint();

			player.fall();
			//checkCollision();
			//checkCollision2();
		});
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		camera.drawBG(g);
		//drawBackGround(g);
//		if(isGameOver){
//			gameOver(g);
//		}
		if(isGameOver3){
			gameOver3(g);
		}
		if(isGameOver2){
			gameOver2(g);
		}
		player.drawPlayer(g);
		drawEnemy(g);
		drawBullets(g);
		player.EnergyBar(g);
        enemies.EnergyBar2(g);
		drawBullets2(g);
		System.out.println("drawbullets2");
		//for(Enemy enemy : enemies){
		if(enemies.isVisible){

			enemies.fire();
		}

	}


	//	private void drawBackGround(Graphics g){
	//		g.drawImage(bg, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
	//	}

	private void drawEnemy(Graphics g){
		//for(Enemy enemy : enemies){drawBullets2(g);
		if(enemies.isVisible){
			enemies.drawEnemy(g);
			//enemy.fire();

		}
	}
}
//}