package bfs;

import java.util.*;

// ���� �׷���
public class BFS_LinkedList {
	static class Node {
		int vertex; // ���� ��ȣ
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
		N = sc.nextInt(); // ���� ��
		int C = sc.nextInt(); // ���� ��

		Node[] adjList = new Node[N]; // ���� �� ũ��� ����

		for (int i = 0; i < C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			// �����̹Ƿ� ���� �ϳ��� ����� ó��
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		
		for (Node head : adjList) {
			System.out.println(head);
		}

	}

}
