package se.simon.theboxproblem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.simon.theboxproblem.model.Box;
import se.simon.theboxproblem.model.Item;
import se.simon.theboxproblem.model.OrderItem;
import se.simon.theboxproblem.service.BoxPackingService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoxPackingServiceTest {

  @Autowired
  private BoxPackingService boxPackingService;

  // 6 st artikel 7, 2 st artikel 4, 4 st artikel 1=> kartong nr 2
  @Test
  public void testFindSmallestBox() {
    // Test data
    List<OrderItem> orderItems = List.of(
        new OrderItem(Item.fromId(7), 6),
        new OrderItem(Item.fromId(4), 2),
        new OrderItem(Item.fromId(1), 4)
    );
    List<Box> boxes = List.of(Box.fromId(1),
        Box.fromId(2),
        Box.fromId(3)
    );

    // Call the method
    Box result = boxPackingService.findSmallestBox(orderItems, boxes);

    // Assertions
    assertNotNull(result);
    assertEquals(2, result.getId());
  }

  // 3 st artikel 3, 1 st artikel 1, 1 st artikel 2=> kartong nr 1
  @Test
  public void testFindSmallestBox2() {
    // Test data
    List<OrderItem> orderItems = List.of(
        new OrderItem(Item.fromId(3), 3),
        new OrderItem(Item.fromId(1), 1),
        new OrderItem(Item.fromId(2), 1)
    );
    List<Box> boxes = List.of(Box.fromId(1),
        Box.fromId(2),
        Box.fromId(3)
    );

    // Call the method
    Box result = boxPackingService.findSmallestBox(orderItems, boxes);

    // Assertions
    assertNotNull(result);
    assertEquals(1, result.getId());
  }

  // 1 st artikel 5, 3 st artikel 4=> kartong nr 2
  @Test
  public void testFindSmallestBox3() {
    // Test data
    List<OrderItem> orderItems = List.of(
        new OrderItem(Item.fromId(5), 1),
        new OrderItem(Item.fromId(4), 3)
    );
    List<Box> boxes = List.of(Box.fromId(1),
        Box.fromId(2),
        Box.fromId(3)
    );

    // Call the method
    Box result = boxPackingService.findSmallestBox(orderItems, boxes);

    // Assertions
    assertNotNull(result);
    assertEquals(2, result.getId());
  }

  // 12 st artikel 7, 100 st artikel 1=>"Upphämtning krävs"
  @Test
  public void testFindSmallestBox4() {
    // Test data
    List<OrderItem> orderItems = List.of(
        new OrderItem(Item.fromId(7), 12),
        new OrderItem(Item.fromId(1), 100)
    );
    List<Box> boxes = List.of(Box.fromId(1),
        Box.fromId(2),
        Box.fromId(3)
    );

    // Call the method
    Box result = boxPackingService.findSmallestBox(orderItems, boxes);

    // Assertions
    assertNull(result);
  }

  // 4 st artikel 8=> kartong nr 1
  @Test
  public void testFindSmallestBox5() {
    // Test data
    List<OrderItem> orderItems = List.of(
        new OrderItem(Item.fromId(8), 4)
    );
    List<Box> boxes = List.of(Box.fromId(1),
        Box.fromId(2),
        Box.fromId(3)
    );

    // Call the method
    Box result = boxPackingService.findSmallestBox(orderItems, boxes);

    // Assertions
    assertNotNull(result);
    assertEquals(1, result.getId());
  }




}
