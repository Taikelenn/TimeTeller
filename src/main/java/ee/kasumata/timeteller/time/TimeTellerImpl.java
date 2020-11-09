package ee.kasumata.timeteller.time;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;

public class TimeTellerImpl implements TimeTeller {
    private final DateTimeFormatter dateFormatter;

    public TimeTellerImpl() {
        dateFormatter = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .appendLiteral(' ')
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .toFormatter();
    }

    @Override
    public @NotNull String getFormattedTime() {
        LocalDateTime currentTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS); // limit the precision to seconds, more detailed time is not very user-readable
        return currentTime.format(dateFormatter);
    }
}
