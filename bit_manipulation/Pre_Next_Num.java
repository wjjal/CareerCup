package bit_manipulation;

//对于一个正整数，打印出仅次于它和恰大于它的数字，该数字和这个整数二进制表示有相同的1的个数
public class Pre_Next_Num {
	public static void main(String[] args){
		int n = 28;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(GetNext_NP(n)));
		System.out.println(Integer.toBinaryString(GetPrevious_NP(n)));
	}
	
	public static boolean GetBit(int n, int index) {
		return ((n & (1 << index)) > 0);
	}

	public static int SetBit(int n, int index, boolean b) {
		if (b)
			return n | (1 << index);
		else {
			int mask = ~(1 << index);
			return n & mask;
		}
	}

	public static int GetNext_NP(int n) {
		if (n <= 0)
			return -1;
		int index = 0;
		int countOnes = 0;
		//找到第一个1
		while (!GetBit(n, index))
			index++;
		//修改下一个0，置为1
        while(GetBit(n, index)){
        	index++;
        	countOnes++;
        }
        n = SetBit(n,index,true);
        //把之前的1置为0
        index--;
        n = SetBit(n,index,false);
        countOnes--;
        
        //设置为0
        for(int i =index-1;i>=countOnes;i--)
        	n = SetBit(n,i,false);
        //设置为1
        for(int i = countOnes-1;i>=0;i--)
        	n = SetBit(n,i,true);
        return n;
	}
	
	public static int GetPrevious_NP(int n){
		if (n <= 0)
			return -1;
		int index = 0;
		int countOnes = 0;
		//找到第一个0
		while (GetBit(n, index))
			index++;
		//修改下一个1，置为0
        while(!GetBit(n, index)){
        	index++;
        	countOnes++;
        }
        n = SetBit(n,index,false);
        //把之前的0置为1
        index--;
        n = SetBit(n,index,true);
        countOnes--;
        
        //设置为1
        for(int i =index-1;i>=countOnes;i--)
        	n = SetBit(n,i,true);
        //设置为0
        for(int i = countOnes-1;i>=0;i--)
        	n = SetBit(n,i,false);
        return n;
	}
}
