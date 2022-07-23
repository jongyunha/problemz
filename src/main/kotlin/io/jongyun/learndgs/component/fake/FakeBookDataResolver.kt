package io.jongyun.learndgs.component.fake

import com.netflix.dgs.codegen.generated.DgsConstants
import com.netflix.dgs.codegen.generated.DgsConstants.QUERY.BOOKSBYRELEASED_INPUT_ARGUMENT
import com.netflix.dgs.codegen.generated.types.Book
import com.netflix.dgs.codegen.generated.types.ReleaseHistory
import com.netflix.dgs.codegen.generated.types.ReleaseHistoryInput
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment
import com.netflix.graphql.dgs.InputArgument
import io.jongyun.learndgs.datsource.fake.FakeBookDataSource
import org.springframework.util.StringUtils

@DgsComponent
class FakeBookDataResolver {

    @DgsData(parentType = "Query", field = "books")
    fun booksWrittenBy(@InputArgument(name = "author") author: String?): List<Book> {
        return if (!StringUtils.hasText(author)) {
            FakeBookDataSource.BOOK_LIST
        } else {
            FakeBookDataSource.BOOK_LIST.filter { book -> book.author.name == author }
        }
    }

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.BooksByReleased)
    fun getBooksByReleased(dataFetchingEnvironment: DgsDataFetchingEnvironment): List<Book> {
        val releasedMap =
            dataFetchingEnvironment.getArgument<Map<String, Any>>(BOOKSBYRELEASED_INPUT_ARGUMENT.toString())

        val releaseHistoryInput = ReleaseHistoryInput(
            printedEdition = releasedMap["printedEdition"] as Boolean,
            year = releasedMap["year"] as Int
        )

        return FakeBookDataSource.BOOK_LIST.filter { book: Book ->
            matchReleaseHistory(
                releaseHistoryInput,
                book.released
            )
        }
    }

    fun matchReleaseHistory(input: ReleaseHistoryInput, element: ReleaseHistory?) =
        input.printedEdition == element?.printedEdition && input.year == element?.year
}