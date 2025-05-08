package se.simon.theboxproblem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TheboxproblemApplicationTests {

	@Test
	void mainTest() {
    TheboxproblemApplication.main(new String[] {
        "6 st artikel 7, 2 st artikel 4, 4 st artikel 1",
        "3 st artikel 3, 1 st artikel 1, 1 st artikel 2",
        "1 st artikel 5, 3 st artikel 4",
        "12 st artikel 7, 100 st artikel 1",
        "4 st artikel 8"});
  }
}
