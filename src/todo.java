import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class todo {
  static FileManager fileManager = new FileManager();

  public static void main(String[] args) {
    if (args.length == 0) {
      printInfo();
    } else {
      for (int i = 0; i < args.length; i++) {
        switch (args[i]) {
          case "-l":
            showTasks();
            break;
          case "-a":
            addTask(args[i+1]);
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
    fileManager.showTasks();
  }

  private static void addTask(String taskName) {
    fileManager.addTask(taskName);
  }
}
