package lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class exercise6 {

    public static void main(String[] args) {

        ArrayList<String> rows = new ArrayList<>();
     
        try (
            BufferedReader reader = new BufferedReader(new FileReader("CandidatePerformanceTest.csv"))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (lineNumber > 3 && !line.equals("")) {
                    rows.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        question1(rows);
        question2(rows);
        question3(rows);
        question4(rows);
    }
  
    static void question1(ArrayList<String> rows) {
        int total = 0;
        int male = 0;
        int female = 0;

        for (String row : rows) {
            String[] p = row.split(",");
            total++;
            if (p[1].equals("male")) {
                male++;
            } else {
                female++;
            }
        }

        System.out.println("===== Question 1 =====");
        System.out.println("Total candidates: " + total);
        System.out.printf("Male: %d (%.2f%%)%n", male, male * 100.0 / total);
        System.out.printf("Female: %d (%.2f%%)%n", female, female * 100.0 / total);
    }


    static void question2(ArrayList<String> rows) {
        int total = 0;
        int male = 0;
        int female = 0;

        for (String row : rows) {
            String[] p = row.split(",");
            double average = Double.parseDouble(p[9]);
            if (average >= 90) {
                total++;
                if (p[1].equals("male")) {
                    male++;
                } else {
                    female++;
                }
            }
        }

        System.out.println("\n===== Question 2 =====");
        System.out.println("Candidates with average >= 90: " + total);
        System.out.printf("Male: %d (%.2f%%)%n", male, male * 100.0 / total);
        System.out.printf("Female: %d (%.2f%%)%n", female, female * 100.0 / total);
    }

    static void question3(ArrayList<String> rows) {
        int math = 0;
        int english = 0;
        int computer = 0;
        int all = 0;  

        for (String row : rows) {
            String[] p = row.split(",");
            int m = Integer.parseInt(p[5]);
            int e = Integer.parseInt(p[6]);
            int c = Integer.parseInt(p[7]);

            if (m >= 85) {
                math++;
            }
            if (e >= 85) {
                english++;
            }
            if (c >= 85) {
                computer++;
            }
            if (m >= 85 && e >= 85 && c >= 85) {
                all++;
            }
        }

        System.out.println("\n===== Question 3 =====");
        System.out.println("Math >= 85: " + math);
        System.out.println("English >= 85: " + english);
        System.out.println("Computer >= 85: " + computer);
        System.out.println("All 3 subjects >= 85: " + all);
    }

   
    static void question4(ArrayList<String> rows) {
        String[] groups = {"group A", "group B", "group C", "group D", "group E"};

        System.out.println("\n===== Question 4 =====");

        for (String g : groups) {
            int total = 0;
            int male = 0;
            int female = 0;

            for (String row : rows) {
                String[] p = row.split(",");
                if (p[2].equals(g)) {
                    total++;
                    if (p[1].equals("male")) {
                        male++;
                    } else {
                        female++;
                    }
                }
            }

            System.out.println(g + ": " + total + " students");
            System.out.printf("   Male: %d (%.2f%%)%n", male, male * 100.0 / total);
            System.out.printf("   Female: %d (%.2f%%)%n", female, female * 100.0 / total);
        }
    }
}