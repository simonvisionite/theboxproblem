package se.simon.theboxproblem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.simon.theboxproblem.model.Box;
import se.simon.theboxproblem.model.Item;
import se.simon.theboxproblem.model.OrderItem;
import se.simon.theboxproblem.service.BoxPackingService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TheboxproblemApplication implements CommandLineRunner {

  @Autowired
  private BoxPackingService boxPackingService;

  // This is the main method that starts the Spring Boot application.
  // It also implements CommandLineRunner to execute code after the application context is loaded.
  // The run method is called with command line arguments.
  // It parses the order items from the command line arguments and finds the smallest box for each order.
  // If no arguments are provided, it prints a message to the console.
  // If the smallest box is found, it prints the box ID; otherwise, it indicates that pickup is required.
  // Example usage:
  // java -jar theboxproblem-0.0.1-SNAPSHOT.jar "6 st artikel 7, 2 st artikel 4, 4 st artikel 1"
	public static void main(String[] args) {
		SpringApplication.run(TheboxproblemApplication.class, args);
  }

  @Override
  public void run(String... args) {

    if (args.length == 0) {
      System.out.println("Please provide the order items as a command line argument.");
      return;
    }

    for (String arg : args) {
      Box smallestBox = boxPackingService.findSmallestBox(
          parseOrderItems(arg),
          List.of(Box.fromId(1), Box.fromId(2), Box.fromId(3))
      );

      if (smallestBox == null) {
        System.out.println(arg + " => Upphämtning krävs");
      } else {
      System.out.println(arg + " => kartong nr: " + smallestBox.getId());
      }
    }
  }

  public static List<OrderItem> parseOrderItems(String input) {
    List<OrderItem> orderItems = new ArrayList<>();
    String[] parts = input.split(", ");
    for (String part : parts) {
      String[] tokens = part.split(" st artikel ");
      int quantity = Integer.parseInt(tokens[0].trim());
      int itemId = Integer.parseInt(tokens[1].trim());
      orderItems.add(new OrderItem(Item.fromId(itemId), quantity));
    }
    return orderItems;
  }

}
