package src;

import java.io.File;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    // Menerima input
    Scanner input = new Scanner(System.in);
    System.out.println("                       _                           _                           _      ");
    System.out.println("                      | |                         | |                         | |     ");
    System.out.println("__      _____  _ __ __| |  ___  ___  __ _ _ __ ___| |__    _ __  _   _ _______| | ___ ");
    System.out.println("\\ \\ /\\ / / _ \\| '__/ _` | / __|/ _ \\/ _` | '__/ __| '_ \\  | '_ \\| | | |_  /_  / |/ _ \\");
    System.out.println(" \\ V  V / (_) | | | (_| | \\__ \\  __/ (_| | | | (__| | | | | |_) | |_| |/ / / /| |  __/");
    System.out.println("  \\_/\\_/ \\___/|_|  \\__,_| |___/\\___|\\__,_|_|  \\___|_| |_| | .__/ \\__,_/___/___|_|\\___|");
    System.out.println("                                                          | |                         ");
    System.out.println("                                                          |_|                         ");                                                                           
    System.out.print("Nama file (tanpa.txt) : ");
    String filename = "../test/" + input.next() + ".txt";
    input.close();
    
    // Membuka file
    try {
      File file = new File(filename);
      Scanner sc = new Scanner(file);

      // Start perhitungan waktu
      long start = System.nanoTime();

      // Membuat parameter penulisan puzzle
      boolean thePuzzle = true;

      // Inisialisasi arraylist untuk menaruh clue dan puzzle
      ArrayList<String> clue = new ArrayList<String>();
      ArrayList<char[]> puzzle = new ArrayList<char[]>();

      // Penulisan puzzle
      System.out.println();
      System.out.println("[Puzzle] :");

      // Membaca file
      while (sc.hasNext()) {
        // Membaca puzzle
        if (thePuzzle) {
          String fileContent = "";
          fileContent = sc.nextLine();
          System.out.println(fileContent);
          if (fileContent == "") {
            thePuzzle = false;
          } else {
            fileContent = fileContent.replaceAll("\\W", "");
            char[] ch = fileContent.toCharArray();
            puzzle.add(ch);
          }
        }

        // Membaca clue
        if (!thePuzzle) {
          String cluePart = "";
          cluePart = sc.nextLine();
          clue.add(cluePart);
        }
      }

      // Penulisan clue
      System.out.println("[Clue] : " + clue);
      System.out.println();

      // Mencari karakteristik word search
      int row = puzzle.size();
      char[] ch = puzzle.get(0);
      int col = ch.length;
      System.out.println("Ukuran Puzzle : " + row + " x " + col);
      System.out.println("Jumlah Keyword : " + clue.size());
      System.out.println();

      // Menutup scanner
      sc.close();

      // Menyelesaikan word search
      Solver.mainSolver(clue, puzzle);

      // Menulis waktu
      long end = System.nanoTime();
      long elapsedTime = end - start;
      double seconds = (double) elapsedTime / 1_000_000_000.0;
      System.out.println("[Runtime] : " + seconds + " sec");
    } catch (Exception e) {
      System.out.println("Penulisan nama file salah atau file tidak dapat terbaca dengan baik.");
    }
  }
}
