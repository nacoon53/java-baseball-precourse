package com.precourse.baseball;

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
}
