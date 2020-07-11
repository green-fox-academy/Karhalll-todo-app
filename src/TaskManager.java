import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
  List<Task> tasks;

  Path filePath;

  public TaskManager() {
    tasks = new ArrayList<>();

    try {
      filePath = Paths.get("assets/tasks.txt");
      List<String> lines = Files.readAllLines(filePath);

      createTaskList(lines);
    } catch (Exception e) {
      System.out.println("Could not read the tasks.txt file!");
    }
  }

  public void showTasks() {
    if (tasks.size() > 0) {
      for (int i = 0; i < tasks.size(); i++) {
        Task task = tasks.get(i);
        System.out.println((i+1) + " - " + "[" + checkedChar(task) + "] " + task.name);
      }
    } else {
      System.out.println("No todos for today! :)");
    }
  }

  public void addTask(String taskName) {
    tasks.add(new Task(taskName, false));
    saveToFile();
  }

  public void removeTask(int taskNumber) {
    try {
      tasks.remove(taskNumber - 1);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Unable to remove: index is out of bound");
    }

    saveToFile();
  }

  public void checkTask(int taskNumber, boolean state) {
    try {
      tasks.get(taskNumber - 1).check(state);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Unable to remove: index is out of bound");
    }

    saveToFile();
  }

  private void createTaskList(List<String> lines) {
    for (String line : lines) {
      tasks.add(new Task(line));
    }
  }

  private char checkedChar(Task task) {
    if (task.isChecked) {
      return 'X';
    } else {
      return ' ';
    }
  }

  private void saveToFile() {
    List<String> lines = new ArrayList<>();
    for (Task task : tasks) {
      lines.add(task.taskToString());
    }

    try {
      Files.write(filePath, lines);
    } catch (IOException e) {
      System.out.println("Cannot write to tasks.txt file.");
    }
  }
}
