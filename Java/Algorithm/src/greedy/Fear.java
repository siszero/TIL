package greedy;

// �������� ���� -> ������ ���� ���谡���� �ϳ��� Ȯ��
// '���� �׷쿡 ���Ե� ���谡�� ��' �� '���� Ȯ���ϰ� �ִ� ������'���� ũ�ų� ���ٸ� �̸� �׷����� �����ϸ� ��
// -> �������� �������� ������ �Ǿ� �ִٴ� ������ �׻� �ּ����� ���谡�� ���� �����Ͽ� �׷��� �Ἲ�ϰ� ��

import java.util.*;

public class Fear {
	public static int n;
	public static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0;i<n;i++)
			list.add(sc.nextInt());
		Collections.sort(list);	// �������� ����
		
		int result = 0;	// �� �׷��� ��
		int count = 0;	// ���� �׷쿡 ���Ե� ���谡�� ��
		for(int i =0;i<n;i++) {		// �������� ���� �ͺ��� �ϳ��� Ȯ��
			count +=1;		// ���� �׷쿡 �ش� ���谡�� ���Խ�Ű��
			if(count>=list.get(i)) {	// ���� �׷쿡 ���Ե� ���谡�� ���� ������ ������ �̻��̶��, �׷� �Ἲ
				result+=1;		// �� �׷��� �� ������Ű��
				count=0;		// ���� �׷쿡 ���Ե� ���谡�� �� �ʱ�ȭ
			}
		}
		System.out.println(result);
		
	}

}
