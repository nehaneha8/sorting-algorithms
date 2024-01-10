import java.util.Scanner;

public class UserInterface
{
  private static Scanner keyboard = new Scanner(System.in);
  private static String sortMethod;
  private static int numPoints;

  /**
   * Explains the functionalities of the four sorting algorithms and of the program to the user.
   */
  public static void explainSort()
  {
    System.out.println("Hello User, and welcome to Benchmarks, a program that tells you the speed of 4 different sorting algorithms for different amounts of data. Here are the sorting algorithms: \n\nSelection Sort: This algorithm works by repeatedly finding the largest element in an unsorted array and bringing it to the back.\n\nInsertion Sort: In this algorithm, the first two elements are put in order, and the 3rd element is sorted in relation to the first two, and the 4th is sorted in relation to the first 3.. and so on until the entire array is sorted.\n\nMerge Sort: This sorts the first 2 items, splits the array in two, and repeat steps one and two until both halves are sorted, and the two halves are merged back into one array.\n\nQuick Sort: This algorithm chooses a random element to use as a pivot point, and arranges the array so all values less than the pivot are on the left of the element, and all larger are on the right. It continues choosing elements as pivots until the entire list is sorted.");
  }

  /**
   * Asks the user to choose one of the 4 sorting methods & how many data points they want to sort, and stores their answers.
   */
  public static void askUser()
  {
    System.out.println("\n\nPlease enter into the console 'S' to use selection sort, 'I' to use insertion sort, 'M' to use merge sort, and 'Q' to use quick sort: ");
    setSortMethod(keyboard.nextLine().trim().toUpperCase());
    System.out.println("\nPlease enter a positive integer representing how many data points you want to sort: ");
    numPoints = Integer.parseInt(keyboard.nextLine());
  }

  /**
   * Returns the user's chosen method of sorting when called.
   *
   * @return String - Returns the sortMethod field representing the sort method chosen by the user (S, I, M or Q).
   */
  public static String getSortMethod()
  {
    return sortMethod;
  }

  /**
   * Takes in a String, method, and sets sortMethod to the value of the String parameter.
   * 
   * @param method - A String to be used as the value of sortMethod when setSortMethod is called.
   */
  public static void setSortMethod(String method)
  {
    sortMethod = method;
  }

  /**
   * Returns the amount of data points the user wants to sort when called.
   * 
   * @return int - Returns the numPoints field representing the number of data values the user wishes to sort.
   */
  public static int getNumPoints()
  {
    return numPoints;
  }

  /**
   * The program entry method to call the appropriate methods to run the program.
   * 
   * @param String[] args - The command line arguments when the program is run.
   */
  public static void main(String[] args)
  {
    explainSort();
    while (true) 
    {
      askUser();
      ControlPanel.allRuns(getNumPoints());
      System.out.println("\n\n\n\n");
    }

  }
}
