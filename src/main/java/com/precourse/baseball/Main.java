package com.precourse.baseball;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public final static int DIGIT_COUNT = 3; //3�ڸ� �� 
	
	static Main mainObj = null;
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		mainObj = new Main();
	}
	
	//1) 1~9���� ���� �ٸ� ���� �̷���� ���� �����ϴ� �޼ҵ�
	public int[] getRandomDigitNum() {
		int digitNum[] = new int[DIGIT_COUNT];
		Random rand = new Random();
		
		for(int i = 0; i < DIGIT_COUNT; i++) {
			 int digit = rand.nextInt(9) + 1;
			 digitNum[i] = digit;
			 
			 if(i==0) { 
				 continue;
			 }
			 
			 if(digitNum[i] == digitNum[i-1]) {
				 i--;
			 }
			 
		}
		
		return digitNum;
	}
	
	// 2) ���� �Է� �޾� �迭�� �ִ´�.
	public int[] getInputDigitNum(Scanner scan) {
		int digitNum[] = new int[DIGIT_COUNT]; //����ڰ� �Է��� ���ڸ� ������ �迭
		
		System.out.print("���ڸ� �Է����ּ��� : ");
		int inputNum = scan.nextInt(); //����ڷκ��� �Է¹��� ����		
		
		int j = 0;
		for(int i=DIGIT_COUNT-1; i>=0; i--) {
			digitNum[j] = (int) (inputNum / Math.pow(10, i)); ///j��° �ڸ� �� ���ϱ�
			inputNum = (int) (inputNum - (digitNum[j] * Math.pow(10, i))); //���� �ڸ����� ���ϱ� ���� ���� �ڸ� ���� ũ�⸸ŭ ���ֱ�
			j++;
		}
		
		return digitNum;		
	}

	public boolean compareDigitNum(int[] comNumArr) {
		int strike = 0;
		int ball = 0;
		
		int[] userNumArr = new int[DIGIT_COUNT];
		
		// 2) ���� �Է� �޾� �迭�� �ִ´�.
		userNumArr = mainObj.getInputDigitNum(scan);

		strike = 0;
		ball = 0;
		
		// 3) �Է¹��� ���� ������ ���� ���Ͽ� ��Ʈ����ũ�� ���� ������ ���Ѵ�.
		for(int i = 0; i< DIGIT_COUNT; i++) {
			int r = mainObj.findStrikeBall(comNumArr, userNumArr[i], i);
			
			if(r == 'S') {
				strike++;
			}else if(r =='B') {
				ball++;
			}
		}
		
		if(strike == 3) {
			return true;
		}
		
		return false;
	}
	public int findStrikeBall(int[] comNumArr, int userNum, int index) {
		
		for(int i=0; i<DIGIT_COUNT; i++) {
			if(comNumArr[i] == userNum) {
				if(i==index) {
					return 'S';
				}
				
				return 'B';
			}
		}
		
		return ' ';
	}
}
