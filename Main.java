import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    System.out.println("Unsorted Array ---------------------------------------------------");
    ArrayList<Integer> integerList = Lab4.getList();
    Lab4.outputList(integerList);

    System.out.println("\n\nBubble sort results ----------------------------------------------");
    ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
    Lab4.outputList(bubbleSortedList);

    long start = System.nanoTime();
    Lab4.bubbleSort(bubbleSortedList);
    long end = System.nanoTime();
    Lab4.outputList(bubbleSortedList);
    System.out.println("\nBubble sort time: " + (start - end) + " ns");

    System.out.println("\n\nInsertion sort results -------------------------------------------");
    ArrayList<Integer> insertionSortedList = Lab4.bubbleSort(integerList);
    Lab4.outputList(insertionSortedList);

    start = System.nanoTime();
    Lab4.bubbleSort(insertionSortedList);
    end = System.nanoTime();
    Lab4.outputList(insertionSortedList);
    System.out.println("\n\nInsertion sort time: " + (start - end) + " ns");
  }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    // Step 1 - Implement insertion sort algorithm here
    for (int i = 1; i < integerList.size(); i++) {
      int step = integerList.get(i);
      int j = i - 1;

      while (j >= 0 && integerList.get(j) > step) {
        integerList.set(j + 1, integerList.get(j));
        j = j - 1;
      }
      integerList.set(j + 1, step);
    }

    return integerList;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    // Step 2 - Implement the bubble sort algorithm here
    boolean switched;
    for (int i = 0; i < integerList.size() - 1; i++) {
      switched = false;
      for (int j = 0; j < integerList.size() - i - 1; j++) {
        if (integerList.get(j) > integerList.get(j + 1)) {
          int temp = integerList.get(j);
          integerList.set(j, integerList.get(j + 1));
          integerList.set(j + 1, temp);
          switched = true;
        }
      }

      if (!switched) {
        break;
      }
    }

    return integerList;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
      while ((line = br.readLine()) != null) {
        integerList.add(Integer.parseInt(line));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
      System.out.print(integerList.get(i) + " ");
    }
  }
}