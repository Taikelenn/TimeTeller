package ee.kasumata.timeteller.time;

import org.jetbrains.annotations.NotNull;

public interface TimeTeller {
    @NotNull
    String getFormattedTime();
}
