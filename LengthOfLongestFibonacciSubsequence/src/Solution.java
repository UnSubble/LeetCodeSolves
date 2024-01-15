
public class Solution {
	int search(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int middle = (start + end) >> 1;
			int cmp = arr[middle];
			if (cmp < target)
				start = middle + 1;
			else if (target == cmp)
				return middle;
			else
				end = middle - 1;
		}
		return -1;
	}
	
	int find(int[] arr, int f, int s) {
		int index = search(arr, f + s);
		if (f == 18 && s == 32)
			System.out.println(index);
		if (index == -1)
			return 2;
		return find(arr, s, arr[index]) + 1;
	}
	
	public int lenLongestFibSubseq(int[] arr) {
		int max = 1;
        for (int i = 0; i < arr.length - 1; i++) {
        	for (int j = i + 1; j < arr.length; j++) {
        		max = Math.max(find(arr, arr[i], arr[j]), max);
        	}
        }
        return max;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().lenLongestFibSubseq(new int[] {2,4,7,8,9,10,14,15,18,23,32,50}));
	}
}

// [1,3,7,11,12,14,18] -> 3
// [1,2,3,4,5,6,7,8] -> 5