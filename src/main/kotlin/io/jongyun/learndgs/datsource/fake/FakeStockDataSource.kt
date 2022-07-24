package io.jongyun.learndgs.datsource.fake

import com.github.javafaker.Faker
import com.netflix.dgs.codegen.generated.types.Stock
import org.springframework.context.annotation.Configuration
import java.time.OffsetDateTime

@Configuration
class FakeStockDataSource(
    val faker: Faker
) {

    fun randomStock(): Stock {
        return Stock(
            lastTradeDateTime = OffsetDateTime.now(),
            price = faker.random().nextInt(100, 1000),
            symbol = faker.stock().nyseSymbol()
        )
    }
}