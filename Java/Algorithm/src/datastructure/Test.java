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

		// hour가 작은 순서, hour 같을 시, minute이 큰 순서
		@Override // implements Comparable할 때, 필수로 재정의 해줘야함
		public int compareTo(Movie o) {
//         return (-1)*(this.hour - v.hour); // 플러스면 오름차순, 마이너스면 내림차순
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
			System.out.println("10을 가지고 있네요");
		}
		System.out.println(set.contains(10));

		System.out.println("List get------------");
		List<Integer> lt = new ArrayList<>();
		lt.add(100); // 0번째
		lt.add(200); // 1번째
		lt.add(300); // 2번째
		System.out.println(lt.get(0));
		System.out.println(lt.get(1));
		System.out.println(lt.get(2));
		if (lt.contains(100)) {
			System.out.println("lt는 100을 가지고 있습니다.");
		}
		Collections.sort(lt, Collections.reverseOrder()); // 역순으로 바꾸기
		System.out.println(lt);
		System.out.println("lt의 크기는: " + lt.size());

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

		ll.add(1, "ORANGE"); // add([index], value): 인덱스를 지정할 수 있다. (지정하지 않으면 가장 마지막에 연결)

		System.out.println(ll);

		ll.set(0, "WHITE"); // set(index, value): 원하는 인덱스의 값을 변경

		System.out.println(ll);

		String remove = ll.remove(0); // remove(index): 원하는 인덱스의 값을 삭제
		System.out.println(remove);
		System.out.println(ll);

		ll.remove("ORANGE"); // 값으로 삭제 가능, return boolean
		System.out.println(ll);

		ll.clear(); // 초기화
		System.out.println(ll);

		ll.add("RED");
		ll.add("ORANGE");
		ll.add("YELLOW");
		ll.add("GREEN");
		for (String s : ll) {
			System.out.println(s);
		}

		boolean contain = ll.contains("BLUE"); // contains(): 존재유무
		System.out.println(contain);

		int index = ll.indexOf("GREEN"); // indexOf(): 존재유뮤 + 위치
		System.out.println(index);

		int index2 = ll.indexOf("BLACK");
		System.out.println(index2); // 존재하지 않으면 return -1;

		System.out.println("String------------------");
		String s = "  ABCDEFG12345IJK LMN  ";
		System.out.println(s.concat("TEST")); // 맨 뒤에 추가
		System.out.println(s.substring(5)); // 5번째부터 끝까지 (처음은 0으로 생각)
		System.out.println(s.substring(5, 9)); // 5번째부터 8까지 추력
		System.out.println(s.replace("ABCD", "ZXYW")); // ABCD를 ZXYW 로 대체
		System.out.println(s.trim()); // 띄어쓰기 지워주기
		System.out.println(s.charAt(5)); // N번째 문자 출력, 타입이 Character, 타입 ㅊ크
		System.out.println(s.endsWith("N  ")); // 끝자리부터 검사
		System.out.println(s.startsWith("  ABC")); // ABC 로 끝나는지 검사
		System.out.println(s.contains("12345")); // 12345를 포함하는지

		String ss = "ABCD";
		if (ss.equals("ABCD")) { // 문자열 비교는 == 으로 안 하고 equals 로
			System.out.println("같은 문자 입니다.");
		}

		char[] arr = s.toCharArray(); // 캐릭터 배열로 바꿔주기
		System.out.println(Arrays.toString(arr));

		System.out.println((int) 'A'); // 아스키

		// int를 String으로
		String test = 10 + "";

		// int형 자릿수 판별하는법
		int num = 10000;
		System.out.println((num + "").length());
		System.out.println(Math.log10(num) + 1);

		System.out.println(Math.max(10, 20));
	}
}