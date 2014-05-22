package linked_list;

//如何判断一个环的入口点在哪里

public class StartOfRing {
	static class Node {
		public Node(char ch) {
			this.data = ch;
			this.next = null;
		}

		public Node(char ch, Node p) {
			this.data = ch;
			p.next = this;
		}

		char data;
		Node next;
	}

	public static void Insert(Node p, Node q) {
		if (p == null)
			return;
		p.next = q;
	}

	private static Node FindLoopStart(Node head) {
		Node p = head;
		Node q = head;
		while (q.next != null) {
			p = p.next;
			q = q.next.next;
			if (p == q)
				break;
		}
		p = head;
		while (p != q) {
			p = p.next;
			q = q.next;
		}
		return q;
	}

	public static void main(String[] args) {
		char[] cs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'C' };
		Node head = new Node('A');
		Node p = head;
		Node temp = null;
		for (int i = 1; i < cs.length - 2; i++) {
			if (i == 2) {
				temp = new Node(cs[i]);
				Insert(p, temp);
				p = p.next;
				continue;
			}
			Insert(p, new Node(cs[i]));
			p = p.next;
		}
		Insert(p, temp);
		System.out.println(FindLoopStart(head).data);
	}
}
