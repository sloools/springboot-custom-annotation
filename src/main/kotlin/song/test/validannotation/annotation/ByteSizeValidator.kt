package song.test.validannotation.annotation

import java.nio.charset.Charset
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ByteSizeValidator : ConstraintValidator<ByteSize, String> {
    private var min: Int? = 4
    private var max: Int? = 10

    override fun initialize(constraintAnnotation: ByteSize?) {
        super.initialize(constraintAnnotation)
        if (constraintAnnotation != null) {
            this.min = constraintAnnotation.min
            this.max = constraintAnnotation.max
        }
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) {
            return false
        }

        val valueSize = value?.toByteArray(Charset.defaultCharset())?.size

        return (valueSize in min!!..max!!)
    }
}
