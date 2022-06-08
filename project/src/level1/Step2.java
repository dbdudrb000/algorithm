package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Step2 {
	public static void main(String[] args) {
		
		// ��� : �ְ� ���� : 3��
		//      ���� ���� : 5��
		// CASE 1
//		int[] number = {44, 1, 0, 0, 31, 25}; // �ζ� ��ȣ
//		int[] result = {31, 10, 45, 1, 6, 19}; // �ζ� ��÷ ��ȣ
		
		/**
		 * ��� : �ְ� ���� : 1��
		 *      ���� ���� : 6��
		 */
		// CASE 2
		int[] number = {0, 0, 0, 0, 0, 0}; // �ζ� ��ȣ
		int[] result = {38, 19, 20, 40, 15, 25}; // �ζ� ��÷ ��ȣ
		
		
		System.out.println(solution(number, result));
	}
	
	/**
	 * 1. ���� �ζ� ��ȣ�� ��÷ ��ȣ�� ���ؼ� � �¾Ҵ��� üũ�� �Ѵ�.
	 * 2. ���� 0�� ��÷������, ��÷�� �ȵ������� ī��Ʈ�� ���Ѵ�.
	 */
	public static int[] solution(int[] number, int[] result) {
		int[] answer = new int[2];
		int zeroCnt = 0;
		int cnt = 0;
		int presentLnk = 0;
		int maxCnt = 0;
		
		Arrays.sort(number);
		Arrays.sort(result);
		
		for(int i=0; i < number.length; i++) {
			if(number[i] == 0) {
				zeroCnt++;
			}else {
				for(int k=0; k < result.length; k++) {
					if(number[i] == result[k]) {
						cnt++;
					}
				}
			}
		}
		
		switch (cnt) {
		case 6: presentLnk = 1;
			break;
		case 5: presentLnk = 2;
			break;
		case 4: presentLnk = 3;
			break;
		case 3: presentLnk = 4;
			break;
		case 2: presentLnk = 5;
			break;
		default:presentLnk = 6;
			break;
		}
		
		maxCnt = presentLnk;
		for(int i=0; i<zeroCnt; i++) {
			if(maxCnt != 1) {
				maxCnt--;
			}
		}
		answer[0] = maxCnt;
		answer[1] = presentLnk;
		
		return answer;
	}
	
}