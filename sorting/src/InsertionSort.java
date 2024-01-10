
public class InsertionSort
{
  /**
   * Takes in a double array and implements the Insertion sort algorithm to sort it. 
   * 
   * @param arr - An unsorted array of doubles that is sorted using the Insertion sort algorithm.
   */
  public static void sort(double[] arr)
  {
    // Loops through each item in the array starting at the second element.
    for (int n = 1; n < arr.length; n++)
    {
      double arrTemp = arr[n];
      int i = n;

      // Decreases the index i until it reaches the start of the array, or arrTemp is greater than or equal to arr[i-1].
      while (i > 0 && arrTemp < arr[i-1])
      {
        arr[i] = arr[i-1];
        i--;
      }
      arr[i] = arrTemp;
    }
  }
}
