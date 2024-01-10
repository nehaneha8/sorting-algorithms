public class SelectionSort
{
  /**
   * The sort method takes in a double array and implements the Selection sort algorithm to sort it. 
   * 
   * @param arr - An unsorted array of doubles that is sorted using the Selection sort algorithm.
   */
  public static void sort(double[] arr)
  {
    // Loops through the array backwards.
    for (int n = arr.length; n > 1; n--)
    {
      // Loops through the array to find the largest element in the unsorted section of the array and sets iMax equal to it.
      int iMax = 0;
      for (int i = 1; i < n; i++)
      {
        if (arr[i] > arr[iMax])
          iMax = i;
      }

      // Swaps the value of iMax with the current element in the array.
      double arrTemp = arr[iMax];
      arr[iMax] = arr[n-1];
      arr[n-1] = arrTemp;
    }
  }
}
