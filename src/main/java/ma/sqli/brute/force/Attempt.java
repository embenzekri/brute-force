package ma.sqli.brute.force;

public class Attempt {
    private static  int value;
    public Attempt(){}
    public static int incrementValue()
    {
        return value++;
    }
    public static void setZero()
    {
        value=0;
    }
    public static int getValue()
    {
        return value;
    }
}
