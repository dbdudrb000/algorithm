package Level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Step1 {
	public static void main(String[] args) {
		
		// 결과 : [2,1,1,0]
		int k = 2;
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo",
						   "apeach frodo",
						   "frodo neo",
						   "muzi neo",
						   "apeach muzi"
						  };
		
		System.out.println(solution(id_list,report,k));
	}
	
	
	 /**
	  * 설명 : 1. 신고는 몇번이든 할 수 있다.
	  *      2. 같은 사용자에게 중복으로 신고할 수 없다.
	  *      3. 2번이상 신고당한 사람은 정지가 된다.
	  *          └ 신고한 사람에게 메일을 1회 방송한다.
	  *          
	  * ["muzi", "frodo", "apeach", "neo"]	- 사용자
	  * ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"] - 신고 리포터
	  * [2,1,1,0] - 결과
	  */
	public static int[] solution(String[] id_list, String[] report, int k) {
		// 내가 신고한 사람이 누구 저장하는 Hash
		HashMap<String, HashSet<String>> reportHm = new HashMap<String, HashSet<String>>();
		// 나를 신고한 사람이 누구인지 저장하는 Hash
		HashMap<String, HashSet<String>> resultHm = new HashMap<String, HashSet<String>>();

		for(String r : report) {
			// 0 : 신고한 사람 , 1 : 신고당한 사람 
			String[] reArr = r.split(" ");
			if(reportHm.containsKey(reArr[0]) == false) {
				reportHm.put(reArr[0], new HashSet<String>());
			}
				reportHm.get(reArr[0]).add(reArr[1]);
				
			if(resultHm.containsKey(reArr[1]) == false) {
				resultHm.put(reArr[1], new HashSet<String>());
			}
				resultHm.get(reArr[1]).add(reArr[0]);
		}
		System.out.println("reportHm ::: "  +reportHm);
		System.out.println("resultHm ::: " +resultHm);
		
		int[] answer = new int[id_list.length];
		for(int i=0; i<id_list.length; i++) {
			if(reportHm.containsKey(id_list[i]) == false) continue;
			
			for(String user : reportHm.get(id_list[i])) {
				if(resultHm.get(user).size() >= k) {
					answer[i]++;
				}
			}
		}
		return answer;
	}
	
} // End Step1 Class