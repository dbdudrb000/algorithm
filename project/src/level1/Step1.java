package Level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Step1 {
	public static void main(String[] args) {
		
		// ��� : [2,1,1,0]
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
	  * ���� : 1. �Ű�� ����̵� �� �� �ִ�.
	  *      2. ���� ����ڿ��� �ߺ����� �Ű��� �� ����.
	  *      3. 2���̻� �Ű���� ����� ������ �ȴ�.
	  *          �� �Ű��� ������� ������ 1ȸ ����Ѵ�.
	  *          
	  * ["muzi", "frodo", "apeach", "neo"]	- �����
	  * ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"] - �Ű� ������
	  * [2,1,1,0] - ���
	  */
	public static int[] solution(String[] id_list, String[] report, int k) {
		// ���� �Ű��� ����� ���� �����ϴ� Hash
		HashMap<String, HashSet<String>> reportHm = new HashMap<String, HashSet<String>>();
		// ���� �Ű��� ����� �������� �����ϴ� Hash
		HashMap<String, HashSet<String>> resultHm = new HashMap<String, HashSet<String>>();

		for(String r : report) {
			// 0 : �Ű��� ��� , 1 : �Ű���� ��� 
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