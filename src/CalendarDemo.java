
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/*
*
 * Created by Marie Curie on 10/04/2017.
 */

public class CalendarDemo {

    public static String[] weeklyCalendar(){
        String[] week = new String[7];
        SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        week[0] = sdf.format(cal.getTime());
        System.out.println(sdf.format(cal.getTime()));
        for (int i = 1; i<7; i++){
            cal.add(Calendar.DATE,1);
            week[i] = sdf.format(cal.getTime());
            System.out.println(sdf.format(cal.getTime()));
        }
        return week;
    }
    public static String currentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
        String currentdate = sdf.format(new Date());
        System.out.println(currentdate);
        return currentdate;
    }

    public static boolean isThisDateValid(String dateToValidate){
        if(dateToValidate == null){
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
        sdf.setLenient(false);

        try {
            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);
            System.out.println(date);

        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    public static ArrayList<String> dateSorter(ArrayList<String> datestring) {
        Collections.sort(datestring, new Comparator<String>() {
            DateFormat f = new SimpleDateFormat("M/dd/yyyy");
            @Override
            public int compare(String o1, String o2) {
                try {
                    return f.parse(o1).compareTo(f.parse(o2));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
        for (String s : datestring) {
            System.out.println(s);
        }
        return datestring;
    }
    //first argument should be the current date and the second is the to be compared date

    public static boolean isLate(String currentdate, String compareddate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
            Date date1 = sdf.parse(currentdate);
            Date date2 = sdf.parse(compareddate);

            System.out.println();

            if (date1.after(date2)) {
                System.out.println("it is late");   //returns true if late
                return true;
            }

            System.out.println();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public static String whatdate(String date) throws ParseException {
        SimpleDateFormat newDateFormat = new SimpleDateFormat("M/dd/yyyy");
        Date MyDate = newDateFormat.parse("12/16/1998");
        newDateFormat.applyPattern("EEEE");
        String mydate = newDateFormat.format(MyDate);
        return mydate;
    }
}
