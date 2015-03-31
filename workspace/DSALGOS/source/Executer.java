package source;

import java.util.ArrayList;
import java.util.List;

import Tree.BTree;



public class Executer {
	public static void main(String args[]){
		BTree tree = new BTree();
		tree.add(10);
		tree.add(5);
		tree.add(15);
		
		tree.add(4);
		tree.add(6);
		
		tree.add(3);
		tree.add(7);
		
		tree.add(14);
		tree.add(16);
		
		tree.add(13);
		tree.add(17);
		
		tree.printTree();
		tree.makemirror();
		
		tree.printTree();
		
	}
	
	static int maxMine(int arr[][], int m, int n,int i, int j, int maxTon){
		System.out.println(i+","+j+" - "+maxTon);
		if(j<0 || i>m){
			return 0;
		}
		if(j==n){
			return maxTon+arr[i][j];
		}
		
		return Math.max(maxMine(arr,m,n,i,j+1,maxTon+arr[i][j]), Math.max(maxMine(arr,m,n,i+1,j-1,maxTon+arr[i][j]), maxMine(arr,m,n,i+1,j+1,maxTon+arr[i][j])));
	}

	static boolean checkPath(int arr[][], int m, int n,int i, int j){
		
		if(i == m || j == n){
			if(arr[i][j] == 0){
				return true;
			}
			return false;
		}
		boolean onRow = false;
		boolean onCol = false;
		if(arr[i][j+1] != -1){
			onRow = checkPath(arr,m,n,i,j+1);
		}
		if(arr[i+1][j] != -1){
			onCol = checkPath(arr,m,n,i+1,j);
		}
		return onRow || onCol;
	}
	
	
	public static int commonCountProgression(int A, int D, int B, int R, int Lim){
		int count = 0;
		if(A == B){
			
			count = 1;	
		}
		for(int i = 1 ; i < Lim; i++){
			B = B * R;
			int x = (B - A)%D;
			if(x == 0 && x <= Lim){
				count ++;
			}
		}
		
		return count;
	}
	
	
	public static int complement(int n){
		int result = 0;
		
		for(int i=0;n>1;i++){
			
			int r = n%2;
			
			if(r == 0){
				result += 1 * (1 << i);
				
			}
			n = n/2;
		}
		
		
		return result;
		
		
	}
	
	static int[] getBinary(int n){
        int b = 0;
		int[] binary = new int[10000];
		
		while(n/2 > 1){
			binary[b++] = n%2;
			n = n / 2;
		}
        return binary;
    }
	
	static int[] toComp(int[] n){
		int l = n.length - 1;
		while(l >= 0){
			if(n[l] == 0){
				n[l] = 1;
			}
			else{
				n[l] = 0;
			}
			l--;
		}
        return n;
    }
	
	static int toInt(int[] n){
		int l = 0;
		int r = 0;
		while(l < n.length-1){
			r += n[l] * (2^l);
			l++;
		}
        return r;
    }
	
	public static int fact(int n){
		if(n == 0){
			return 1;
		}
		return n * fact(n-1);
	}
	public static int sum(int[] input) {
        return sum(0, input);
    }
    private static int sum(int index, int[] input) {
        if (index >= input.length) return 0;

        int x = Math.max(
                sum(index+1, input),
                sum(index+2, input) +input[index]
        );
        System.out.println("---> "+index + " - " + x);
        return x;
    }
    
	public static boolean isPal(int n){
		return isPal(n,n);
	}
	
	private static boolean isPal(int n, int m){
		if(n > 0 && n<10){
			return n == m % 10;
				
		}
		
		boolean ret = isPal(n / 10, m);
		
		m = m/10;
		
		return ret;
	}
	
	public static int fibonth(int n){
		if(n <= 1){
			return n;
		}
		return fibonth(n-1) + fibonth(n -2);
	}
	public static void fibo(int n){
		int f1 = -1;
		int f2 = 1;
		for(int i=0;i<n;i++){
			int f3 = f1 + f2;
			System.out.println(f3);
			f1 = f2;
			f2 = f3;
		}
	}
}
