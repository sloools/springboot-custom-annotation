package song.test.validannotation.entity

import javax.validation.Valid

data class Test(
    @field:Valid
    val name: Name,
    @field:Valid
    val age: Age
)
