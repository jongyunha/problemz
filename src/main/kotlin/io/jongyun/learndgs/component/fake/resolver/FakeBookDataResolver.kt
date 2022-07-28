package io.jongyun.learndgs.component.fake.resolver


import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.InputArgument
import io.jongyun.learndgs.datsource.fake.FakeBookDataSource
import io.jongyun.learndgs.types.Book
import io.jongyun.learndgs.types.ReleaseHistory
import io.jongyun.learndgs.types.ReleaseHistoryInput
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

//    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.BooksByReleased)
//    fun getBooksByReleased(dataFetchingEnvironment: DgsDataFetchingEnvironment): List<Book> {
//        val releasedMap =
//            dataFetchingEnvironment.getArgument<Map<String, Any>>(BOOKS_BY_RELEASED___INPUT___ARGUMENT.toString())
//
//        val releaseHistoryInput = ReleaseHistoryInput(
//            printedEdition = releasedMap["printedEdition"] as Boolean,
//            year = releasedMap["year"] as Int
//        )
//
//        return FakeBookDataSource.BOOK_LIST.filter { book: Book ->
//            matchReleaseHistory(
//                releaseHistoryInput,
//                book.released
//            )
//        }
//    }

    fun matchReleaseHistory(input: ReleaseHistoryInput, element: ReleaseHistory?) =
        input.printedEdition == element?.printedEdition && input.year == element?.year
}