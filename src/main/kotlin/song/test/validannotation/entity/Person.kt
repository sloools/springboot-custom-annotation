package song.test.validannotation.entity

import song.test.validannotation.annotation.ByteSize
import javax.validation.constraints.Digits
import javax.validation.constraints.NotNull

data class Person(
    @field:ByteSize(max = 10, message = "invalid name size!!!!!")
    val name: String,
    @field:NotNull(message = "Not blank")
    val age: Int
)
