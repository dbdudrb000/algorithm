package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Step2 {
	public static void main(String[] args) {
		
		// 결과 : 최고 순위 : 3등
		//      최저 순위 : 5등
		// CASE 1
//		int[] number = {44, 1, 0, 0, 31, 25}; // 로또 번호
//		int[] result = {31, 10, 45, 1, 6, 19}; // 로또 당첨 번호
		
		/**
		 * 결과 : 최고 순위 : 1등
		 *      최저 순위 : 6등
		 */
		// CASE 2
		int[] number = {0, 0, 0, 0, 0, 0}; // 로또 번호
		int[] result = {38, 19, 20, 40, 15, 25}; // 로또 당첨 번호
		
		
		System.out.println(solution(number, result));
	}
	
	/**
	 * 1. 현재 로또 번호와 당첨 번호를 비교해서 몇개 맞았는지 체크를 한다.
	 * 2. 숫자 0이 당첨됫을때, 당첨이 안됫을때의 카운트를 구한다.
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