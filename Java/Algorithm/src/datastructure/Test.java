package datastructure;

import java.util.*;

public class Test {

	static class Node {
		String start;
		int time;
		char end;

		public Node(String start, int time, char end) {
			this.start = start;
			this.time = time;
			this.end = end;
		}

		@Override
		public String toString() {
			return "[start=" + start + ", time=" + time + ", end=" + end + "]";
		}
	}

	static class Movie implements Comparable<Movie> {
		int hour, minute;

		public Movie(int hour, int minute) {
			this.hour = hour;
			this.minute = minute;
		}

		// hour�� ���� ����, hour ���� ��, minute�� ū ����
		@Override // implements Comparable�� ��, �ʼ��� ������ �������
		public int compareTo(Movie o) {
//         return (-1)*(this.hour - v.hour); // �÷����� ��������, ���̳ʽ��� ��������
			if (this.hour == o.hour) {
				return (this.minute - o.minute) * (-1);
			} else {
				return this.hour - o.hour;
			}
		}

		@Override
		public String toString() {
			return "Movie [hour=" + hour + ", minute=" + minute + "]";
		}
	}

	public static void main(String[] args) {
		System.out.println("Set-----------------");
		Set<Integer> set = new HashSet<>();
		set.add(10);
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(10);
		set.add(50);
		System.out.println(set);
		if (set.contains(10)) {
			System.out.println("10�� ������ �ֳ׿�");
		}
		System.out.println(set.contains(10));

		System.out.println("List get------------");
		List<Integer> lt = new ArrayList<>();
		lt.add(100); // 0��°
		lt.add(200); // 1��°
		lt.add(300); // 2��°
		System.out.println(lt.get(0));
		System.out.println(lt.get(1));
		System.out.println(lt.get(2));
		if (lt.contains(100)) {
			System.out.println("lt�� 100�� ������ �ֽ��ϴ�.");
		}
		Collections.sort(lt, Collections.reverseOrder()); // �������� �ٲٱ�
		System.out.println(lt);
		System.out.println("lt�� ũ���: " + lt.size());

		System.out.println("Class ----------------");
		List<Node> list = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		Queue<Node> q = new LinkedList<>();

		list.add(new Node("test01", 100, 'A'));
		stack.add(new Node("test01", 100, 'B'));
		q.offer(new Node("test01", 100, 'C'));

		List<int[]> list2 = new ArrayList<>();
		list2.add(new int[] { 1, 2 });

		HashMap<String, Node> map = new HashMap<>();
		map.put("key01", new Node("string01", 1000, 'D'));
		map.keySet();
		map.getOrDefault("key01", new Node("string02", 2000, 'F'));
		System.out.println(map.get("key01"));

		System.out.println("QQ------------");
		Queue<Movie> qq = new LinkedList<>();
		qq.add(new Movie(10, 100));
		qq.add(new Movie(50, 700));
		qq.add(new Movie(30, 300));
		qq.add(new Movie(70, 200));
		qq.add(new Movie(80, 900));
		qq.add(new Movie(20, 800));
		while (!qq.isEmpty()) {
			System.out.println(qq.poll());
		}

		System.out.println("PQ-----------");
		PriorityQueue<Movie> pq = new PriorityQueue<>();
		pq.add(new Movie(10, 100));
		pq.add(new Movie(50, 700));
		pq.add(new Movie(30, 300));
		pq.add(new Movie(30, 400));
		pq.add(new Movie(30, 500));
		pq.add(new Movie(70, 200));
		pq.add(new Movie(80, 900));
		pq.add(new Movie(20, 800));

		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}

		System.out.println("LinkedList--------------");
		LinkedList<String> ll = new LinkedList<>();

		ll.add("RED");
		ll.add("YELLOW");
		ll.add("GREEN");

		System.out.println(ll);

		ll.add(1, "ORANGE"); // add([index], value): �ε����� ������ �� �ִ�. (�������� ������ ���� �������� ����)

		System.out.println(ll);

		ll.set(0, "WHITE"); // set(index, value): ���ϴ� �ε����� ���� ����

		System.out.println(ll);

		String remove = ll.remove(0); // remove(index): ���ϴ� �ε����� ���� ����
		System.out.println(remove);
		System.out.println(ll);

		ll.remove("ORANGE"); // ������ ���� ����, return boolean
		System.out.println(ll);

		ll.clear(); // �ʱ�ȭ
		System.out.println(ll);

		ll.add("RED");
		ll.add("ORANGE");
		ll.add("YELLOW");
		ll.add("GREEN");
		for (String s : ll) {
			System.out.println(s);
		}

		boolean contain = ll.contains("BLUE"); // contains(): ��������
		System.out.println(contain);

		int index = ll.indexOf("GREEN"); // indexOf(): �������� + ��ġ
		System.out.println(index);

		int index2 = ll.indexOf("BLACK");
		System.out.println(index2); // �������� ������ return -1;

		System.out.println("String------------------");
		String s = "  ABCDEFG12345IJK LMN  ";
		System.out.println(s.concat("TEST")); // �� �ڿ� �߰�
		System.out.println(s.substring(5)); // 5��°���� ������ (ó���� 0���� ����)
		System.out.println(s.substring(5, 9)); // 5��°���� 8���� �߷�
		System.out.println(s.replace("ABCD", "ZXYW")); // ABCD�� ZXYW �� ��ü
		System.out.println(s.trim()); // ���� �����ֱ�
		System.out.println(s.charAt(5)); // N��° ���� ���, Ÿ���� Character, Ÿ�� ��ũ
		System.out.println(s.endsWith("N  ")); // ���ڸ����� �˻�
		System.out.println(s.startsWith("  ABC")); // ABC �� �������� �˻�
		System.out.println(s.contains("12345")); // 12345�� �����ϴ���

		String ss = "ABCD";
		if (ss.equals("ABCD")) { // ���ڿ� �񱳴� == ���� �� �ϰ� equals ��
			System.out.println("���� ���� �Դϴ�.");
		}

		char[] arr = s.toCharArray(); // ĳ���� �迭�� �ٲ��ֱ�
		System.out.println(Arrays.toString(arr));

		System.out.println((int) 'A'); // �ƽ�Ű

		// int�� String����
		String test = 10 + "";

		// int�� �ڸ��� �Ǻ��ϴ¹�
		int num = 10000;
		System.out.println((num + "").length());
		System.out.println(Math.log10(num) + 1);

		System.out.println(Math.max(10, 20));
	}
}