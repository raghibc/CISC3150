package javaWork;
import java.util.Scanner;
import java.util.Random;

public class NQueens {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		char[][] chessPlace;
		
		System.out.println("Give me the number of queens you have Ill give you all the solutions");
		n = sc.nextInt();
		
		chessPlace = new char[n][n];
		
		int qElement = 0;
		int numQueens = 0;
		boolean qElementInRow = false;
		boolean[] qElementInColumn = new boolean[chessPlace.length];
		
		for(int b = 0; b < chessPlace[0].length; b++)
		{
			for(int i = 0; i < chessPlace[0].length; i++)
			{
				if(i == qElement) {
					chessPlace[0][qElement] = 'Q';
					qElementInColumn[qElement] = true;
				} 
				else
					chessPlace[0][i] = '.';
			}

			for(int j = 1; j < chessPlace.length; j++)
			{
				qElementInRow = false;
			
				for(int k = 0; k < chessPlace[j].length; k++)
				{
					if(qElementInColumn[k] == false) {
						if(k == 0) {
							if((chessPlace[j-1][k] != 'Q') && (chessPlace[j-1][k+1] != 'Q') && (qElementInRow == false))
							{
								chessPlace[j][k] = 'Q';
								qElementInRow = true;
								qElementInColumn[k] = true;
							}
							else
								chessPlace[j][k] = '.';
						}
					
						else if (k == (chessPlace[j].length - 1)) {
							if((chessPlace[j-1][k] != 'Q') && (chessPlace[j-1][k-1] != 'Q') && (qElementInRow == false))
							{
								chessPlace[j][k] = 'Q';
								qElementInRow = true;
								qElementInColumn[k] = true;
							}
							else
								chessPlace[j][k] = '.';
						}
				
						else {
							if((chessPlace[j-1][k] != 'Q') && (chessPlace[j-1][k+1] != 'Q') && (chessPlace[j-1][k-1] != 'Q') && (qElementInRow == false))
							{
								chessPlace[j][k] = 'Q';
								qElementInRow = true;
								qElementInColumn[k] = true;
							}
							else
								chessPlace[j][k] = '.';
						}
					}
					else
						chessPlace[j][k] = '.';
				}
			}
			
			for(int i = 0; i < chessPlace.length; i++) {
				
				qElementInColumn[i] = false;
				
				for(int j = 0; j < chessPlace[i].length; j++)
				{
					if(chessPlace[i][j] == 'Q')
						numQueens++;
				}
			}

			if(numQueens == chessPlace.length) {
				
				for(int i = 0; i < chessPlace.length; i++) {
					for(int j = 0; j < chessPlace[i].length; j++)
						System.out.print(chessPlace[i][j] + " ");
			
					System.out.println();
				}
			}
			
			numQueens = 0;
			qElement++;
			System.out.println();
		}
		

		sc.close();

	}
	
	
}
