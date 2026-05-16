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

