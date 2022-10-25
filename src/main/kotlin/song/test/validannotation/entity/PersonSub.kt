package song.test.validannotation.entity

import javax.validation.Valid

data class PersonSub(
    @field:Valid
    val name: Name,
    @field:Valid
    val age: Age
)
