package iot.labs.com.manager;

import iot.labs.com.read_write.DocumentsWriteRead;

import java.util.*;

public class DocumentsManager {


  public static void runAll(String pathToFile) {
    DocumentsWriteRead documentsWriteRead = new DocumentsWriteRead();
    Map<String, List<String>> docs = documentsWriteRead.readDocsFromFile(pathToFile);
    Set<String> set = setDocs(docs);
    List<String> finalOutput = new ArrayList<>();
    finalOutput.addAll(set);

    for (int i = 0; i < docs.size(); i++) {

      for (Map.Entry<String, List<String>> entry :
              docs.entrySet()) {

        if (!set.contains(entry.getKey()) && set.containsAll(entry.getValue())) {
          set.add(entry.getKey());
          finalOutput.add(entry.getKey());
        }

      }


    }
    documentsWriteRead.writeResult(finalOutput);
    System.out.println(finalOutput);
  }


  public static Set<String> setDocs(Map<String, List<String>> map) {
    Set<String> docs = new HashSet<>();
    map.values().forEach(docs::addAll);
    docs.removeAll(map.keySet());
    return docs;
  }
}
