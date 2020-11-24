package iot.labs.com;


import iot.labs.com.manager.DocumentsManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import static org.junit.jupiter.api.Assertions.assertEquals;

class DocumentsManagerTest {

  private Scanner scanner;

  @BeforeEach
  public void initializeScanner() {
    try {
      scanner = new Scanner(new File("result.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testExample1() {
    DocumentsManager counter = new DocumentsManager();
    counter.runAll("govern2.txt");

    List<String> expected = new ArrayList<>();
    expected.add("foreignpassport");
    expected.add("visa");
    for (String expectedLine : expected) {
      assertEquals(expectedLine, scanner.nextLine());
    }
  }

  @Test
  void testExample2() {
    DocumentsManager counter = new DocumentsManager();
    counter.runAll("govern.txt");

    List<String> expected = new ArrayList<>();
    expected.add("birthcertificate");
    expected.add("nationalpassport");
    expected.add("militarycertificate");
    expected.add("foreignpassport");
    expected.add("creditcard");
    expected.add("bankstatement");
    expected.add("hotel");
    expected.add("visa");
    for (String expectedLine : expected) {
      assertEquals(expectedLine, scanner.nextLine());
    }
  }
}
