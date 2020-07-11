public class Task {
  public String name;
  public boolean isChecked;

  public Task(String fileLine) {
    name = fileLine.substring(1);
    isChecked = isChecked(fileLine);
  }

  public Task(String name, boolean isChecked) {
    this.name = name;
    this.isChecked = isChecked;
  }

  public String taskToString() {
    String line = "";

    if (isChecked) {
      line += '@';
    } else {
      line += ' ';
    }

    line += name;
    return line;
  }

  public void check(boolean state) {
    isChecked = state;
  }

  private boolean isChecked(String fileLine) {
    boolean isChecked = false;
    char checkChar = fileLine.charAt(0);

    try {
      if (checkChar == '@') {
        isChecked = true;
      } else if (checkChar == ' ') {
        isChecked = false;
      }
    } catch (Exception e) {
      isChecked = false;
      System.out.println("Could not read checked state of [" + name + "] task in file!");
    }

    return isChecked;
  }
}
