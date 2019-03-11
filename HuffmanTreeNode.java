
public class HuffmanTreeNode implements Comparable<HuffmanTreeNode> {
	
	public char[] st;
	public Integer freq;
	public HuffmanTreeNode parent;
	public HuffmanTreeNode left;
	public HuffmanTreeNode right;
	public Integer Code;
	
	public HuffmanTreeNode(char x, int y){
		st = new char[1];
		st[0] = x;
		freq = y;
	}
	
	public HuffmanTreeNode(HuffmanTreeNode x, HuffmanTreeNode y){
		freq = 0;
		left = x;
		right = y;
		left.parent = this;
		right.parent = this;
		freq = (x.freq+y.freq);
		st = new char[left.st.length+right.st.length];
		for (int i = 0; i < left.st.length; i++){
			st[i] = left.st[i];
		}
		for (int i = left.st.length, j=0; j < right.st.length; i++, j++){
			st[i] = right.st[j];
		}
		left.Code = 0;
		right.Code = 1;
	}
	
	public int getfreq(){
		return freq;
	}
	
	public HuffmanTreeNode getZero(){
		return left;
	}
	
	public HuffmanTreeNode getOne(){
		return right;
	}

	@Override
	public int compareTo(HuffmanTreeNode o) {
		return freq.compareTo(o.freq);
		
	}

}
