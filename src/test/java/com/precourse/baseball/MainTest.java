package com.precourse.baseball;

import java.util.Scanner;

import org.junit.Test;

public class MainTest {

	@Test
	public void testRandomDigitNum(){
		//������ ���� �ٸ� ���� �迭�� ���
		Main mainObj = new Main();
		int[] result = mainObj.getRandomDigitNum();
		
		System.out.print("������ ���� �ٸ� �� ���: ");
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]);
		}
		
		System.out.println("");
	}
	
	@Test
	public void testInputDigitNum(){
		//�Է¹��� ���� �迭�� ���
		Main mainObj = new Main();
		Scanner scan = new Scanner(System.in);
		int[] result = mainObj.getInputDigitNum(scan);
		
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]);
		}
		
		System.out.println("");
	}
}
