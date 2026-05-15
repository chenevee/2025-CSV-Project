import java.util.*;
import java.io.*;

public class DataManager {
    public static void main(String[] args) {
        ArrayList<Athlete> roster = new ArrayList<>();
        String fileName = "Lake County Men's 100m Dash Data.csv";

        try {
            Scanner fileReader = new Scanner(new File(fileName));
            
            // 1. Skip the header row
            if (fileReader.hasNextLine()) {
                fileReader.nextLine();
            }

            // 2. Loop through the file
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                
                // 3. Split the line by comma
                String[] data = line.split(",");
                
                // 4. Parse data and create Athlete object
                // TODO: roster.add(new Athlete(...));
            }
            
            fileReader.close();
            System.out.println("Successfully loaded " + roster.size() + " records.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: The file '" + fileName + "' was not found.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Failed to parse a numeric value in the CSV.");
        }

        // 5. TODO: Implement your Level Up analysis here!
    }
}
