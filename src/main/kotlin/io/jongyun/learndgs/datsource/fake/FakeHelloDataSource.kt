package io.jongyun.learndgs.datsource.fake

import com.github.javafaker.Faker
import com.netflix.dgs.codegen.generated.types.Hello
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

@Configuration
class FakeHelloDataSource(
    private val faker: Faker
) {
    companion object {
        val HELLO_LIST = ArrayList<Hello>()
    }

    @PostConstruct
    fun postConstruct() {
        (1..20).forEach { _ ->
            val hello = Hello(text = faker.company().name(), randomNumber = faker.random().nextInt(5000))
            HELLO_LIST.add(hello)
        }
    }
}