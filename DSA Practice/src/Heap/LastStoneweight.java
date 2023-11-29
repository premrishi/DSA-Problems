package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

import HashSet.JewelsAndStones;

public class LastStoneweight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = {2,7,4,1,1};
		laststone(stones);
	}
	
	public static void laststone(int[] stones) {
		PriorityQueue<Integer> pqmaxheap = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<stones.length; i++) {
			pqmaxheap.add(stones[i]);
		}
		
		while(pqmaxheap.size()>=2) {
			int x = pqmaxheap.poll();
			int y = pqmaxheap.poll();
			if(x>y) {
				pqmaxheap.add(x-y);
			}
		}
		
		System.out.println(pqmaxheap.isEmpty() ? 0 : pqmaxheap.peek());
	}

}
