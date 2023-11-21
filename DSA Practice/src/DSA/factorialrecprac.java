package DSA;

public class factorialrecprac {

	public static void main(String[] args) {
		//int x = fact(5);
		//System.out.println(x);
		int x = pow(2, 3);
		System.out.println(x);
		int[] arr = {1,2,3,4,5};
		int sum = arrsum(arr, 0);
		System.out.println(sum);
		

	}
	
	public static int fact(int n) {
		if(n == 0) {
			return 1;
		}
		if(n == 1) {
			return 1;
		}
		
		int l = n;
		int r = fact(n-1);
		int ans = l*r;
		return ans;
		
	}
	
	public static int pow(int a, int b) {
		if(b == 0) {
			return 1;
		}
		if(b == 1) {
			return a;
		}
		
		int l = pow(a, b-1);
		int r = a;
		int anss = l*r;
		return anss;
	}
	
	public static int arrsum(int[] arr, int index) {
		if(arr.length == index) {
			return 0;
		}
		
		int l = arr[index];
		int r = arrsum(arr, index+1);
		int ans = l+r;
		return ans;
		
	}

}
