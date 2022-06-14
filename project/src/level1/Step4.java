package level1;

public class Step4 {
	public static void main(String[] args) {
		/*  입력              출력 */
//		"one4seveneight"	 1478
//		"23four5six7"	     234567
//		"2three45sixseven"	 234567
//		"123"				 123
		
		String str = "23four5six7";
		
		System.out.println(solution(str));
	}
	
	/* 특정 문자열이 해당 숫자로 변환 규칙 */
//	0	zero
//	1	one
//	2	two
//	3	three
//	4	four
//	5	five
//	6	six
//	7	seven
//	8	eight
//	9	nine
	public static int solution(String str) {
		int answer = 0;
		
		str = str.replace("zero", "0").replaceAll("one","1").replace("two", "2").replace("three", "3").replace("four", "4")
				 .replace("five", "5").replace("six", "6").replace("seven", "7").replace("eight", "8").replace("nine", "9");
		
		answer = Integer.parseInt(str);
		
		return answer;
	}
}
