public class QuickSort
{
  /**
   * Takes in a double array and implements the recursive Quick sort algorithm to sort it. 
   * 
   * @param arr - An unsorted array of doubles that is sorted using the Quicksort algorithm.
   */
  public static void sort(double[] arr)
  {
    recursiveSort(arr, 0, arr.length - 1);
  }

  /**
   * Sorts arr using the recursive Quicksort algorithm.
   * 
   * @param arr - An unsorted array of doubles that is sorted using the Quicksort algorithm.
   * @param from - An integer that will represent the leftmost index of the element in the sub-array being sorted. 
   * @param to - An integer that will represent the last index of the element in the sub-array being sorted. 
   */
  private static void recursiveSort(double[] arr, int from, int to)
  {
    // Base case exits method if the array has less than 2 elements.
    if (from >= to)
      return;

    int p = (from + to ) / 2;
    int i = from;
    int j = to;

    // Moves towards the middle pivot from both sides using two iterators, i and j.
    while (i <= j)
    {
      // Increments i by 1 until it is the index of an element greater than the pivot.
      if (arr[i] <= arr[p])
        i++;
      else if (arr[j] >= arr[p]) // Decrements j by 1 until it is the index of an element less than the pivot.
        j--;
      else  // Otherwise, swaps the elements at the two iterator indices, increments i by 1 and decrements j by 1.
      {
        swap (arr, i, j);
        i++;
        j--;
      }
    }

    // If the pivot is less than j, the pivot is set to j.
    if (p < j)   
    {
      swap (arr, j, p);
      p = j;
    }
    else if (p > i) // If the pivot is greater than i, the pivot is set to it.
    {
      swap (arr, i, p);
      p = i;
    }

    // Runs recursiveSort for elements on the left and on the right of the pivot.
    recursiveSort(arr, from, p - 1);
    recursiveSort(arr, p + 1, to);
  }

  /**
   * Swaps the values at the index of the two passed in values with the use of a temporary variable.
   * 
   * @param arr - An array of doubles that is being sorted.
   * @param i - An integer representing a position in the array.
   * @param j - An integer representing another position in the array.
   */
  private static void swap (double[] arr, int i, int j)
  {
    double temp = arr[i]; 
    arr[i] = arr[j]; 
    arr[j] = temp;
  }
}

