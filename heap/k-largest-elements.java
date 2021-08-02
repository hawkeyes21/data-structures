/*

    Given an array of N positive integers, print k largest elements from the array. 

    Example 1:

    Input:
    N = 5, k = 2
    arr[] = {12,5,787,1,23}
    Output: 787 23
    Explanation: First largest element in
    the array is 787 and the second largest
    is 23.

    Example 2:

    Input:
    N = 7, k = 3
    arr[] = {1,23,12,9,30,2,50}
    Output: 50 30 23
    Explanation: Three Largest element in
    the array are 50, 30 and 23.
    
    Expected Time Complexity: O(N log K)
    Expected Auxiliary Space: O(K)

*/

// USING MAX-HEAP
class Solution
{
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<n; i++)
        {
            maxHeap.add(arr[i]);
        }
        ArrayList<Integer> kLargestElements = new ArrayList<>();
        for(int i=0; i<k; i++)
        {
            kLargestElements.add(maxHeap.poll());
        }
        return kLargestElements;
    }
}


// USING MIN-HEAP
class Solution
{
    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        ArrayList<Integer> largest = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < k; i++)
        {
            minHeap.add(arr[i]);
        }
        for(int i = k; i < n; i++)
        {
            if(arr[i] > minHeap.peek())
            {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        while(!minHeap.isEmpty())
        {
            largest.add(0, minHeap.poll());
        }
        return largest;
    }
}
