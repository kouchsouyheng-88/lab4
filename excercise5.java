package lab4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class excercise5 {

    public static void main(String[] args) {

        ArrayList<String> studentData = new ArrayList<>();

        try (
            BufferedReader reader = new BufferedReader(new FileReader("StudentData.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.equals("")) {          
                    studentData.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        studentData.add("Oudam");
        studentData.add("Vatey");
        studentData.add("MengCheu");

        Collections.sort(studentData);
        try (
            BufferedWriter writer = new BufferedWriter(new FileWriter("StudentData.csv"))) {
            for (String row : studentData) {
                writer.write(row);
                writer.newLine();
            }
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}