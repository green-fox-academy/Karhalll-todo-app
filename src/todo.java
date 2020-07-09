public class todo {
  public static void main(String[] args) {
    if (args.length == 0) {
      printInfo();
    } else {
      for (String s : args) {
        switch (s) {
          case "-l":
            System.out.println("switch");
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
}
