import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class DataManager {
    public static void main(String[] args) {
        ArrayList<Athlete> roster = new ArrayList<>();
        String fileName = "Lake County Men's 100m Dash Data.csv";

        try {
            Scanner fileReader = new Scanner(new File(fileName));
            ArrayList<double> times = new ArrayList<>;
            ArrayList<double> windSpeeds = new ArrayList<>;
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
                Runner 
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


public class Runner{
    private String name;
    private String sponsorship;
    private double result;
    private double wind;
    private int heat;
    private int LN;
    public Runner(String runner, String sponsor, double time, double windSpeed, int Temp, int POS){
        name = runner;
        sponsorship = sponsor;
        result = time;
        wind = windSpeed;
        heat = Temp;
        LN = POS;
    }
    public String toString(){
        return name + " who is sponsored by " + sponsorship + " ended up with a time of " + result + ", the  conditions for him were a wind speed of"
    }
}--
