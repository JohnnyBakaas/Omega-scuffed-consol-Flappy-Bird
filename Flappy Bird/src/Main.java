import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Main {

	
	public static void main(String[] args) throws InterruptedException {
		
		new MyFrame();
		
		boolean[][] bord = new boolean[10][19];
		boolean[] spiller = new boolean[10];
		spiller[5] = true; //start posisjon
		boolean inGame = true;
		
		int score = 0;
		
		int teller = 6;
		
		
		
		
		
		while (inGame) {
			if (spiller[9]) {inGame = false; break;}
			
			
			TimeUnit.MILLISECONDS.sleep(400);
			
			tyngdekraftPåSpiller(spiller, tyngdekraft());
			
			if (teller == 6) {
				spawnObstructians(bord);
				teller = 0;
			} else {teller++;}
			
			
			
			spillerOpp(spiller, MyFrame.testBooleanFraGUI);
			
			denVanskeligeDelen(bord);
			score++;
			
			newFrame();
			System.out.println("Score " + score);
			drawFrame(bord, spiller);
			System.out.println();
			System.out.println("--------------------");
			inGame = playerDetection(bord, spiller);
			MyFrame.testBooleanFraGUI = false;
		}
		
		
		newFrame();
		drawFrame(bord, spiller);
		System.out.println();
		System.out.println("--------------------");
		
		System.out.println("Game Over! Endelig score: " + score);
	}
	
	public static boolean playerDetection (boolean[][] bord, boolean[] spiller) {
		boolean duErDrit = true;
		for (int i = 0; i < 10; i++) {
			if (bord[i][0]==true && spiller[i]==true) {
				duErDrit = false;
			}
		}
		return duErDrit;
	}
	public static void newFrame() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	public static void drawFrame(boolean[][] bord, boolean[] spiller) {
		for (int i = 0; i < 10; i++) {
			System.out.println();
			if (spiller[i]) {System.out.print("O");} else {System.out.print(" ");}
			
			for (int j = 0; j < 19; j++) {
				if (bord[i][j]) {System.out.print("H");} else {System.out.print(" ");}
				
			}
			
		}
		
		
	}
	public static int tyngdekraft() {
		return 1;
	}
	public static void tyngdekraftPåSpiller(boolean[] spiller, int tyngdeKraft) {
		for (int i = 0; i < spiller.length; i++) {
			
			if (spiller[i]) {
				spiller[i] = false;
				spiller[i+1] = true;
				break;
			}
		}
	}
	public static void denVanskeligeDelen (boolean[][] bord) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 18; j++) {
				bord[i][j] = bord[i][j+1];
			}
			bord[i][18] = false;
		}
	}
	public static void spillerOpp (boolean[] spiller, boolean opp) {
		if (opp) {
			if (spiller[0]) {}
			else {
				for (int i = 1; i < 9; i++) {
					if (spiller[i]) {
						spiller [i] = false;
						spiller[i-2] = true;
					}
					
				}
			}
		}
	}
	public static void spawnObstructians (boolean[][] bord) {
		Random rand = new Random();
		int x = rand.nextInt(8)+1;
		for (int i = 0; i < 10; i++) {
			bord[i][18] = true;
		}
		bord[x-1][18] = false;
		bord[x][18] = false;
		bord[x+1][18] = false;
		
	}
	
	
}
