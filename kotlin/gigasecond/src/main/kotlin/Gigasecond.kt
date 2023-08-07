import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(aCertainDateTime: LocalDateTime?) {

    val ONE_GIGASECOND = 1_000_000_000L

    constructor(aCertainDate: LocalDate?) : this(aCertainDate?.atStartOfDay())

    val date: LocalDateTime? = aCertainDateTime?.plusSeconds(ONE_GIGASECOND)
}
