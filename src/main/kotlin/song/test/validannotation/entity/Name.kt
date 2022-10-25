package song.test.validannotation.entity

import javax.validation.constraints.NotNull

data class Name(
    @field:NotNull(message = "Null is not accepted")
    val firstName: String,
    @field:NotNull
    val lastName: String
)
