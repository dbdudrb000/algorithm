package level1;

public class Step5 {
    /*
	[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	 
	 L  R  L  L  L  R  L  L  R  R  L"
	
	[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	 
	 L  R  L  L  R  R  L  L  L  R  R
	 
	[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	    "right"	 
	 L  L  R  L  L  R  L  L  R  L
	*/
    
	public static void main(String[] args) {
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		
		System.out.println(solution(numbers, hand));
	}

	public static String solution(int[] numbers, String hand) {
		String answer = "";
		int left = 10;
		int right = 12;
		int L_dis
		   ,R_dis = 0;
		
		for(int n : numbers) {
			if(n == 1 || n == 4 || n == 7) {
				left = n;
				answer += "L";
			} else if(n == 3 || n == 6 || n == 9) {
				right = n;
				answer += "R";
			} else {
				if(n == 0) {
					n += 11;
				}
				L_dis = (Math.abs(n-left))/3 + (Math.abs(n-left))%3;
				System.out.println("n : "  + n + "\n left : "  + left);
				System.out.println("Math.abs(n-left))/3 : " + (Math.abs(n-left))/3);
				System.out.println("(Math.abs(n-left))%3 : "  + (Math.abs(n-left))%3);
				System.out.println();
				
				R_dis = (Math.abs(right-n))/3 + (Math.abs(right-n))%3;
				System.out.println("n : "  + n + "\n right : "  + right);
				System.out.println("(Math.abs(right-n))/3 : " + (Math.abs(right-n))/3);
				System.out.println("(Math.abs(right-n))%3 : " + (Math.abs(right-n))%3);
				System.out.println();
				
				if(L_dis == R_dis) {
					if(hand.equals("right")){
						answer += "R";
						right = n;
					} else {
						answer += "L";
						left = n;
					}
				} else if(L_dis < R_dis) {
					answer += "L";
					left = n;
				} else {
					answer += "R";
					right = n;
				}
			}
		}
		
		return answer;
	}
}
