public class MergeSort
{
  private static double[] temp;

  /**
   * Takes in a double array and implements the Merge sort algorithm to sort it. 
   * 
   * @param arr - An unsorted array of doubles that is sorted using the Merge sort algorithm.
   */
  public static void sort(double[] arr)
  {
    int n = arr.length;
    temp = new double[n];
    recursiveSort(arr, 0, n-1);
  }

  /**
   * Sorts a passed in array by splitting it into multiple smaller arrays and sorting those, and then
   * merging them in a sorted order.
   * 
   * @param arr - An unsorted array of doubles that is sorted using the Quicksort algorithm.
   * @param from - An integer that will represent the leftmost index of the element in the sub-array being sorted. 
   * @param to - An integer that will represent the last index of the element in the sub-array being sorted. 
   */
  private static void recursiveSort(double[] arr, int from, int to)
  {
    // Base case when the selected array has less than 2 elements.
    if (to - from < 2)    
    {
      // If there are two elements out of order, they are swapped with the use of a temporary variable.
      if (to > from && arr[to] < arr[from])
      {
        double arrTemp = arr[to]; 
        arr[to] = arr[from]; 
        arr[from] = arrTemp;
      }
    }
    else // Otherwise, recursively calls recursiveSort twice with the 1st & 2nd half of the array, & merges the two arrays.  
    {
      int middle = (from + to) / 2;
      recursiveSort(arr, from, middle);
      recursiveSort(arr, middle + 1, to);
      merge(arr, from, middle, to);
    }
    // return arr;
  }

  /**
   * Merges two sorted sections of the array into one sorted section of the array.
   * 
   * @param arr - The array of doubles that is being sorted.
   * @param from - Integer to represent the index of the 1st element in the 1st sorted section.
   * @param middle - Integer to represent the index of the middle element of the 2 sorted sections.
   * @param to - Integer to represent the index of the last element of the second sorted section.
   */
  private static void merge(double[] arr, int from, int middle, int to)
  {
    int i = from, j = middle + 1, k = from;

    // Finds the smallest elements in both arrays and puts them in ascending order in a temporary array until one of them is empty.
    while (i <= middle && j <= to)
    {
      if (arr[i] < arr[j])
      {
        temp[k] = arr[i];   
        i++;
      }
      else
      {
        temp[k] = arr[j];
        j++;
      }
      k++;
    }

    // Inserts the rest of the terms from the first array into the temporary array until it is empty.
    while (i <= middle)
    {
      temp[k] = arr[i];     
      i++;
      k++;
    }

    // Inserts the rest of the terms from the second array into the temporary array until it is empty.
    while (j <= to)
    {
      temp[k] = arr[j];   
      j++;
      k++;
    }

    // Inserts each value from the temporary array into the original array.
    for (k = from; k <= to; k++)
      arr[k] = temp[k];
  }
}
