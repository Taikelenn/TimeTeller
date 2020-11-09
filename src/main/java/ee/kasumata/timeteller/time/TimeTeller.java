package ee.kasumata.timeteller.time;

import org.jetbrains.annotations.NotNull;

import java.time.format.DateTimeFormatter;

public interface TimeTeller {
    @NotNull
    String getFormattedTime();
}
