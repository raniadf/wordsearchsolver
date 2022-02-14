package src;

import java.util.*;

public class Solver {

    /**
     * checkDown
     * Menyelesaikan word search yang jawabannya menurun
     * @param puzzle ArrayList of character array
     * @param clue   String
     * @param key    array of integer
     * @return boolean
     * tes
     */
    public static boolean checkDown(ArrayList<char[]> puzzle, String clue, int[] key) {
        // Inisialisasi variabel-variabel utama
        boolean check = true;
        int colkey = key[1];
        int rowstart = key[0];
        int row = puzzle.size();
        char[] ch = puzzle.get(0);
        int col = ch.length;
        int rowend = rowstart + clue.length() - 1;

        // Apabila jumlah row ke bawahnya melebihi panjang row puzzlenya, otomatis false
        if (rowend > puzzle.size() - 1) {
            check = false;
        } else {
            // Memulai pengecekan dari index clue ke-1
            int indexclue = 1;
            // Loop ke bawah
            for (int i = rowstart + 1; i <= rowend; i++) {
                // Apabila bagian puzzle yang dicek tidak sama dengan karakter clue yang sedang
                // dicek, otomatis false
                if (puzzle.get(i)[colkey] != clue.charAt(indexclue)) {
                    check = false;
                    break;
                }
                indexclue++;
            }
        }

        // Print jawaban apabila jawaban ditemukan
        if (check) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == rowstart && j == colkey && (rowstart <= rowend)) {
                        System.out.print(" " + puzzle.get(i)[j] + " ");
                        rowstart++;
                    } else {
                        System.out.print(" - ");
                    }
                }
                System.out.println();
            }
        }

        return check;
    }

    /**
     * checkDownRight
     * Menyelesaikan word search yang jawabannya menurun ke kanan
     * @param puzzle ArrayList of character array
     * @param clue   String
     * @param key    array of integer
     * @return boolean
     */
    public static boolean checkDownRight(ArrayList<char[]> puzzle, String clue, int[] key) {
        // Inisialisasi variabel-variabel utama
        boolean check = true;
        int rowstart = key[0];
        int colstart = key[1];
        int row = puzzle.size();
        char[] ch = puzzle.get(0);
        int col = ch.length;
        int rowend = rowstart + clue.length() - 1;
        int colend = colstart + clue.length() - 1;

        // Apabila jumlah row ke bawahnya melebihi panjang row puzzlenya, otomatis false
        // Apabila jumlah col ke kanannya melebihi panjang col puzzlenya, otomatis false
        if ((rowend > puzzle.size() - 1) || (colend > col - 1)) {
            check = false;
        } else {
            // Memulai pengecekan dari index clue ke-1
            int indexclue = 1;
            // Loop ke bawah kanan
            int j = colstart + 1;
            for (int i = rowstart + 1; i <= rowend; i++) {
                // Apabila bagian puzzle yang dicek tidak sama dengan karakter clue yang sedang
                // dicek, otomatis false
                if (puzzle.get(i)[j] != clue.charAt(indexclue)) {
                    check = false;
                    break;
                }
                indexclue++;
                j++;
            }
        }

        // Print jawaban apabila jawaban ditemukan
        if (check) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == rowstart && j == colstart && (rowstart <= rowend) && (colstart <= colend)) {
                        System.out.print(" " + puzzle.get(i)[j] + " ");
                        rowstart++;
                        colstart++;
                    } else {
                        System.out.print(" - ");
                    }
                }
                System.out.println();
            }
        }

        return check;
    }

    /**
     * checkDownLeft
     * Menyelesaikan word search yang jawabannya menurun ke kiri
     * @param puzzle ArrayList of character array
     * @param clue   String
     * @param key    array of integer
     * @return boolean
     */
    public static boolean checkDownLeft(ArrayList<char[]> puzzle, String clue, int[] key) {
        // Inisialisasi variabel-variabel utama
        boolean check = true;
        int rowstart = key[0];
        int colstart = key[1];
        int row = puzzle.size();
        char[] ch = puzzle.get(0);
        int col = ch.length;
        int rowend = rowstart + clue.length() - 1;
        int colend = colstart - clue.length() + 1;

        // Apabila jumlah row ke bawahnya melebihi panjang row puzzlenya, otomatis false
        // Apabila jumlah col ke kirinya kurang dari 0, otomatis false
        if ((rowend > puzzle.size() - 1) || (colend < 0)) {
            check = false;
        } else {
            // Memulai pengecekan dari index clue ke-1
            int indexclue = 1;
            // Loop ke bawah kiri
            int j = colstart - 1;
            for (int i = rowstart + 1; i <= rowend; i++) {
                // Apabila bagian puzzle yang dicek tidak sama dengan karakter clue yang sedang
                // dicek, otomatis false
                if (puzzle.get(i)[j] != clue.charAt(indexclue)) {
                    check = false;
                    break;
                }
                indexclue++;
                j--;
            }
        }

        // Print jawaban apabila jawaban ditemukan
        if (check) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == rowstart && j == colstart && (rowstart <= rowend) && (colstart >= colend)) {
                        System.out.print(" " + puzzle.get(i)[j] + " ");
                        rowstart++;
                        colstart--;
                    } else {
                        System.out.print(" - ");
                    }
                }
                System.out.println();
            }
        }

        return check;
    }

    /**
     * checkUp
     * Menyelesaikan word search yang jawabannya naik
     * @param puzzle ArrayList of character array
     * @param clue   String
     * @param key    array of integer
     * @return boolean
     */
    public static boolean checkUp(ArrayList<char[]> puzzle, String clue, int[] key) {
        // Inisialisasi variabel-variabel utama
        boolean check = true;
        int colkey = key[1];
        int rowstart = key[0];
        int row = puzzle.size();
        char[] ch = puzzle.get(0);
        int col = ch.length;
        int rowend = rowstart - clue.length() + 1;

        // Apabila jumlah row ke atasnya < 0, otomatis false
        if (rowend < 0) {
            check = false;
        } else {
            // Memulai pengecekan dari index clue ke-1
            int indexclue = 1;
            // Loop ke atas
            for (int i = rowstart - 1; i >= rowend; i--) {
                // Apabila bagian puzzle yang dicek tidak sama dengan karakter clue yang sedang
                // dicek, otomatis false
                if (puzzle.get(i)[colkey] != clue.charAt(indexclue)) {
                    check = false;
                    break;
                }
                indexclue++;
            }
        }

        // Print jawaban apabila jawaban ditemukan
        if (check) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == rowend && j == colkey && (rowend <= rowstart)) {
                        System.out.print(" " + puzzle.get(i)[j] + " ");
                        rowend++;
                    } else {
                        System.out.print(" - ");
                    }
                }
                System.out.println();
            }
        }

        return check;
    }

    /**
     * checkUpRight
     * Menyelesaikan word search yang jawabannya naik ke kanan
     * @param puzzle ArrayList of character array
     * @param clue   String
     * @param key    array of integer
     * @return boolean
     */
    public static boolean checkUpRight(ArrayList<char[]> puzzle, String clue, int[] key) {
        // Inisialisasi variabel-variabel utama
        boolean check = true;
        int rowstart = key[0];
        int colstart = key[1];
        int row = puzzle.size();
        char[] ch = puzzle.get(0);
        int col = ch.length;
        int rowend = rowstart - clue.length() + 1;
        int colend = colstart + clue.length() - 1;

        // Apabila jumlah row ke atasnya < 0, otomatis false
        // Apabila jumlah col ke kanannya melebihi panjang kolom puzzle, otomatis false
        if ((rowend < 0) || (colend > col - 1)) {
            check = false;
        } else {
            // Memulai pengecekan dari index clue terakhir
            int indexclue = clue.length() - 1;
            // Loop ke bawah
            int j = colend;
            for (int i = rowend; i <= rowstart; i++) {
                // Apabila bagian puzzle yang dicek tidak sama dengan karakter clue yang sedang
                // dicek, otomatis false
                if (puzzle.get(i)[j] != clue.charAt(indexclue)) {
                    check = false;
                    break;
                }
                indexclue--;
                j--;
            }
        }

        // Print jawaban apabila jawaban ditemukan
        if (check) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == rowend && j == colend && (rowend <= rowstart) && (colstart <= colend)) {
                        System.out.print(" " + puzzle.get(i)[j] + " ");
                        rowend++;
                        colend--;
                    } else {
                        System.out.print(" - ");
                    }
                }
                System.out.println();
            }
        }

        return check;
    }

    /**
     * checkUpLeft
     * Menyelesaikan word search yang jawabannya naik ke kiri
     * @param puzzle ArrayList of character array
     * @param clue   String
     * @param key    array of integer
     * @return boolean
     */
    public static boolean checkUpLeft(ArrayList<char[]> puzzle, String clue, int[] key) {
        // Inisialisasi variabel-variabel utama
        boolean check = true;
        int rowstart = key[0];
        int colstart = key[1];
        int row = puzzle.size();
        char[] ch = puzzle.get(0);
        int col = ch.length;
        int rowend = rowstart - clue.length() + 1;
        int colend = colstart - clue.length() + 1;

        // Apabila jumlah row ke atasnya < 0, otomatis false
        // Apabila jumlah col ke kirinya < 0, otomatis false
        if ((rowend < 0) || (colend < 0)) {
            check = false;
        } else {
            // Memulai pengecekan dari index clue terakhir
            int indexclue = clue.length() - 1;
            // Loop ke bawah
            int j = colend;
            for (int i = rowend; i <= rowstart; i++) {
                // Apabila bagian puzzle yang dicek tidak sama dengan karakter clue yang sedang
                // dicek, otomatis false
                if (puzzle.get(i)[j] != clue.charAt(indexclue)) {
                    check = false;
                    break;
                }
                indexclue--;
                j++;
            }
        }

        // Print jawaban apabila jawaban ditemukan
        if (check) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == rowend && j == colend && (rowend <= rowstart) && (colend <= colstart)) {
                        System.out.print(" " + puzzle.get(i)[j] + " ");
                        rowend++;
                        colend++;
                    } else {
                        System.out.print(" - ");
                    }
                }
                System.out.println();
            }
        }

        return check;
    }

    /**
     * checkRight
     * Menyelesaikan word search yang mendatar ke kanan
     * @param puzzle ArrayList of character array
     * @param clue   String
     * @param key    array of integer
     * @return boolean
     */
    public static boolean checkRight(ArrayList<char[]> puzzle, String clue, int[] key) {
        // Inisialisasi variabel-variabel utama
        boolean check = true;
        int colstart = key[1];
        int rowkey = key[0];
        int row = puzzle.size();
        char[] ch = puzzle.get(0);
        int col = ch.length;
        int colend = colstart + clue.length() - 1;

        // Apabila jumlah col ke kanannya melebihi panjang kolom puzzle, otomatis false
        if (colend > col - 1) {
            check = false;
        } else {
            // Memulai pengecekan dari index clue ke-1
            int indexclue = 1;
            // Loop ke kanan
            for (int i = colstart + 1; i <= colend; i++) {
                // Apabila bagian puzzle yang dicek tidak sama dengan karakter clue yang sedang
                // dicek, otomatis false
                if (puzzle.get(rowkey)[i] != clue.charAt(indexclue)) {
                    check = false;
                    break;
                }
                indexclue++;
            }
        }
        
        // Print jawaban apabila jawaban ditemukan
        if (check) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == rowkey && j == colstart && (colstart <= colend)) {
                        System.out.print(" " + puzzle.get(i)[j] + " ");
                        colstart++;
                    } else {
                        System.out.print(" - ");
                    }
                }
                System.out.println();
            }
        }

        return check;
    }

    /**
     * checkLeft
     * Menyelesaikan word search yang jawabannya mendatar ke kiri
     * @param puzzle ArrayList of character array
     * @param clue   String
     * @param key    array of integer
     * @return boolean
     */
    public static boolean checkLeft(ArrayList<char[]> puzzle, String clue, int[] key) {
        // Inisialisasi variabel-variabel utama
        boolean check = true;
        int colstart = key[1];
        int rowkey = key[0];
        int row = puzzle.size();
        char[] ch = puzzle.get(0);
        int col = ch.length;
        int colend = colstart - clue.length() + 1;

        // Apabila jumlah col ke kirinya < 0, otomatis false
        if (colend < 0) {
            check = false;
        } else {
            // Memulai pengecekan dari index clue terakhir
            int indexclue = 1;
            // Loop ke kiri
            for (int i = colstart - 1; i >= colend; i--) {
                // Apabila bagian puzzle yang dicek tidak sama dengan karakter clue yang sedang
                // dicek, otomatis false
                if (puzzle.get(rowkey)[i] != clue.charAt(indexclue)) {
                    check = false;
                    break;
                }
                indexclue++;
            }
        }

        // Print jawaban apabila jawaban ditemukan
        if (check) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == rowkey && j == colend && (colend <= colstart)) {
                        System.out.print(" " + puzzle.get(i)[j] + " ");
                        colend++;
                    } else {
                        System.out.print(" - ");
                    }
                }
                System.out.println();
            }
        }

        return check;
    }

    public static void mainSolver(ArrayList<String> clue, ArrayList<char[]> puzzle) {
        // Inisialisasi variabel utama
        int row = puzzle.size();
        char[] ch = puzzle.get(0);
        int col = ch.length;
        int word = row * col;
        // System.out.println(word);

        // Looping untuk mencari semua jawaban dari clue sebanyak jumlah clue
        for (int clueidx = 0; clueidx < clue.size(); clueidx++) {
            // Mengambil clue
            String key = clue.get(clueidx);
            // Mengambil huruf pertama dari clue
            char fword = key.charAt(0);
            // Membuat parameter menemukan clue
            boolean found = false;
            // Menghitung jumlah huruf yang dicari
            int wordcount = 1;

            // Menulis kata yang sedang dicari ke layar
            System.out.println((clueidx + 1) + ". " + key + " :");

            // Loop
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (fword == puzzle.get(i)[j]) {
                        int[] keyindex = new int[2];

                        // Membuat indeks kunci awal kata
                        keyindex[0] = i;
                        keyindex[1] = j;

                        // Mencari sisa karakter pada jawaban
                        if (checkDown(puzzle, key, keyindex)) {
                            found = true;
                        } else if (checkUp(puzzle, key, keyindex)) {
                            found = true;
                        } else if (checkLeft(puzzle, key, keyindex)) {
                            found = true;
                        } else if (checkRight(puzzle, key, keyindex)) {
                            found = true;
                        } else if (checkDownRight(puzzle, key, keyindex)) {
                            found = true;
                        } else if (checkUpRight(puzzle, key, keyindex)) {
                            found = true;
                        } else if (checkDownLeft(puzzle, key, keyindex)) {
                            found = true;
                        } else if (checkUpLeft(puzzle, key, keyindex)) {
                            found = true;
                        }
                    }

                    // Break dari loop column ketika jawaban sudah ditemukan
                    if (found) {
                        break;
                    }
                    wordcount++;
                }

                // Break dari loop row ketika jawaban sudah ditemukan
                if (found) {
                    break;
                }
                wordcount++;
            }
            System.out.println("Perbandingan kata : " + wordcount + "/" + word);
            System.out.println();

        }
    }
}
