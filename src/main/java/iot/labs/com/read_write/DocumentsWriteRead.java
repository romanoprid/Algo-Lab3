package iot.labs.com.read_write;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DocumentsWriteRead {


  public void writeResult(List<String> output) {
    try (FileWriter fileWriter = new FileWriter(new File("result.txt"))) {
      for (String result :
              output) {
        fileWriter.write(result + "\n");
      }
      fileWriter.flush();
    } catch (Exception ignored) {
    }

  }

  public Map<String, List<String>> readDocsFromFile(String fileName) {
    Map<String, List<String>> words = new HashMap<>();

    try (Scanner scanner = new Scanner(new File(fileName))) {
      while (true) {
        String input = null;
        try {
          input = scanner.nextLine();

        } catch (NoSuchElementException ignored) {
        }
        if (input == null) break;

        String[] mass = input.split(" ");

        String firstDoc = mass[0];
        String chainDoc = mass[1];


        List<String> list = words.getOrDefault(firstDoc, new ArrayList<>());
        list.add(chainDoc);
        words.put(firstDoc, list);

      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    return words;
  }
}
