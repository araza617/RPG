import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class MapTest{
	public static BufferedImage img;
	
	public static void main(String[] args) throws InterruptedException, Exception {
		MapTest();
	}
	
	public static void MapTest()throws InterruptedException, Exception{
		DrawingPanel panel = new DrawingPanel(500, 500); 
		Scanner input = new Scanner(System.in);
		Graphics pen = panel.getGraphics();
	    img = ImageIO.read(new File("map1.jpg"));
	    
	    try{
	    drawImage(img, pen);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    
		/*
		 * Issues : 
		 * 		* When the user types west when arrayCoordinats[49][number]
		 * 		  it says the user is in the southern end of the map 
		 */

		panel.setBackground(Color.black);
		//int [] coordinates = { 250,490};
		 int [] coordinates = {250,480};

		drawSquares(pen);
		//////////////////////////TEMPORARY : drawObstacles(pen);
		boolean playGame = true;
		int x = 0 , y = 0;
		positionUser(pen, x+1, y+1, coordinates);
		int [] [] mapArray = new int [50][50];
		//int [] arrayCoordinates = { 49 , 25 };
		int [] arrayCoordinates = {48,25};
		System.out.println("Array Before running the while loop");
		updateArray(mapArray);
		mapArray [arrayCoordinates[0]][arrayCoordinates[1]] = 8;
		//printArray(mapArray);
		while(playGame){
			System.out.println("Enter where you want to go : ");
			String userInput = getUserInput(input);
			if(userInput.equals("end")){
				playGame = false;
			}else{
				//Scan north , south , east , west 
			moveUser(img,userInput,pen,coordinates,mapArray,arrayCoordinates);
			//printArray(mapArray);
			}
		}
		System.out.println("Game over");
		System.out.println("Your final position is   :  " + Arrays.toString(arrayCoordinates));
	}
	public static void drawImage(BufferedImage img,Graphics pen){
		pen.drawImage(img, 0, 0, null);
	}
	public static void printArray(int [][] mapArray){
		for(int i = 0; i < mapArray.length;i++){
			for(int j = 0 ; j < mapArray.length;j++){
				System.out.print(mapArray[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void updateArray(int [][] mapArray){
		for(int i = 0; i < mapArray.length;i++){
			for(int j = 0 ; j < mapArray.length;j++){
					mapArray[i][j] = 1;
			}
		}
	}
	
	public static void moveUser(BufferedImage img,String userInput , Graphics pen , int [] coordinates , int [][] mapArray , int [] arrayCoordinates) throws InterruptedException{
		System.out.println("Array Coordinates : " + Arrays.toString(arrayCoordinates));
		if(arrayCoordinates[1]-1 < 0){
			//System.out.println("----You are at the western end of the map----");
		}else{
		if ( userInput.equals("west")){
			arrayCoordinates[1] -= 1;
			mapArray [arrayCoordinates[0]][arrayCoordinates[1]] = 8;
		//	eraseUser(pen,coordinates[0],coordinates[1]);
			drawImage(img, pen);
			drawSquares(pen);
			positionUser(pen, -10, 0,coordinates);
		}
		}
		
		if(arrayCoordinates[0]-1 < 0){
			//System.out.println("----You are at the nothern end of the map----");
		}else{
		if(userInput.equals("north")){
			arrayCoordinates[0] -= 1;
			mapArray [arrayCoordinates[0]][arrayCoordinates[1]] = 8;
		//	eraseUser(pen,coordinates[0],coordinates[1]);
			drawImage(img, pen);
			drawSquares(pen);
			positionUser(pen,0, -10,coordinates);
		}
		}
		
		if(arrayCoordinates[0]+1 >49){
			//System.out.println("----You are at the southern end of the map----");
		}else {
		if ( userInput.equals("south")){
			arrayCoordinates[0] += 1;
			mapArray [arrayCoordinates[0]][arrayCoordinates[1]] = 8;
		//	eraseUser(pen, coordinates[0], coordinates[1]);
			drawImage(img, pen);
			drawSquares(pen);
			positionUser(pen, 0, 10,coordinates);
		}
		//}
		
		
		if(arrayCoordinates[1]+1 > 50){
			//System.out.println("----You are at the eastern end of the map----");
		}else{
		if ( userInput.equals("east")){
			arrayCoordinates[1] += 1;
			mapArray [arrayCoordinates[0]][arrayCoordinates[1]] = 8;
		//	eraseUser(pen,coordinates[0],coordinates[1]);
			drawImage(img, pen);
			drawSquares(pen);
			positionUser(pen, 10, 0,coordinates);
		}
		}
		}
	}
	
	public static void eraseUser(Graphics pen,int x ,int y ) throws InterruptedException{
		System.out.println("Erasing : at X:- "+x+" at Y:- "+y);
		pen.setColor(Color.BLACK);
		pen.fillOval(x, y, 8, 8);
		
		}
	private static String getUserInput(Scanner input){
		String decision = input.nextLine();
		decision = decision.trim().toLowerCase();
		return decision;
	}
	
	public static void drawObstacles(Graphics pen){		
		pen.setColor(Color.ORANGE);
		pen.fillRect(10 , 30 , 10, 10);
		pen.fillRect(20 , 30 , 10, 10);
		pen.fillRect(30 , 30 , 10, 10);
		pen.fillRect(30 , 20 , 10, 10);
		pen.fillRect(20 , 30 , 10, 10);
		pen.fillRect(30 , 40 , 10, 10);
		pen.fillRect(20 , 40 , 10, 10);
		pen.fillRect(10 , 20 , 10, 10);
		pen.fillRect(40 , 30 , 10, 10);
		pen.fillRect(40 , 40 , 10, 10);
		pen.fillRect(30 , 50 , 10, 10);
	}
	
	private static void drawSquares(Graphics pen) {
		pen.setColor(Color.RED);
		for (int j = 0; j < 50; j++) {
			for (int i = 0; i < 50; i++) {
				pen.drawRect(10 * i, 10 * j, 10, 10);
			}
		}
	}
	
	
	private static void positionUser(Graphics pen,int x , int y,int [] coordinates) throws InterruptedException{
			pen.setColor(Color.BLUE);
			coordinates[0] += x;
			coordinates[1] += y;			
			pen.fillOval(coordinates[0],coordinates[1], 8, 8);
			System.out.println("Coordnates Array : " + Arrays.toString(coordinates));
		//	System.out.println("Coordinates : X - " + coordinates[0] + " Y - " + coordinates[1]);
	}

}
