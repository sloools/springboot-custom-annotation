package song.test.validannotation.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import song.test.validannotation.entity.Person
import song.test.validannotation.entity.PersonSub
import song.test.validannotation.entity.PersonSubNullable
import song.test.validannotation.entity.Test
import javax.validation.Valid

@RestController
class TestController {

    @PostMapping("/api/valid")
    fun test(@Valid @RequestBody body: Person): String {
        return body.name
    }

    @PostMapping("/api/valid-subclass")
    fun subClassTest(@Valid @RequestBody body: PersonSub): String {
        return body.name.lastName + body.name.firstName
    }

    @PostMapping("/api/valid-test")
    fun test(@Valid @RequestBody body: Test): String {
        return body.name.lastName + body.name.firstName
    }

    @PostMapping("/api/nullable")
    fun nullableTest(@Valid @RequestBody body: PersonSubNullable): String {
        return body.name?.lastName + body.name?.firstName
    }
}