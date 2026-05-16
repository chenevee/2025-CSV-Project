import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class DataManager {
    public static void main(String[] args) {
        ArrayList<Athlete> roster = new ArrayList<>();
        String fileName = "Lake County Men's 100m Dash Data.csv";

        try {
            Scanner fileReader = new Scanner(new File(fileName));
            ArrayList<Double> times = new ArrayList<>();
            ArrayList<Double> windSpeeds = new ArrayList<>();
            double totalTime = 0;
            double totalWind = 0;
            int numCompetitors = 0;
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
                String Athlete = data[0];
                String Sponsor = data[1];
                double time = Double.parseDouble(data[2]);
                totalTime += time;
                double windSpeed = Double.parseDouble(data[3]);
                totalWind += windSpeed;
                int heat = Integer.parseInt(data[4]);
                int LN = Integer.parseInt(data[5]);
                Runner runMan = new Runner(Athlete,Sponsor,time,windSpeed,heat,LN);
                System.out.println(runMan);
                times.add(time);
                windSpeeds.add(time);
                numCompetitors += 1;
                // TODO: roster.add(new Athlete(...));
            }
            fileReader.close();
            System.out.println("Successfully loaded " + roster.size() + " records.");
            double meanTime = totalTime/numCompetitors;
            double meanWind = totalWind/numCompetitors;
            double minTime = 999999999999;
            double maxTime = 0;
            double minWind= 99999999999999;
            double maxWind = 0;
            double SDCalculationTime = 0;
            double SDCalculationWind = 0;
            for (double time:times){
                if (time < minTime){
                    minTime = time;
                }
                if (time > maxTime){
                    maxTime = time;
                }
                SDCalculationTime += ((time - meanTime)*(time-meanTime));
            } 
            double StandardDeviationTime = Math.sqrt(SDCalculationTime/(numCompetitors-1));

            for (double wind:windSpeeds){
                if (wind < minWind){
                    minWind = wind;
                }
                if (wind > maxWind){
                    maxWind = wind;
                }
                SDCalculationWind += ((wind - meanWind)*(wind-meanWind));
            } 
            double StandardDeviationWind = Math.sqrt(SDCalculationWind/(numCompetitors-1));

            Collections.sort(times);
            Collections.sort(windSpeeds);
            double medianTime = 0;
            double medianWind = 0;
            if (numCompetitors % 2 != 0){
                medianTime = times.get(numCompetitors/2);
                medianWind = windSpeeds.get(numCompetitors/2);
            }
            else{
                medianTime = (times.get(numCompetitors/2-1) + times.get(numCompetitors/2))/2;
                medianWind = (windSpeeds.get(numCompetitors/2-1)+windSpeeds.get(numCompetitors/2))/2;

            }
            System.out.println("The Statistician has entered the room and will analyze the data");
            System.out.println("The average time is " + meanTime);
            System.out.println("The median data point of the run times was " + medianTime);
            System.out.println("The fastest time someone ran was " + minTime);
            System.out.println("The slowest time someone ran was " + maxTime);
            System.out.println("The standard deviation of the data of run times was " + StandardDeviationTime);
            System.out.println();
            System.out.println("The average wind speed is " + meanWind);
            System.out.println("The median data point of the run times was " + medianWind);
            System.out.println("The most helpful wind speed was " + minWind);
            System.out.println("The least helpful wind speed was " + maxWind);
            System.out.println("The standard deviation of the data of wind speeds was " + StandardDeviationWind);

        } catch (FileNotFoundException e){
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
        return name + " who is sponsored by " + sponsorship + " ended up with a time of " + result + ", the  conditions for him were a wind speed of" + wind + ", a temp of " + heat + ", and a LN of " + LN;
    }
}
