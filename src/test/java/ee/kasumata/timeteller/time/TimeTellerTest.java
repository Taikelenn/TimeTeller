package ee.kasumata.timeteller.time;

import junit.framework.TestCase;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

public class TimeTellerTest extends TestCase {
    private static final long TestClockMilliseconds = 1928427818; // test using this Unix timestamp
    private static final String TestClockResult = "2031-02-09 18:23:38"; // expected result

    private static final Clock ConstClockEpoch = Clock.fixed(Instant.EPOCH, ZoneOffset.UTC); // for testing with the Unix epoch
    private static final Clock ConstClockArbitrary = Clock.fixed(Instant.ofEpochSecond(TestClockMilliseconds), ZoneOffset.UTC); // for testing with the arbitrary date above

    /**
     * Tests that the TimeTeller.getFormattedTime() works correctly. Uses the default TimeTeller implementation.
     */
    public void testGetFormattedTime() {
        assertEquals("1970-01-01 00:00:00", new TimeTeller(ConstClockEpoch).getFormattedTime());
        assertEquals(TestClockResult, new TimeTeller(ConstClockArbitrary).getFormattedTime());
    }
}