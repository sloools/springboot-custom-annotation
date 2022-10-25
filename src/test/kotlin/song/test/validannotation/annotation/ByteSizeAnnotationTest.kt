package song.test.validannotation.annotation

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean

@SpringBootTest
@ActiveProfiles(value = ["test"])
internal class ByteSizeAnnotationTest {

    @Autowired
    private lateinit var validatorInjected: LocalValidatorFactoryBean

    private data class SampleClass(
        @ByteSize(max = 10)
        val firstSampleField: String,
        @ByteSize(max = 10, message = "secondSampleField is invalid")
        val secondSampleField: String
    )

    @Test
    fun should_be_error_with_default_message_when_byte_size_is_exceeded() {
        // given
        val sampleClass = SampleClass("myNameIsSong", "hi")

        // when
        val messages = sampleClassValidator(sampleClass)

        // then
        Assertions.assertThat(messages).contains("ByteSize is not valid")
    }

    @Test
    fun should_be_error_with_custom_message_when_byte_size_is_exceeded() {
        val sampleClass = SampleClass("song", "가나다라")

        val messages = sampleClassValidator(sampleClass)

        Assertions.assertThat(messages).contains("secondSampleField is invalid")
    }

    @Test
    fun should_be_success_when_byte_size_is_not_exceeded() {
        val sampleClass = SampleClass("song", "가나다")

        val messages = sampleClassValidator(sampleClass)

        Assertions.assertThat(messages).isNullOrEmpty()
    }

    private fun sampleClassValidator(sampleClass: SampleClass): List<String> {
        val validate = validatorInjected.validate(sampleClass)
        val iterator = validate.iterator()

        val messages = mutableListOf<String>()

        while (iterator.hasNext()) {
            val next = iterator.next().message
            messages.add(next)
        }

        return messages
    }
}