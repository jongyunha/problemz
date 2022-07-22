package io.jongyun.learndgs.component.fake

import com.netflix.dgs.codegen.generated.types.Hello
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import io.jongyun.learndgs.datsource.fake.FakeHelloDataSource
import java.util.concurrent.ThreadLocalRandom

@DgsComponent
class FakeHelloDataResolver {

    // method 이름은 query 에 정의한것과 동일해야 합니다.
    @DgsQuery
    fun allHellos(): List<Hello> {
        return FakeHelloDataSource.HELLO_LIST;
    }

    @DgsQuery
    fun oneHello(): Hello {
        return FakeHelloDataSource.HELLO_LIST[ThreadLocalRandom.current()
            .nextInt(FakeHelloDataSource.HELLO_LIST.count())]
    }
}