package se.simon.theboxproblem.model;

public enum Item {
    ITEM_1(1, 1, 1),
    ITEM_2(2, 1, 2),
    ITEM_3(3, 1, 4),
    ITEM_4(4, 1, 6),
    ITEM_5(5, 1, 8),
    ITEM_6(6, 1, 9),
    ITEM_7(7, 1, 12),
    ITEM_8(8, 1, 5),
    ITEM_9(9, 1, 9);

  private int id;
  private int width;
  private int height;

  Item(int id, int width, int height) {
    this.id = id;
    this.width = width;
    this.height = height;
  }

  public static Item fromId(int id) {
    for (Item item : values()) {
      if (item.id == id) {
        return item;
      }
    }
    throw new IllegalArgumentException("No item found with id: " + id);
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
