package se.simon.theboxproblem.service;

import org.springframework.stereotype.Service;
import se.simon.theboxproblem.model.Box;
import se.simon.theboxproblem.model.Item;
import se.simon.theboxproblem.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoxPackingServiceImpl implements BoxPackingService {

  // This method finds the smallest box that can fit all items.
  @Override
  public Box findSmallestBox(List<OrderItem> items, List<Box> boxes) {

    Box smallestBox = null;

    for (Box box : boxes) {
      int boxVolume = box.getWidth() * box.getHeight();

      // Check if the box can fit all items
      if (canFitInBox(items, box)) {
        if (smallestBox == null ) {
          smallestBox = box;
        } else {
          int smallestBoxVolume = smallestBox.getWidth() * smallestBox.getHeight();
          if (boxVolume < smallestBoxVolume) {
            smallestBox = box;
          }
        }
      }
    }
    return smallestBox;
  }

  // This method checks if all items can fit in the box.
  private static boolean canFitInBox(List<OrderItem> items, Box box) {
    int height = box.getHeight();
    int width = box.getWidth();
    boolean[][] occupied = new boolean[height][width];

    List<Item> toPack = new ArrayList<>();
    items.forEach(orderItem -> {
      for (int i = 0; i < orderItem.getAmount(); i++) {
        toPack.add(orderItem.getItem());
      }
    });

    // Sort items by width in descending order
    toPack.sort((i1, i2) -> Integer.compare(i2.getWidth(), i1.getWidth()));

    for (Item item : toPack) {
      boolean placed = false;

    // Try to place each item in the box
      for (int row = 0; row <= height - item.getHeight(); row++) {
        for (int col = 0; col <= width - item.getWidth(); col++) {
          if (canPlace(occupied, row, col, item)) {
            placeItem(occupied, row, col, item);
            placed = true;
            break;
          }
        }
        if (placed) break;
      }

      if (!placed) {
        return false; // No space for this item box is not big enough
      }
    }

    return true;
  }

  // This method checks if the item can be placed in the box at the given position.
  private static boolean canPlace(boolean[][] occupied, int row, int col, Item item) {
    for (int i = 0; i < item.getHeight(); i++) {
      for (int j = 0; j < item.getWidth(); j++) {
        if (occupied[row + i][col + j]) return false;
      }
    }
    return true;
  }

  // This method places the item in the box at the given position.
  private static void placeItem(boolean[][] occupied, int row, int col, Item item) {
    for (int i = 0; i < item.getHeight(); i++) {
      for (int j = 0; j < item.getWidth(); j++) {
        occupied[row + i][col + j] = true;
      }
    }
  }
}