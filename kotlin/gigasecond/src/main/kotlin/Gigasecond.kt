import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(aCertainDate: LocalDateTime?) {

    val ONE_GIGASECOND = 1_000_000_000L

    // TODO: Implement proper constructor
    constructor(aCertainDate: LocalDate?) : this(aCertainDate?.atStartOfDay())

    val date: LocalDateTime? = aCertainDate?.plusSeconds(ONE_GIGASECOND)
}
