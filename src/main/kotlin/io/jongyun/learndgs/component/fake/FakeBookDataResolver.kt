package io.jongyun.learndgs.component.fake

import com.netflix.dgs.codegen.generated.types.Book
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.InputArgument
import io.jongyun.learndgs.datsource.fake.FakeBookDataSource
import org.springframework.util.StringUtils

@DgsComponent
class FakeBookDataResolver {

    @DgsData(parentType = "Query", field = "books")
    fun booksWrittendBy(@InputArgument(name = "author") author: String?): List<Book> {
        return if (!StringUtils.hasText(author)) {
            FakeBookDataSource.BOOK_LIST
        } else {
            FakeBookDataSource.BOOK_LIST.filter { book -> book.author.name == author }
        }
    }
}