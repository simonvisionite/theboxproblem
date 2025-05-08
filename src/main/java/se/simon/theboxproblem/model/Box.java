package se.simon.theboxproblem.model;

public enum Box {
  BOX_1(1, 4, 5),
  BOX_2(2, 8, 12),
  BOX_3(3, 12, 20);

  private final int id;
  private final int width;
  private final int height;

  Box(int id, int width, int height) {
    this.id = id;
    this.width = width;
    this.height = height;
  }

  public static Box fromId(int id) {
    for (Box box : values()) {
      if (box.id == id) {
        return box;
      }
    }
    throw new IllegalArgumentException("No box found with id: " + id);
  }

  public int getId() {
    return id;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
