package io.github.persiancalendar.calendar.persian;

import java.util.Arrays;

// A simple and quick implementation just to be compatible with
// https://calendar.ut.ac.ir/Fa/News/Data/Doc/KabiseShamsi1206-1498-new.pdf
// For a correct implementation accurate for ~9k years, have a look at AlgorithmicConverter
// which matches also with the numbers we have here for IRST longitude.
public class LookupTableConverter {

    private static final int startingYear = 1206;
    private static final long[] yearsStartingJdn = new long[1498 - startingYear];

    static {
        int[] leapYears = {
                1210, 1214, 1218, 1222, 1226, 1230, 1234, 1238, 1243, 1247, 1251, 1255, 1259, 1263,
                1267, 1271, 1276, 1280, 1284, 1288, 1292, 1296, 1300, 1304, 1309, 1313, 1317, 1321,
                1325, 1329, 1333, 1337, 1342, 1346, 1350, 1354, 1358, 1362, 1366, 1370, 1375, 1379,
                1383, 1387, 1391, 1395, 1399, 1403, 1408, 1412, 1416, 1420, 1424, 1428, 1432, 1436,
                1441, 1445, 1449, 1453, 1457, 1461, 1465, 1469, 1474, 1478, 1482, 1486, 1490, 1494,
                1498};

        yearsStartingJdn[0] = 2388438; /* jdn of 1206 */
        for (int i = 0, j = 0; i < yearsStartingJdn.length - 1; ++i) {
            int year = i + startingYear;
            yearsStartingJdn[i + 1] = yearsStartingJdn[i] + (leapYears[j] == year ? 366 : 365);
            if (year >= leapYears[j] && j + 1 < leapYears.length) j++;
        }
    }

    public static long toJdn(int year, int month, int day) {
        if (year < startingYear || year > startingYear + yearsStartingJdn.length - 1)
            return -1;

        return yearsStartingJdn[year - startingYear] + daysInPreviousMonths(month) + day - 1;
    }

    // First six months have length of 31, next 5 months are 30 and the last month is 29 and in leap years are 30
    private static final int[] daysToMonth = {0, 31, 62, 93, 124, 155, 186, 216, 246, 276, 306, 336, 366};

    private static int monthFromOrdinalDay(int ordinalDay) {
        int index = ordinalDay / 31;
        while (ordinalDay > daysToMonth[index]) index++;
        return index;
    }

    private static int daysInPreviousMonths(int month) {
        return daysToMonth[month - 1];
    }

    public static int[] fromJdn(long jdn) {
        if (jdn < yearsStartingJdn[0] || jdn > yearsStartingJdn[yearsStartingJdn.length - 1])
            return null;

        int year = (int) (jdn - yearsStartingJdn[0]) / 366;
        for (; year < yearsStartingJdn.length - 1; ++year)
            if (jdn < yearsStartingJdn[year + 1])
                break;

        long startOfYearJdn = yearsStartingJdn[year];
        year += startingYear;

        int dayOfYear = (int) (jdn - startOfYearJdn) + 1;
        int month = monthFromOrdinalDay(dayOfYear);
        int day = dayOfYear - daysInPreviousMonths(month);

        return new int[]{year, month, day};
    }
}
