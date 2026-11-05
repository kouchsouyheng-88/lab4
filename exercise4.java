package lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class exercise4 {

    public static void main(String[] args) {
        ArrayList<String> studentData = new ArrayList<>();

        
        try (BufferedReader reader = new BufferedReader(new FileReader("Ex3StudentData.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                studentData.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        System.out.println("Data from the array list:");
        for (String row : studentData) {
            System.out.println(row);
        }
    }
}