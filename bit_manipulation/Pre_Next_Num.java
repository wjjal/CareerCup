package bit_manipulation;

//����һ������������ӡ������������ǡ�����������֣������ֺ�������������Ʊ�ʾ����ͬ��1�ĸ���
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
		//�ҵ���һ��1
		while (!GetBit(n, index))
			index++;
		//�޸���һ��0����Ϊ1
        while(GetBit(n, index)){
        	index++;
        	countOnes++;
        }
        n = SetBit(n,index,true);
        //��֮ǰ��1��Ϊ0
        index--;
        n = SetBit(n,index,false);
        countOnes--;
        
        //����Ϊ0
        for(int i =index-1;i>=countOnes;i--)
        	n = SetBit(n,i,false);
        //����Ϊ1
        for(int i = countOnes-1;i>=0;i--)
        	n = SetBit(n,i,true);
        return n;
	}
	
	public static int GetPrevious_NP(int n){
		if (n <= 0)
			return -1;
		int index = 0;
		int countOnes = 0;
		//�ҵ���һ��0
		while (GetBit(n, index))
			index++;
		//�޸���һ��1����Ϊ0
        while(!GetBit(n, index)){
        	index++;
        	countOnes++;
        }
        n = SetBit(n,index,false);
        //��֮ǰ��0��Ϊ1
        index--;
        n = SetBit(n,index,true);
        countOnes--;
        
        //����Ϊ1
        for(int i =index-1;i>=countOnes;i--)
        	n = SetBit(n,i,true);
        //����Ϊ0
        for(int i = countOnes-1;i>=0;i--)
        	n = SetBit(n,i,false);
        return n;
	}
}
