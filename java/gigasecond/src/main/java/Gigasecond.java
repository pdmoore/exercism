import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

class Gigasecond {
//    private static final long GIGASECOND = (long) Math.pow(10, 9);
//
//    private LocalDateTime birthDateTime;
//
//    Gigasecond(LocalDate birthDate) {
//        this.birthDateTime = birthDate.atStartOfDay();
//    }
//
//    Gigasecond(LocalDateTime birthDateTime) {
//        this.birthDateTime = birthDateTime;
//    }
//
//    LocalDateTime getDate() {
//        return birthDateTime.plus(Duration.ofSeconds((int)1e9));
//    }

    static final long SECONDS = 1_000_000_000;

    private LocalDateTime localDateTime;

    Gigasecond(LocalDate birthDate) {
            this(birthDate.atStartOfDay());
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.localDateTime = addSeconds(birthDateTime, SECONDS);
    }

    LocalDateTime addSeconds(LocalDateTime birthDate, long seconds) {
        return birthDate.plus(seconds, ChronoUnit.SECONDS);
    }

    LocalDateTime getDate() {
        return this.localDateTime;
    }

}
