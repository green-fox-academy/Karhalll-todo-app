public class todo {
  static TaskManager taskManager = new TaskManager();

  public static void main(String[] args) {
    if (args.length == 0) {
      printInfo();
    } else {
      args: for (int i = 0; i < args.length; i++) {
        switch (args[i]) {
          case "-l":
            showTasks();
            break args;
          case "-a":
            try {
              addTask(args[i+1]);
            } catch (ArrayIndexOutOfBoundsException e) {
              System.out.println("Unable to add: no task provided");
            }
            break args;
          case "-r":
            try {
              removeTask(args[i+1]);
            } catch (ArrayIndexOutOfBoundsException e) {
              System.out.println("Unable to remove: no index provided");
            } catch (NumberFormatException e) {
              System.out.println("Unable to remove: index is not a number");
            }
            break args;
          case "-c":
            try {
              checkTask(args[i+1]);
            } catch (ArrayIndexOutOfBoundsException e) {
              System.out.println("Unable to remove: no index provided");
            } catch (NumberFormatException e) {
              System.out.println("Unable to remove: index is not a number");
            }
            break args;
          case "-uc":
            try {
              uncheckTask(args[i+1]);
            } catch (ArrayIndexOutOfBoundsException e) {
              System.out.println("Unable to remove: no index provided");
            } catch (NumberFormatException e) {
              System.out.println("Unable to remove: index is not a number");
            }
            break args;
          default:
            System.out.println("Unsupported argument");
            printInfo();
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
    System.out.println("\t -uc  Unchecks an task");
  }

  private static void showTasks() {
    taskManager.showTasks();
  }

  private static void addTask(String taskName) {
    taskManager.addTask(taskName);
  }

  private static void removeTask(String taskNumber) {
    int taskNumberInt = Integer.parseInt(taskNumber);
    taskManager.removeTask(taskNumberInt);
  }

  private static void checkTask(String taskNumber) {
    int taskNumberInt = Integer.parseInt(taskNumber);
    taskManager.checkTask(taskNumberInt, true);
  }

  private static void uncheckTask(String taskNumber) {
    int taskNumberInt = Integer.parseInt(taskNumber);
    taskManager.checkTask(taskNumberInt, false);
  }
}
