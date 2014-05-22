package other;

//对于一个string s,和一个字符串数组T，T中的字符串长度都小于s，查找
public class SubStringSearch {
	public static void main(String[] args) {
		String s = "bibs";
		String[] T = { "is", "ib", "cd", "bib","bi" };
		Node root = BuildSuffixTree(s);
		SearchInTree(root, T);
	}

	public static class Node {
		char value;
		Node child[];

		public Node(char c) {
			value = c;
			child = new Node[26];
		}

		public Node() {
			child = new Node[26];
		}

		public void insertString(Node root, String suffix) {
			Node p = root;
			for (int i = 0; i < suffix.length(); i++) {
				char c = suffix.charAt(i);
				int index = c - 'a';
				if (p.child[index] == null)
					p.child[index] = new Node(c);
				p = p.child[index];
			}
		}
	}

	public static Node BuildSuffixTree(String s) {
		Node root = new Node();
		for (int i = 0; i < s.length(); i++) {
			String suffix = s.substring(i);
			root.insertString(root, suffix);
		}
		return root;
	}

	public static void SearchInTree(Node root, String[] T) {
		for (String s : T) {
			Node p = root;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				int index = c - 'a';
				if (p.child[index] != null)
					p = p.child[index];
				else
					break;
				if(i==s.length()-1)
					System.out.println(s);
			}
		}
	}
}
