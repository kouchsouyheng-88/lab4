package lab4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class exercise7 {

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

    
        processAndWriteGroups(rows);
    }
  
    static void processAndWriteGroups(ArrayList<String> rows) {
      
        String[] groups = {"group A", "group B", "group C", "group D"};

        System.out.println("===== LAB 04 - EXERCISE 7 =====");

        for (String g : groups) {
            int total = 0;
            int male = 0;
            int female = 0;

         
            String fileName = g.replace(" ", "") + ".csv";

           
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                
               
                for (String row : rows) {
                    String[] p = row.split(",");
                    
                    
                    if (p[2].equals(g)) {
                        total++;
                        if (p[1].equals("male")) {
                            male++;
                        } else {
                            female++;
                        }
                        
                        // 2. Write the student's data to the file
                        writer.write(row);
                        writer.newLine();
                    }
                }

 
                double malePercent = total == 0 ? 0 : male * 100.0 / total;
                double femalePercent = total == 0 ? 0 : female * 100.0 / total;

         
                writer.write("--- SUMMARY ---\n");
                writer.write("Total Students: " + total + "\n");
                writer.write(String.format("Male: %d (%.2f%%)\n", male, malePercent));
                writer.write(String.format("Female: %d (%.2f%%)\n", female, femalePercent));

              
                System.out.println("Successfully created " + fileName);
                System.out.println(g + ": " + total + " students");
                System.out.printf("   Male: %d (%.2f%%)%n", male, malePercent);
                System.out.printf("   Female: %d (%.2f%%)%n", female, femalePercent);
                System.out.println();

            } catch (IOException e) {
                System.out.println("Error writing to file: " + fileName);
                e.printStackTrace();
            }
        }
    }
}