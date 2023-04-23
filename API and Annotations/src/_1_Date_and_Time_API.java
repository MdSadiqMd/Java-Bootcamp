//import java.util.Date;
/*
We have two methods to Import time
1.Using Util Package which returns all information of date and time and no need to give any parameters
2.Using SQL package which returns only Date and need to give a parameter

In terminal write javap java.util.Date we get all Methods in util package

From Java version 1.8 New package called Joda-Time API was Introduced to Simplify Things
 */
public class _1_Date_and_Time_API {
    public static void main(String[] args) {
       /* Date d=new Date();
        System.out.println(d); //Returns your Present Date and Time*/

        java.util.Date d=new java.util.Date();
        System.out.println(d);

        long timeInMs = d.getTime();
        java.sql.Date dt=new java.sql.Date(timeInMs);
        System.out.println(dt);
    }
}
