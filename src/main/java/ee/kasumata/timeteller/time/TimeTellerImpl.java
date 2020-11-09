package ee.kasumata.timeteller.time;

import org.jetbrains.annotations.NotNull;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;

public class TimeTellerImpl implements TimeTeller {
    @NotNull
    private final DateTimeFormatter dateFormatter;

    @NotNull
    private final Clock clock;

    public TimeTellerImpl() {
        this(Clock.systemDefaultZone());
    }

    public TimeTellerImpl(@NotNull Clock clock) {
        dateFormatter = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .appendLiteral(' ')
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .toFormatter();
        this.clock = clock;
    }

    @Override
    public @NotNull String getFormattedTime() {
        LocalDateTime currentTime = LocalDateTime.now(clock).truncatedTo(ChronoUnit.SECONDS); // limit the precision to seconds, more detailed time is not very user-readable
        return currentTime.format(dateFormatter);
    }
}
