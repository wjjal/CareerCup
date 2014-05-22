package arrays_and_strings;

//判断string s2是否是s1旋转后的string
public class IsRotationString {
	public static void main(String[] args) {
        String s1 = "pleap";
        String s2 = "apple";
        System.out.println(isRotation(s1,s2));
        s1 ="ppale";
        System.out.println(isRotation(s1,s2));
	}

	public static boolean isRotation(String s1, String s2) {
		int len = s1.length();
		if (len == s2.length() && len > 0) {
			String s1s1 = s1 + s1;
			return s1s1.contains(s2);
		}
		return false;
	}
}