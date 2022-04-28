package dfs;

import java.util.Scanner;

//무향 그래프
public class DFS_LinkedList {
	static class Node {
		int vertex; // 정점 번호
		Node link;

		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
	}

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점 수
		int C = sc.nextInt(); // 간선 수

		Node[] adjList = new Node[N]; // 정점 수 크기로 생성

		for (int i = 0; i < C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			// 무향이므로 간선 하나로 양방향 처리
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}

//		for (Node head : adjList) {
//			System.out.println(head);
//		}

		dfs(adjList, new boolean[N], 0);
	}

	public static void dfs(Node[] adjList, boolean[] visited, int current) {
		visited[current] = true;
		System.out.println(current);

		for (Node temp = adjList[current]; temp != null; temp = temp.link) {
			if (!visited[temp.vertex]) {
				dfs(adjList, visited, temp.vertex);
			}
		}
	}

}
