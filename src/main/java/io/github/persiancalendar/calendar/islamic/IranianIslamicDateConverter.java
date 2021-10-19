package io.github.persiancalendar.calendar.islamic;

import java.util.HashMap;
import java.util.Map;

/**
 * Credits of this work goes to Saeed Rasooli and his
 * Kudos to his creative work!
 * I've tried to optimize its runtime performance, so it is different to the way used on starcal.
 */
public class IranianIslamicDateConverter {

    private final static int supportedYearsStart;
    private final static long[] yearsStartJd;
    private final static long jdSupportEnd;
    private final static long jdSupportStart = 2425063; // CivilDate(1927, 7, 1).toJdn()
    public static int latestSupportedYearOfIran = 1401;
    private static final Map<Integer, long[]> yearsMonthsInJd = new HashMap<>();

    static {
        // https://calendar.ut.ac.ir/Fa/News/Data/Doc/Calendar%201401-Full.pdf
        // https://calendar.ut.ac.ir/Fa/Software/CalConv.asp
        int[] hijriMonths = {
                1346, 29, 30, 30, 29, 30, 30, 30, 29, 29, 30, 29, 29,
                1347, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 30, 29,
                1348, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 30,
                1349, 29, 29, 30, 29, 30, 29, 30, 30, 29, 30, 30, 29,
                1350, 30, 29, 29, 30, 30, 29, 29, 30, 29, 30, 30, 29,
                1351, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 29,
                1352, 30, 30, 29, 30, 30, 30, 29, 29, 29, 30, 29, 30,
                1353, 29, 30, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29,
                1354, 29, 30, 30, 30, 29, 30, 30, 29, 29, 30, 29, 30,
                1355, 29, 29, 30, 30, 29, 30, 30, 29, 30, 29, 30, 29,
                1356, 30, 29, 29, 30, 30, 29, 30, 29, 30, 30, 29, 30,
                1357, 29, 30, 29, 30, 29, 30, 29, 29, 30, 30, 29, 30,
                1358, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30,
                1359, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29, 29, 30,
                1360, 30, 30, 29, 30, 30, 29, 30, 29, 29, 30, 29, 30,
                1361, 29, 30, 29, 30, 30, 29, 30, 30, 29, 29, 30, 29,
                1362, 30, 29, 30, 29, 30, 30, 29, 30, 29, 30, 29, 30,
                1363, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30, 29,
                1364, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 30, 30,
                1365, 29, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 30,
                1366, 29, 30, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30,
                1367, 30, 29, 30, 30, 29, 30, 29, 29, 30, 29, 30, 29,
                1368, 30, 29, 30, 30, 29, 30, 30, 29, 29, 30, 29, 30,
                1369, 29, 30, 29, 30, 29, 30, 30, 29, 30, 29, 30, 30,
                1370, 29, 29, 30, 29, 30, 29, 30, 29, 30, 30, 29, 30,
                1371, 29, 30, 29, 30, 29, 30, 29, 29, 30, 30, 30, 29,
                1372, 30, 30, 29, 29, 30, 29, 29, 30, 29, 30, 30, 30,
                1373, 29, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 30,
                1374, 29, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30,
                1375, 29, 30, 30, 29, 30, 30, 29, 30, 29, 29, 30, 29,
                1376, 30, 29, 30, 29, 30, 30, 29, 30, 30, 29, 29, 30,
                1377, 29, 30, 29, 29, 30, 30, 29, 30, 30, 30, 29, 30,
                1378, 29, 29, 30, 29, 29, 30, 29, 30, 30, 30, 29, 30,
                1379, 30, 29, 29, 30, 29, 29, 30, 29, 30, 30, 29, 30,
                1380, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30,
                1381, 30, 29, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29,
                1382, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 29, 30,
                1383, 29, 29, 30, 30, 29, 30, 30, 30, 29, 30, 29, 29,
                1384, 30, 29, 29, 30, 29, 30, 30, 30, 29, 30, 30, 29,
                1385, 29, 30, 29, 29, 30, 29, 30, 30, 29, 30, 30, 30,
                1386, 29, 29, 30, 29, 29, 30, 29, 30, 29, 30, 30, 30,
                1387, 29, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 30,
                1388, 29, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30,
                1389, 29, 30, 30, 29, 30, 30, 29, 30, 29, 29, 30, 29,
                1390, 30, 29, 30, 29, 30, 30, 30, 29, 30, 29, 30, 29,
                1391, 29, 30, 29, 29, 30, 30, 30, 29, 30, 30, 29, 30,
                1392, 29, 29, 30, 29, 29, 30, 30, 29, 30, 30, 29, 30,
                1393, 30, 29, 29, 30, 29, 29, 30, 30, 29, 30, 29, 30,
                1394, 30, 30, 29, 30, 29, 29, 30, 29, 29, 30, 29, 30,
                1395, 30, 30, 29, 30, 29, 30, 29, 30, 29, 29, 29, 30,
                1396, 30, 29, 30, 30, 30, 29, 30, 29, 30, 29, 29, 30,
                1397, 29, 30, 29, 30, 30, 30, 29, 30, 29, 30, 29, 29,
                1398, 30, 29, 30, 29, 30, 29, 30, 30, 29, 30, 29, 30,
                1399, 29, 30, 29, 30, 29, 29, 30, 30, 29, 30, 30, 29,
                1400, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 30, 30,
                1401, 29, 30, 30, 29, 29, 30, 29, 29, 30, 29, 30, 29,
                1402, 30, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30,
                1403, 29, 30, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29,
                1404, 30, 29, 30, 30, 30, 29, 30, 29, 30, 29, 29, 30,
                1405, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 30,
                1406, 29, 29, 30, 29, 30, 29, 30, 30, 29, 30, 29, 30,
                1407, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 30, 29,
                1408, 30, 30, 29, 30, 29, 29, 30, 29, 29, 30, 30, 29,
                1409, 30, 30, 30, 29, 29, 30, 29, 30, 29, 29, 30, 30,
                1410, 29, 30, 30, 29, 30, 29, 30, 29, 30, 29, 29, 30,
                1411, 30, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 29,
                1412, 30, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30, 29,
                1413, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 30, 30,
                1414, 29, 30, 29, 29, 30, 29, 30, 29, 29, 30, 30, 30,
                1415, 30, 30, 29, 29, 29, 30, 29, 29, 29, 30, 30, 30,
                1416, 30, 30, 29, 30, 29, 29, 30, 29, 29, 30, 30, 29,
                1417, 30, 30, 30, 29, 29, 30, 29, 30, 29, 30, 29, 29,
                1418, 30, 30, 29, 30, 30, 29, 30, 29, 29, 30, 30, 29,
                1419, 29, 30, 29, 30, 29, 30, 30, 29, 29, 30, 30, 30,
                1420, 29, 29, 30, 29, 30, 29, 30, 30, 29, 30, 30, 29,
                1421, 30, 29, 29, 30, 29, 29, 30, 30, 29, 30, 30, 30,
                1422, 29, 30, 29, 29, 30, 29, 29, 30, 29, 30, 30, 30,
                1423, 29, 30, 30, 29, 29, 30, 29, 30, 29, 30, 29, 30,
                1424, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29,
                1425, 30, 29, 30, 30, 29, 30, 30, 29, 29, 30, 29, 30,
                1426, 29, 29, 30, 29, 30, 30, 30, 29, 30, 30, 29, 29,
                1427, 30, 29, 29, 30, 29, 30, 30, 30, 29, 30, 29, 30,
                1428, 29, 30, 29, 29, 29, 30, 30, 29, 30, 30, 30, 29,
                1429, 30, 29, 30, 29, 29, 29, 30, 30, 29, 30, 30, 29,
                1430, 30, 30, 29, 29, 30, 29, 30, 29, 29, 30, 30, 29,
                1431, 30, 30, 29, 30, 29, 30, 29, 30, 29, 29, 30, 29,
                1432, 30, 30, 29, 30, 30, 30, 29, 30, 29, 29, 30, 29,
                1433, 29, 30, 29, 30, 30, 30, 29, 30, 29, 30, 29, 30,
                1434, 29, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29,
                1435, 29, 30, 29, 30, 29, 30, 29, 30, 30, 30, 29, 30,
                1436, 29, 30, 29, 29, 30, 29, 30, 29, 30, 29, 30, 30,
                1437, 29, 30, 30, 29, 30, 29, 29, 30, 29, 29, 30, 30,
                1438, 29, 30, 30, 30, 29, 30, 29, 29, 30, 29, 29, 30,
                1439, 29, 30, 30, 30, 30, 29, 30, 29, 29, 30, 29, 29,
                1440, 30, 29, 30, 30, 30, 29, 30, 30, 29, 29, 30, 29,
                1441, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 30,
                1442, 29, 29, 30, 29, 30, 29, 30, 30, 29, 30, 30, 29,
                1443, 29, 30, 30, 29, 29, 30, 29, 30, 29, 30, 30, 29,
                1444, 30, 30, 29, 30, 29, 29, 30,/**/30, 29, 30, 29, 30
        };

        int years = (int) Math.ceil(((float) hijriMonths.length) / 13);
        yearsStartJd = new long[years];
        supportedYearsStart = hijriMonths[0];
        long jd = jdSupportStart - 1;
        for (int y = 0; y < years; ++y) {
            int year = hijriMonths[y * 13];

            yearsStartJd[y] = jd;
            long[] months = new long[12];
            for (int m = 1; m < 13 && y * 13 + m < hijriMonths.length; ++m) {
                months[m - 1] = jd;
                jd += hijriMonths[y * 13 + m];
            }
            yearsMonthsInJd.put(year, months);
        }
        jdSupportEnd = jd;
    }

    public static long toJdn(int year, int month, int day) {
        if (yearsMonthsInJd == null || yearsMonthsInJd.get(year) == null)
            return -1;

        long calculatedDay = yearsMonthsInJd.get(year)[month - 1];

        if (calculatedDay == 0)
            return -1;

        return calculatedDay + day;
    }

    private static int searchYearsStarts(long r) {
        int i = (int) ((r - yearsStartJd[0]) / (30 * 12));
        while (i < yearsStartJd.length && yearsStartJd[i] < r) ++i;
        return i;
    }

    private static int searchInOneYear(long[] yearJdn, long r) {
        int i = (int) ((r - yearJdn[0]) / 30);
        while (i < yearJdn.length && yearJdn[i] < r) ++i;
        return i;
    }

    public static int[] fromJdn(long jd) {
        if (jd < jdSupportStart || jd >= jdSupportEnd || yearsStartJd == null) return null;

        int yearIndex = searchYearsStarts(jd);
        int year = yearIndex + supportedYearsStart - 1;
        long[] yearMonths = yearsMonthsInJd.get(year);
        if (yearMonths == null) return null;
        int month = searchInOneYear(yearMonths, jd);
        if (yearMonths[month - 1] == 0) return null;
        int day = (int) (jd - yearMonths[month - 1]);
        return new int[]{year, month, day};
    }
}
