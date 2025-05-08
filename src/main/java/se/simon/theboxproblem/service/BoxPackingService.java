package se.simon.theboxproblem.service;

import se.simon.theboxproblem.model.Box;
import se.simon.theboxproblem.model.OrderItem;

import java.util.List;

public interface BoxPackingService {

  /**
   * Find the smallest box that can fit all items.
   *
   * @param items the items to pack
   * @param boxes the available boxes
   * @return the smallest box that can fit all items
   */
  Box findSmallestBox(List<OrderItem> items, List<Box> boxes);

}
