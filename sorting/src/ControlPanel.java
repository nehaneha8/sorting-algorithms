import java.util.Random;

public class ControlPanel extends UserInterface
{
  private static int numRuns = 20, arraySize;
  private static long seed, totalTime;
  private static double[] unsorted;

  /**
   * No-args class constructor that sets the value of seed to the current system time. 
   */
  public ControlPanel()
  {
    seed = System.currentTimeMillis();
  }

  /**
   * Takes in an integer arraySize to use as the size of an array, fills the array with random doubles, and 
   * returns the array.
   * 
   * @param arraySize - An integer to be used as the size of the array, representing how many doubles will be sorted.
   * @return double[] - Returns the randomly generated double[] array.
   */
  public static double[] fillArray(int arraySize)
  {
    // Declares a variable of type Random and uses the value of seed to instantiate this variable.
    Random nextValue = new Random(seed);
    
    unsorted = new double[arraySize];

    // Uses nextValue to fill the array with random doubles. 
    for (int i = 0; i < unsorted.length; i++)
    {
      unsorted[i] = nextValue.nextDouble();
    }
  
    return unsorted;
  }

  /**
   * Sorts the array with the chosen sorting method stored in sortMethod.
   * 
   * @param unsorted - The unsorted array of doubles that will be sorted with the chosen sorting method. 
   * @param sortMethod - A String that represents which sorting algorithm to use to sort the array.
   * @return long - Returns a long data value representing the time it took to sort the array.
   */
  public static long runSort(double[] unsorted, String sortMethod)
  {
    // Variable startTime is initialized to the current system time in milliseconds.
    long startTime = System.currentTimeMillis();

    // Calls the appropriate sorting method based on the letter the user entered (S, I, M or Q).
    if (sortMethod.equals("S"))
    {
      SelectionSort.sort(unsorted);
    }
    else if (sortMethod.equals("I"))
    {
      InsertionSort.sort(unsorted);
    }
    else if (sortMethod.equals("M"))
    {
      MergeSort.sort(unsorted);
    }
    else 
    {
      QuickSort.sort(unsorted);
    }      
    
    // Returns the final sorting time by subtracting the final time with the start time.
    return (System.currentTimeMillis() - startTime);
  }

  /**
   * Creates random arrays numRuns times, each of size numPoints, sorts them, and then finds the average 
   * time it takes to sort one array.
   * 
   * @param numPoints - An integer that determines how many data points are in each array.
   * @return long - Returns the average time in milliseconds it takes to sort one array.
   */
  public static long allRuns(int numPoints)
  {
    arraySize = numPoints;
    totalTime = 0;

    // Creates numRuns arrays, sorts them, and keeps track of the total time it takes to sort them all.
    for(int i = 0; i < numRuns; i++)
    {
      totalTime += runSort(fillArray(arraySize), getSortMethod());
    }

    // Divides totalTime by numRuns to find the average time it took to sort one array, and returns it.
    long avgTime = totalTime / numRuns;
    System.out.println("Size of the array: "+ numPoints + " doubles, Average time it took to sort 1 array: " + avgTime + " milliseconds");
    return avgTime;
  }
}
