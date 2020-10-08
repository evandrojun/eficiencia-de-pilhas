package pilha_ingenua;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors

public class Program {
  public static void main(String[] args) throws IOException {
    try {
      File entriesFolder = new File("./entradas");

      FileWriter taskTime = new FileWriter("./tempo_das_tarefas/pilha_ingenua.txt");

      for (File taskFile : entriesFolder.listFiles()) {
        long initTime = System.currentTimeMillis();
        int lineCount = 0;

        FileWriter output = new FileWriter("./saidas_ingenuas/saida_ingenua_" + taskFile.getName());

        Scanner scanner = new Scanner(taskFile);

        PilhaIngenua pilhaIngenua = new PilhaIngenua();

        while (scanner.hasNextLine()) {
          String data = scanner.nextLine();

          if (!data.isEmpty()) {
            pilhaIngenua.add(Integer.parseInt(data));
          } else {
            output.write("" + pilhaIngenua.remove() + "\n");
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
