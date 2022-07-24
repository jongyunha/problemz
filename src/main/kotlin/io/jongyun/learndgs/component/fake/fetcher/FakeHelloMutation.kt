package io.jongyun.learndgs.component.fake.fetcher

import com.netflix.dgs.codegen.generated.DgsConstants.MUTATION.AddHello
import com.netflix.dgs.codegen.generated.DgsConstants.MUTATION.DeleteHello
import com.netflix.dgs.codegen.generated.DgsConstants.MUTATION.ReplaceHelloText
import com.netflix.dgs.codegen.generated.types.Hello
import com.netflix.dgs.codegen.generated.types.HelloInput
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.InputArgument
import io.jongyun.learndgs.datsource.fake.FakeHelloDataSource

@DgsComponent
class FakeHelloMutation {

    @DgsMutation(field = AddHello)
    fun addHello(@InputArgument(name = "helloInput") helloInput: HelloInput): Int {
        val hello = Hello(text = helloInput.text, randomNumber = helloInput.number)
        FakeHelloDataSource.HELLO_LIST.add(hello)
        return FakeHelloDataSource.HELLO_LIST.count()
    }

    @DgsMutation(field = ReplaceHelloText)
    fun replaceHelloText(@InputArgument(name = "helloInput") helloInput: HelloInput): List<Hello> {
//        FakeHelloDataSource.HELLO_LIST.filter { it.randomNumber == helloInput.number }
//            .forEach { hello -> hello.text = helloInput.text }

        return FakeHelloDataSource.HELLO_LIST
    }

    @DgsMutation(field = DeleteHello)
    fun deleteHello(number: Int): Int {
        FakeHelloDataSource.HELLO_LIST.removeIf { it.randomNumber == number }
        return FakeHelloDataSource.HELLO_LIST.count()
    }

}