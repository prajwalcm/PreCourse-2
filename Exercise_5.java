import java.util.Stack;

class IterativeQuickSort {
    void swap(int arr[], int i, int j) 
    {
        //Try swapping without extra variable
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];

    }
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[], int l, int h) 
    { 
        //Compare elements and swap.
        int i = l - 1;
        int pivot = arr[h];
        for (int j = l; j < h; j++) {
            if (arr[j] <= pivot) {
                i++; // All elements at or before i are less than pivot
                swap(arr, i, j);
            }
        }
        swap(arr, ++i, h); //Putting pivot in right place
        return i; //Returning position of pivot
    }
  
    // Sorts arr[l..h] using iterative QuickSort 
    void QuickSort(int arr[], int low, int high)
    { 
        // Try using Stack Data Structure to remove recursion.
        // Create utility stack
        Stack<Integer> stack = new Stack<>();

        // Push initial value of low, high to stack
        stack.push(low);
        stack.push(high);

        // Keep popping from stack while stack is not empty
        while (!stack.isEmpty()) {
            // Pop high and low
            high = stack.pop();
            low = stack.pop();

            // Set pivot element in its correct position
            int pivotIndex = partition(arr, low, high);

            // If there are elements on left side of pivot then push left side to stack
            if (pivotIndex - 1 > low) {
                stack.push(low);
                stack.push(pivotIndex - 1);
            }

            // Same for right side
            if (pivotIndex + 1 < high) {
                stack.push(high + 1);
                stack.push(high);
            }
        }
    } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 