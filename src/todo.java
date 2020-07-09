import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class todo {
  public static void main(String[] args) {
    if (args.length == 0) {
      printInfo();
    } else {
      for (String s : args) {
        switch (s) {
          case "-l":
            showTasks();
            break;
          case "-a":
            System.out.println("");
        }
      }
    }
  }

  private static void printInfo() {
    System.out.println("Command Line Todo application");
    System.out.println("=============================");
    System.out.println();
    System.out.println("Command line arguments:");
    System.out.println("\t -l   Lists all the tasks");
    System.out.println("\t -a   Adds a new task");
    System.out.println("\t -r   Removes an task");
    System.out.println("\t -c   Completes an task");
  }

  private static void showTasks() {
    try {
      Path filePath = Paths.get("assets/tasks.txt");
      List<String> lines = Files.readAllLines(filePath);

      for (int i = 0; i < lines.size(); i++) {
        System.out.println((i+1) + " - " + lines.get(i));
      }
    } catch (Exception e) {
      System.out.println("Could not read the tasks.txt file!");
    }
  }
}
