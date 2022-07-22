package io.jongyun.learndgs.datsource.fake

import com.github.javafaker.Faker
import com.netflix.dgs.codegen.generated.types.Address
import com.netflix.dgs.codegen.generated.types.Author
import com.netflix.dgs.codegen.generated.types.Book
import com.netflix.dgs.codegen.generated.types.ReleaseHistory
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ThreadLocalRandom
import javax.annotation.PostConstruct

@Configuration
class FakeBookDataSource(
    private val faker: Faker
) {

    companion object {
        val BOOK_LIST = ArrayList<Book>()
    }

    @PostConstruct
    fun postConstruct() {
        (1..20).forEach { _ ->
            val addresses = ArrayList<Address>()
            val author = Author(
                addresses = addresses,
                name = faker.book().author(),
                originCountry = faker.country().name()
            )
            val released = ReleaseHistory(
                printedEdition = faker.bool().bool(),
                releasedCountry = faker.country().name(),
                year = faker.number().numberBetween(2019, 2021)
            )
            val book = Book(
                author = author,
                publisher = faker.book().publisher(),
                title = faker.book().title(),
                released = released
            )

            (0 until ThreadLocalRandom.current().nextInt(1, 3)).forEach { _ ->
                val address = Address(
                    country = faker.address().country(),
                    city = faker.address().cityName(),
                    street = faker.address().streetAddress(),
                    zipCode = faker.address().zipCode()
                )
                addresses.add(address)
            }

            BOOK_LIST.add(book)
        }
    }
}