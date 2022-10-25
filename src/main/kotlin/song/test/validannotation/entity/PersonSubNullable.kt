package song.test.validannotation.entity

import javax.validation.Valid

data class PersonSubNullable(
    @field:Valid
    val name: Name?,
    @field:Valid
    val age: Age?
)
