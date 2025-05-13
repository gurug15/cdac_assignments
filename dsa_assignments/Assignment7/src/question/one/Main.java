package question.one;

import java.util.Scanner;

import question.one.entity.BSTree;

public class Main {

	public static void main(String[] args) {
		BSTree tree = new BSTree();
		System.out.println(tree.height());
		System.out.println(tree.heightQ());
		System.out.println(tree.smallestInBST());
		try (Scanner sc = new Scanner(System.in)) {
			int elemnet;
			do{
				
				System.out.println("Enter element:");
				 elemnet = sc.nextInt();
				 if(elemnet == -1) {
					 continue;
				 }
				tree.insert(elemnet);
				System.out.println("Enter -1 to stop");
				
				
			}while(elemnet != -1);
		}catch(Exception x) {
			x.printStackTrace();
		}
		System.out.println("height: " +tree.height());
		System.out.println("Smallest " + tree.smallestInBST());
		System.out.println("Largest " + tree.largestInBST());
	}


}
