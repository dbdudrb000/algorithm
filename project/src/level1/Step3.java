package level1;

import java.util.regex.Pattern;

public class Step3 {
	public static void main(String[] args) {
		
		/**
		 * ��1	"...!@BaT#*..y.abcdefghijklm"  -> "bat.y.abcdefghi"
		      ��2	"z-+.^." -> "z--"
		      ��3	"=.=" -> "aaa"
		      ��4	"123_.def" -> "123_.def"
		      ��5	"abcdefghijklmn.p" -> "abcdefghijklmn"
		 */
		
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		solution(new_id);
	}
	
	/**
	 *  1�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.
		2�ܰ� new_id���� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
		3�ܰ� new_id���� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
		4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
		5�ܰ� new_id�� �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
		6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
                        ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
		7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.
	 * @param new_id
	 */
	public static void solution(String new_id) {
		// 1�ܰ�
		String changeId = new_id.toLowerCase();
		// 2�ܰ�
		changeId = changeId.replaceAll("[^-_.a-z0-9]","");

		System.out.println("changeId ::: " +changeId);
		
	}
}
