package extended_capacity_stack;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors

public class Program {
  public static void main(String[] args) throws IOException {
    try {
      File entriesFolder = new File("./entradas");

      FileWriter taskTime = new FileWriter("./tempo_das_tarefas/arranjo_extendido.txt");

      for (File taskFile : entriesFolder.listFiles()) {
        long initTime = System.currentTimeMillis();
        int lineCount = 0;

        FileWriter output = new FileWriter("./saidas_arranjo_extendido/saida_arranjo_extendido_" + taskFile.getName());

        Scanner scanner = new Scanner(taskFile);

        ExtendedCapacityStack extendedCapacityStack = new ExtendedCapacityStack();

        while (scanner.hasNextLine()) {
          String data = scanner.nextLine();

          if (!data.isEmpty()) {
            extendedCapacityStack.add(Integer.parseInt(data));
          } else {
            output.write("" + extendedCapacityStack.remove() + "\n");
          }

          lineCount++;
        }

        long finalTime = System.currentTimeMillis();

        taskTime.write(taskFile.getName() + ", " + lineCount + ", " + (finalTime - initTime) + "\n");

        scanner.close();
        output.close();
      }

      taskTime.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");

      e.printStackTrace();
    }
  }
}

