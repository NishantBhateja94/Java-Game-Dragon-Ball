package game_intro;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteLoader {
	BufferedImage img;
	//BufferedImage power;
	public void loadImage(){
		try {
			img = ImageIO.read(SpriteLoader.class.getResource("gok.png"));
			//power=ImageIO.read(SpriteLoader.class.getResource("power.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedImage[] fireAttack(){
		BufferedImage buf [] = new BufferedImage[5];
		buf[0] = img.getSubimage(6, 63, 55, 67);
		buf[1] = img.getSubimage(76, 11, 45, 90);
		buf[2] = img.getSubimage(135, 12, 70, 66);
		buf[3] = img.getSubimage(214, 50, 63, 59);
		buf[4] = img.getSubimage(297, 46, 49, 68);
//		buf[5] = img.getSubimage(260, 109, 32, 32);
//		buf[6] = img.getSubimage(293, 110, 32, 30);
//		buf[7] = img.getSubimage(326, 102, 55, 46);
		
		
		
		return buf;
		
	}
	
	
	public BufferedImage[] standingMoves(){
		BufferedImage buf [] = new BufferedImage[1];
//		buf[0] = img.getSubimage(0, 208, 54, 100);
//		buf[1] = img.getSubimage(119, 210, 56, 96);
//		buf[2] = img.getSubimage(0, 208, 54, 100);
	buf[0] = img.getSubimage(325, 319, 44, 84);
		//buf[1] = img.getSubimage(373, 320, 47, 83);
//		buf[5] = img.getSubimage(246, 13, 66, 36);
		
		
		return buf;
		
	}
	
	public BufferedImage[] PowerUp(){
		BufferedImage buf[] = new BufferedImage[3];
		buf[0] = img.getSubimage(0, 208, 54, 100);
	    buf[1] = img.getSubimage(119, 210, 56, 96);
	buf[2] = img.getSubimage(0, 208, 54, 100);
		return buf;
}
	public BufferedImage[] LoadFire(){
		BufferedImage buf[] = new BufferedImage[2];
		buf[0] = img.getSubimage(161, 333, 49, 70);
		buf[1] = img.getSubimage(100, 332, 57, 72);
		return buf;
	}
}