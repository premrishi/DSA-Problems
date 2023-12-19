package Queues;

/*
Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
1. The amount of petrol that every petrol pump has.
2. Distance from that petrol pump to the next petrol pump.
Find a starting point where the truck can start to get through the complete
circle without exhausting its petrol in between.
​
N = 4
Petrol = 4 6 7 4
Distance = 6 5 3 5
Output: 1
Explanation: There are 4 petrol pumps with
amount of petrol and distance to next
petrol pump value pairs as {4, 6}, {6, 5},
{7, 3} and {4, 5}. The first point from
where truck can make a circular tour is
2nd petrol pump. Output in this case is 1
(index of 2nd petrol pump).
​
We need to find the starting point, from where we can make a circular rotation without exhausting the petrol
​
//Brute force
Start from each point, do full rotation and check whether circle is formed or not.
​
(7,6), (8,7), (5,8), (11,9), (7,7), (6,5)
//petrol-distance = extra fuel
For 7,6 = 7-6=1
​
Starting from (11,9) will give the correct answer.
//petrol-distance = extra fuel
​
extraFuel = 2 + 1 + 1 + 1 (-3) = 2
requiredFuel =
​
O(n^2)
​
 */
public class FirstCircularTour {
    public static void main(String[] args) {
        int petrol[] = {7, 8, 5, 11, 7, 6};
        int distance[] = {6, 7, 8, 9, 7, 5};
        System.out.println(start(petrol, distance));
    }
    
    public static int start(int petrol[], int distance[]) {
		int starting = 0;
		int extrafuel = 0;
		int requiredfuel = 0;
		
		for(int i = 0; i<petrol.length; i++) {
			extrafuel += petrol[i] - distance[i];
			if(extrafuel<=0) {
				starting = i+1;
				requiredfuel += extrafuel;
				extrafuel = 0;
			}
		}
		
		if(extrafuel>= Math.abs(requiredfuel)) {
			return starting;
		} else {
			return -1;
		}
	}
}
