package korostelev_danila.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YearConsts {
    public static final int DAYS_IN_WEEK = 7;
    public static final int MONTHS_IN_YEAR = 12;
    public static final int DAYS_IN_REGULAR_YEAR = 365;
    public static final int DAYS_IN_LEAP_YEAR = 366;

    public static final ArrayList<Integer> DAYS_IN_MONTHS = new ArrayList<>(Arrays.asList(
            31, // Jan
            28, // Feb
            31, // Mar
            30, // Apr
            31, // May
            30, // Jun
            31, // Jul
            31, // Aug
            30, // Sep
            31, // Oct
            30, // Nov
            31  // Dec
            ));

    public static final ArrayList<String> MONTHS_NAMES = new ArrayList<>(Arrays.asList(
       "January",
       "February",
       "March",
       "April",
       "May",
       "June",
       "July",
       "August",
       "September",
       "October",
       "November",
       "December"
    ));
}
