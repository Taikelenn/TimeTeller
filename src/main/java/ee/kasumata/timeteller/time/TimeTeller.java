package ee.kasumata.timeteller.time;

import org.jetbrains.annotations.NotNull;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;

/**
 * The default TimeTeller implementation formats the time using the following format: 'YYYY-MM-DD HH:MM:SS'
 */
public class TimeTeller {
    @NotNull
    private final DateTimeFormatter dateFormatter;

    @NotNull
    private final Clock clock;

    /**
     * The default constructor which uses the current system time.
     */
    public TimeTeller() {
        this(Clock.systemDefaultZone());
    }

    /**
     * A constructor which can take a custom clock as a time source. Used for testing.
     * @param clock The time source used to return a formatted time string.
     */
    public TimeTeller(@NotNull Clock clock) {
        dateFormatter = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .appendLiteral(' ')
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .toFormatter();
        this.clock = clock;
    }

    protected @NotNull DateTimeFormatter getTimeFormatter() {
        return dateFormatter;
    }

    public @NotNull String getFormattedTime() {
        LocalDateTime currentTime = LocalDateTime.now(clock).truncatedTo(ChronoUnit.SECONDS); // limit the precision to seconds, more detailed time is not very user-readable
        return currentTime.format(getTimeFormatter());
    }
}
