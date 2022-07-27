package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues(); 
		getPlayerImage();
		
	}
	
	public void setDefaultValues() {
		
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}
	public void getPlayerImage () {
		
		try {
			
			jump = ImageIO.read(getClass().getResourceAsStream("/player/Jump.png"));
			run = ImageIO.read(getClass().getResourceAsStream("/player/Run.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update() {
		
		if(keyH.upPressed == true) {
			direction = "up";
			y -= speed;
		} 
		else if(keyH.leftPressed == true) {
			direction = "left";
			x -= speed;
		}
		else if(keyH.rightPressed == true) {
			direction = "right";
			x += speed;
		}
	}
	public void draw(Graphics2D g2) {
		
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize*3);

		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			image = jump;
			break;
		case "left":
			image = run;
			break;
		case "right":
			image = run;
			break;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	} 
}
