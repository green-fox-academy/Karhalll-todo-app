import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {
  Path filePath;
  List<String> lines;

  public FileManager() {
    try {
      filePath = Paths.get("assets/tasks.txt");
      lines = Files.readAllLines(filePath);
    } catch (Exception e) {
      System.out.println("Could not read the tasks.txt file!");
    }
  }

  public void showTasks() {
    if (lines.size() > 0) {
      for (int i = 0; i < lines.size(); i++) {
        System.out.println((i+1) + " - " + lines.get(i));
      }
    } else {
      System.out.println("No todos for today! :)");
    }
  }

  public void addTask(String taskName) {
    try {
      lines.add(taskName);
      Files.write(filePath, lines);
    } catch (IOException e) {
      System.out.println("Cannot write to tasks.txt file.");
    }
  }
}
