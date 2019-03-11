import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffman {

	public static void main(String[] args) {
		System.out.println("The Frequency of the English letters were found using https://www.math.cornell.edu/~mec/2003-2004/cryptography/subs/frequencies.html");
		System.out.println("Would you like to 1. encode or 2. decode");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		int[] Alphabet = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0};
		String list = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";
		char[] Characters = list.toCharArray();
		PriorityQueue<HuffmanTreeNode> Tree = new PriorityQueue<HuffmanTreeNode>();
		Frequency(Tree);
		if (choice == 1){
			System.out.println("What word would you like to encode? (WRITE IN CAPS!)");
			sc.nextLine();
			String Essay = sc.nextLine();
			makeTree(Tree, Alphabet, Characters);
			encode(Tree, Essay);
		} else {
			System.out.println("What would you like to decode?");
			sc.nextLine();
			String DecodeP = sc.nextLine();
			makeTree(Tree, Alphabet, Characters);
			decode(DecodeP, Tree);
		}
	}
	
	public static void Frequency(PriorityQueue<HuffmanTreeNode> x){
		x.offer(new HuffmanTreeNode('E', 21912));
		x.offer(new HuffmanTreeNode('T', 16587));
		x.offer(new HuffmanTreeNode('A', 14810));
		x.offer(new HuffmanTreeNode('O', 14003));
		x.offer(new HuffmanTreeNode('I', 13318));
		x.offer(new HuffmanTreeNode('N', 12666));
		x.offer(new HuffmanTreeNode('S', 11450));
		x.offer(new HuffmanTreeNode('R', 10977));
		x.offer(new HuffmanTreeNode('H', 10795));
		x.offer(new HuffmanTreeNode('D', 7874));
		x.offer(new HuffmanTreeNode('L', 7253));
		x.offer(new HuffmanTreeNode('U', 5246));
		x.offer(new HuffmanTreeNode('C', 4943));
		x.offer(new HuffmanTreeNode('M', 4761));
		x.offer(new HuffmanTreeNode('F', 4200));
		x.offer(new HuffmanTreeNode('Y', 3853));
		x.offer(new HuffmanTreeNode('W', 3819));
		x.offer(new HuffmanTreeNode('G', 3693));
		x.offer(new HuffmanTreeNode('P', 3316));
		x.offer(new HuffmanTreeNode('B', 2715));
		x.offer(new HuffmanTreeNode('V', 2019));
		x.offer(new HuffmanTreeNode('K', 1257));
		x.offer(new HuffmanTreeNode('X', 315));
		x.offer(new HuffmanTreeNode('Q', 205));
		x.offer(new HuffmanTreeNode('J', 188));
		x.offer(new HuffmanTreeNode('Z', 128));
	}
	public static void makeTree(PriorityQueue<HuffmanTreeNode> x, int[] y, char[] z){
		while (x.size()>1){
			HuffmanTreeNode Left = x.poll();
			HuffmanTreeNode Right = x.poll();
			x.add(new HuffmanTreeNode(Left, Right));
			
		}

	}
	
	public static void encode(PriorityQueue<HuffmanTreeNode> x, String y){
		String bits= "";
		for (int i = 0; i < y.length(); i++){
			bits += check(x, y.charAt(i));
			bits += " ";
		}
		
		System.out.println(bits);
	}
	
	public static void decode(String x, PriorityQueue<HuffmanTreeNode> y){
		System.out.println("Decoded : ");
		HuffmanTreeNode start = y.peek();
		String decoded = "";
		for(int i = 0; i <= x.length(); i++){
			if (i == x.length() ||x.charAt(i)== ' '){
				decoded+= start.st[0];
				start = y.peek();
			} else if(x.charAt(i)== '1'){
				start = start.right;
			} else {
				start = start.left;
			}
		}
		System.out.println(decoded);
	}
	
	public static String check(PriorityQueue<HuffmanTreeNode> x, char y){
		String bit = "";
		boolean found = false;
		HuffmanTreeNode w = x.peek();
		while (!found){
			if (w.st.length > 1){
				boolean found1 = false;
				for (char c : w.left.st){
					if (c == y){
						found1 = true;
					}
				}
				if (found1){
					w = w.left;
					bit += "0";
				} else {
					w = w.right;
					bit += "1";
				}
			} else {
				found = true;
			}
		}
		
		return bit;
	}
}
