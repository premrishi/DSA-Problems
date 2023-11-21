package DSA;

import java.util.Arrays;

public class arrayBasic {
	public static void main(String[] args) {
	
	//int[] arr = {-7, 1, 5, 2, -4, 3, 0};
	int[] arrone = {1,3,5,7,9,11};
	int[] arrtwo = {0,2,4,6,8,10,12};
	int[] arr2 = {1,2,4,5,6,6,8};
	int[] arr1 = {1,2,3,4,5,6,6,7,8};
	int[] stock = {0,1,0,3,0,4};
	int[] pivarr = {1,2,6,4,0,-1};
	int n = 12345;
	//printArray(arr);
	//int SumofArray = sumofArray(arr);
	//System.out.print(SumofArray);
	//int[] sumres = prefixsumArray(arr);
	//System.out.print(Arrays.toString(sumres));
	//System.out.print(Arrays.toString(minSoFar(arr)));
	//System.out.print(maxValue(arr));
	//System.out.print(minValue(arr));
	//System.out.print(secondmax(arr));
	//System.out.print(secondmin(arr));
	//System.out.print(ascending(arr));
	//System.out.print(findfib(3));
	//System.out.print(nfib(22));
	//System.out.print(Arrays.toString(mergedArray(arrone, arrtwo)));
	//System.out.print(Arrays.toString(zeroend(arr)));
	//System.out.print(Arrays.toString(reversearray(arr)));
	//System.out.print(Arrays.toString(missingnum(arr1,arr2)));
	//System.out.print(reversenumber(n));
	//System.out.print(kadanesAlgorithm(arrx));
	//pair(arrone, 4);
	//frequency(arr);
	//System.out.println(buyandsellstock(stock));
	//System.out.println(buyandsellwithoutspace(stock));
	//System.out.println(buyandsellmultiple(stock));
	//System.out.print(Arrays.toString(segarray(arr)));
	//firstmissingpostive(arr);
	//System.out.println(equilibrium(arr));
	//System.out.println(arrayequilib(pivarr));
	//System.out.println(optimalequilibrium(arr));
	}
	
	//Method to print array
	public static void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
	}
	
	//Method to print sum of array
	public static int sumofArray(int[] arr) {
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	//Method to print prefixsum as array
	public static int[] prefixsumArray(int[] arr) {
		int sum = 0;
		int[] prefixans = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			prefixans[i] = sum;
		}
		return prefixans;
	}
	
	//Method to print maximum value of given array
	public static int maxValue(int[] arr) {
		int maxValue = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]> maxValue) {
				maxValue = arr[i];
			}
		}
		return maxValue;
	}
	
	//Method to print minimum value of given array
	public static int minValue(int[] arr) {
		int minValue = Integer.MAX_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]<minValue) {
				minValue = arr[i];
			}
		}
		return minValue;
	}
	
	//Method to find minimum so far
	public static int[] minSoFar(int[] arr) {
		int minValue = Integer.MAX_VALUE;
		int[] minarr = new int [arr.length];
		for(int i=0; i<arr.length; i++) {
			if(arr[i]<minValue) {
				minValue = arr[i];	
			}
			minarr[i] = minValue;
		}
		return minarr;
	}
	
	//Method to find second max of an array
	public static int secondmax(int[] arr) {
		int maxvalue = Integer.MIN_VALUE;
		int secmaxvalue = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			if (arr[i]>maxvalue) {
				
				secmaxvalue = maxvalue;
				maxvalue = arr[i];
				
				
			}else if (arr[i] > secmaxvalue && arr[i] < maxvalue){
				secmaxvalue = arr[i];
			}
		}
		return secmaxvalue;
	}
	
	//Method to find the second min of an array
	public static int secondmin(int[] arr) {
		int minvalue = Integer.MAX_VALUE;
		int secmin = Integer.MAX_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]<minvalue) {
				secmin = minvalue;
				minvalue = arr[i];
			} else if(arr[i]<secmin && arr[i]>minvalue) {
				secmin = arr[i];
			}
		}
		return secmin;
	}
	
	//Method to find is the given array is in ascending order
	public static boolean ascending(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i]>arr[i+1]) 
				return false;
		 
			}
		return true;
		
	}
	
	//Method to find nth element in Fib series
	public static int findfib(int n) {
		int [] fibarray = new int [n+1];
		fibarray[0] = 0;
		fibarray[1] = 1;
		for(int i=2; i<fibarray.length; i++) {
			fibarray[i] = fibarray[i-1] + fibarray[i-2];
		}
		return fibarray[n];
		
	}
	
	//Method to find nth element in fib series without array
	public static int nfib(int n) {
		int firstElement = 0;
		int secondElement = 1;
		
		if(n==0) {
			return firstElement;
		}
		if(n==1) {
			return secondElement;
		}
		int c = 0;
		for(int i=2; i<=n; i++) {
			c = firstElement+secondElement;
			firstElement = secondElement;
			secondElement = c;
		}
		return c;
	}
	
	//Method to merge two sorted arrays
	public static int[] mergedArray(int arrone[], int arrtwo[]) {
		int[] globalArray = new int[arrone.length + arrtwo.length];
		int i=0;
		int j=0;
		int k=0;
		 while(i<arrone.length && j<arrtwo.length) {
			 if(arrone[i]<arrtwo[j]) {
				 globalArray[k] = arrone[i];
				 i++;
				 k++;
			 } else {
				 globalArray[k] = arrtwo[j];
				 k++;
				 j++;
			 }
			 
		 }
		 
		 while(i<arrone.length) {
			 globalArray[k] = arrone[i];
			 i++;
			 k++;
		 }
		 while(j<arrtwo.length) {
			 globalArray[k] = arrtwo[j];
			 j++;
			 k++;
		 }
		 
		 return globalArray;
	}
	
	//Method to move all the zeros to end
	public static int[] zeroend(int[] arr) {
		int j=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}
		return arr;
		
	}
	
	//Method to reverse an array
	public static int[] reversearray(int[] arr) {
		int [] garray = new int[arr.length];
		int j=0;
		for(int i = arr.length-1; i>=0; i--) {
			garray[j] = arr[i];
			j++;
		}
		return garray;
	}
	
	//Method to check if given number is palindrome or not
	public static int reversenumber(int n) {
		int rem = 0;
		while(n>0) {
			rem = rem * 10 + n % 10;
			n = n/10;
		}
		return rem;
	}
	
	//Maximum subarray(Kadane's algorithm)
	public static int kadanesAlgorithm(int[] arrx) {
		int currentSum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		for(int i = 0; i<arrx.length; i++) {
			currentSum += arrx[i];
			maxSum = Math.max(currentSum, maxSum);
			
			if(currentSum<0) {
				currentSum = 0;
			}
		}
		return maxSum;
	}
	
	//Pair sum - no duplicates(sorted array)
    public static void pair(int [] arrone, int target) {
    	
    	int i =0;
    	int j = arrone.length-1;
    	while(i<j) {
    		if(arrone[i] + arrone[j] == target) {
    			System.out.println(arrone[i] + "," + arrone[j]);
    			i++;
    			j--;
    		}
    	else if(arrone[i]+arrone[j]>target) {
    			j--;
    		}else {
    			i++;
    		}
 
    	}
    }
    
    //Frequency distribution - count frequency if elements
    public static void frequency(int[] arr) {
    	int max = Integer.MIN_VALUE;
    	for(int i=0;i<arr.length;i++) {
    		max = Math.max(arr[i], max);
    	}
    	
    	int [] freq = new int [max+1];
    	
    	for(int i=0; i<arr.length; i++) {
    		int index = arr[i];
    		freq[index]+=1;
    	}
    	
    	for(int i=0; i<freq.length; i++) {
    		if(freq[i]>0) {
    			System.out.println(i + "->" + freq[i]);
    		}
    	}
		
	}
    
    //Buy and sell stock best time
    public static int buyandsellstock(int[] stock) {
    	int minvalue = Integer.MAX_VALUE;
    	int maxValue = Integer.MIN_VALUE;
    	int[] minsofor = new int [stock.length];
    	int[] ansarr = new int [stock.length];
    	for(int i=0; i<stock.length; i++) {
    		if(stock[i]<minvalue) {
    			minvalue = stock[i];
    		}
    		minsofor[i] = minvalue;
    	}
    	for(int i=0; i<ansarr.length; i++) {
    		ansarr[i] = stock[i] - minsofor[i];
    	}
    	
    	for(int i=0; i<ansarr.length; i++) {
    		if(ansarr[i]>maxValue) {
    			maxValue = ansarr[i];
    		}
    	}
    	return maxValue;
		
	}
    
   //optimal solution for buy and sell stock 
    public static int buyandsellmultiple(int [] stock) {
    	
    	int maxprofit = 0;
    	for(int i=1; i<stock.length; i++) {
    		if(stock[i]>stock[i-1]) {
    			maxprofit += stock[i] - stock[i-1];
    		}
    		
    	}
    	return maxprofit;
    	
		
	}
    
  //optimal solution for buy and sell stock (This wont pass multiple buy and selling)
    public static int buyandsellwithoutspace(int [] stock) {
    	int minvalue = Integer.MAX_VALUE;
    	int maxprofit = 0;
    	for(int i=0; i<stock.length; i++) {
    		minvalue = Math.min(minvalue, stock[i]);
    		int profit = stock[i] - minvalue;
    		maxprofit = Math.max(maxprofit,profit);
    	}
    	return maxprofit;
    	
		
	}
    
    //move all positive to end(segregate the array)
    public static int [] segarray(int[] arr) {
    	int j =0;
    	for(int i=0; i<arr.length; i++) {
    		if(arr[i]<0) {
    		int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			j++;
    		}
    	}
    	return arr;
		
	}
    
    //Find the first missing positive integer
    public static void firstmissingpostive(int[] arr) {
    	
    	for(int i=0; i<arr.length; i++) {
    		if(arr[i]<0) {
    			arr[i] = 0;
    		}
    	}
    	
    	for(int i=0; i<arr.length; i++) {
    		int index = Math.abs(arr[i]) - 1;
    		
    		if(index>=0 && index<arr.length) {
        		
    			if(arr[index]>0) {
    				arr[index] = -arr[index];
    			} else if(arr[index] == 0) {
    				arr[index] = (-1) * arr.length + 1;
    			}
        	}
    	}
    	
    	int flag = 0;
    	int ans = 0;
    	
    	for(int i=0; i<arr.length; i++) {
    		if(arr[i]>=0) {
    			ans = i+1;
    			flag = 1;
    			break;
    		}
    	}
    	
    	if(flag == 1) {
    		System.out.println("First missing" + ans);
    	} else {
    		System.out.println("First missing" + arr.length+1);
    	}
    	
		
	}
    
    //Equilibrium index of the array (with extra space)
    public static int equilibrium(int[] arr) {
    	int[] lsum = new int[arr.length];
    	int[] rsum = new int[arr.length];
		
    	lsum[0] = arr[0];
    	rsum[rsum.length-1] = arr[arr.length-1];
    	
    	for(int i=1; i<arr.length; i++) {
    		lsum[i] = lsum[i-1] + arr[i];
    	}
    	
    	for(int i=arr.length-2; i>=0; i--) {
    		rsum[i] = rsum[i+1] + arr[i];
    	}
    	
    	for(int i=0; i<arr.length; i++) {
    		if(lsum[i] == rsum[i]) {
    			return i;
    		}
    		
    	}
    	return -1;
	}
    
  //Equilibrium index of the array (without extra space)
    public static int optimalequilibrium(int [] arr) {
    	int totalsum = 0;
    	int lsum = 0;
    	
    	for(int i=0; i<arr.length; i++) {
    		totalsum += arr[i];
    	}
    	
    	for(int i=0; i<arr.length; i++) {
    		if(lsum == totalsum - lsum - arr[i]) {
    			return i;
    		}
    		lsum += arr[i];
    	}
    	
    	return -1;
		
	}
    
    //Trapped rain water with extra space
    
    public static int withExtraSpace(int[] arr) {
    	
    	int[] lMax = new int[arr.length];
         int[] rMax = new int[arr.length];
         int trappedWater = 0;
         lMax[0] = arr[0];
         rMax[arr.length-1] = arr[arr.length-1];

         for(int i=1; i< arr.length; i++) {
             lMax[i] = Math.max(lMax[i-1], arr[i]);
         }

 		for(int i=arr.length-2; i>=0; i--) {
             rMax[i] = Math.max(rMax[i+1], arr[i]);
         }
 		
 		for(int i=0; i<arr.length; i++) {
             trappedWater+=Math.min(lMax[i], rMax[i]) - arr[i];
         }

         return trappedWater;
    }
    
    public static int arrayequilib(int[] pivarr) {
    	int i=0;
    	int j=pivarr.length-1;
    	int lsum = 0;
    	int rsum = 0;
    	while(i < j) {
    		lsum += pivarr[i];
    		i++;
    		rsum += pivarr[j];
    		j--;
    	}
    	if(lsum == rsum) {
    		return i;
    	}
    	 return -1;
    	
    }
	
	
}
