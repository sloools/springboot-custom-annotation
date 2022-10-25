package song.test.validannotation.annotation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [ByteSizeValidator::class])
annotation class ByteSize(
    val min: Int = 0,
    val max: Int = 2024,
    val message: String = "ByteSize is not valid",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
