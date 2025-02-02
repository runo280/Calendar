package io.github.persiancalendar.calendar;

import io.github.persiancalendar.calendar.islamic.FallbackIslamicConverter;
import io.github.persiancalendar.calendar.islamic.IranianIslamicDateConverter;
import io.github.persiancalendar.calendar.islamic.UmmAlQuraConverter;

/**
 * @author Amir
 */

public class IslamicDate extends AbstractDate implements YearMonthDate<IslamicDate> {

    // Converters
    public static boolean useUmmAlQura = false;
    public static int islamicOffset = 0;

    public IslamicDate(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }

    public IslamicDate(long jdn) {
        super(jdn);
    }

    public IslamicDate(AbstractDate date) {
        super(date);
    }

    @Override
    public long toJdn() {
        int year = getYear(), month = getMonth(), day = getDayOfMonth();

        long tableResult = useUmmAlQura
                ? UmmAlQuraConverter.toJdn(year, month, day)
                : IranianIslamicDateConverter.toJdn(year, month, day);

        if (tableResult != -1)
            return tableResult - islamicOffset;

        return FallbackIslamicConverter.toJdn(year, month, day) - islamicOffset;
    }

    @Override
    protected int[] fromJdn(long jdn) {
        jdn += islamicOffset;
        int[] result = useUmmAlQura
                ? UmmAlQuraConverter.fromJdn(jdn)
                : IranianIslamicDateConverter.fromJdn(jdn);

        if (result == null) result = FallbackIslamicConverter.fromJdn(jdn);

        return result;
    }

    @Override
    public IslamicDate monthStartOfMonthsDistance(int monthsDistance) {
        return TwelveMonthsYear.monthStartOfMonthsDistance(this, monthsDistance, IslamicDate::new);
    }

    @Override
    public int monthsDistanceTo(IslamicDate date) {
        return TwelveMonthsYear.monthsDistanceTo(this, date);
    }
}
