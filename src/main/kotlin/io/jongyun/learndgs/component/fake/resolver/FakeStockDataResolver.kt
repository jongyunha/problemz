package io.jongyun.learndgs.component.fake.resolver

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import io.jongyun.learndgs.DgsConstants
import io.jongyun.learndgs.datsource.fake.FakeStockDataSource
import io.jongyun.learndgs.types.Stock
import org.reactivestreams.Publisher
import reactor.core.publisher.Flux
import java.time.Duration

@DgsComponent
class FakeStockDataResolver(val dataSource: FakeStockDataSource) {

    //    @DgsSubscription
    @DgsData(parentType = DgsConstants.Subscription_TYPE, field = DgsConstants.SUBSCRIPTION.RandomStock)
    fun randomStock(): Publisher<Stock> {
        return Flux.interval(Duration.ofSeconds(3)).map { dataSource.randomStock() }

    }
}