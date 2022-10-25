package song.test.validannotation.entity

import javax.validation.constraints.NotBlank

data class Age(
    @field:NotBlank(message = "Null is not accepted")
    val koreanAge: String,
    @field:NotBlank(message = "Null is not accepted")
    val standardAge: String?
)
