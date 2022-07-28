package io.jongyun.learndgs.component.fake.fetcher

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.InputArgument
import io.jongyun.learndgs.DgsConstants.MUTATION.AddHello
import io.jongyun.learndgs.DgsConstants.MUTATION.DeleteHello
import io.jongyun.learndgs.DgsConstants.MUTATION.ReplaceHelloText
import io.jongyun.learndgs.datsource.fake.FakeHelloDataSource
import io.jongyun.learndgs.types.Hello
import io.jongyun.learndgs.types.HelloInput

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
        FakeHelloDataSource.HELLO_LIST.filter { it.randomNumber == helloInput.number }
//            .forEach { hello -> hello.text = helloInput.text }

        return FakeHelloDataSource.HELLO_LIST
    }

    @DgsMutation(field = DeleteHello)
    fun deleteHello(number: Int): Int {
        FakeHelloDataSource.HELLO_LIST.removeIf { it.randomNumber == number }
        return FakeHelloDataSource.HELLO_LIST.count()
    }

}