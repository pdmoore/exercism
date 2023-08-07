import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(aCertainDate: LocalDate?) {

    val ONE_GIGASECOND = 1_000_000_000L

    // TODO: Implement proper constructor
    constructor(aCertainDate: LocalDateTime?) : this(aCertainDate?.toLocalDate())

    val date: LocalDateTime? = aCertainDate?.atStartOfDay()?.plusSeconds(ONE_GIGASECOND)
}
