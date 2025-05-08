package se.simon.theboxproblem.model;

public class OrderItem {
  private final Item item;
  private final int amount;

  public OrderItem(Item item, int amount) {
    this.item = item;
    this.amount = amount;
  }

  public Item getItem() {
    return item;
  }

  public int getAmount() {
    return amount;
  }
}
