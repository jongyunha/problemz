package io.jongyun.learndgs.component.fake.resolver

import com.netflix.dgs.codegen.generated.DgsConstants
import com.netflix.dgs.codegen.generated.types.SmartSearchResult
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.InputArgument
import io.jongyun.learndgs.datsource.fake.FakeBookDataSource
import io.jongyun.learndgs.datsource.fake.FakeHelloDataSource

@DgsComponent
class FakeSmartSearchDataResolver {

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.SmartSearch)
    fun getSmartSearch(@InputArgument(name = "keyword") keyword: String?): List<SmartSearchResult> {
        val smarSearchList = ArrayList<SmartSearchResult>();
        when (keyword) {
            null -> {
                smarSearchList.addAll(FakeBookDataSource.BOOK_LIST)
                smarSearchList.addAll(FakeHelloDataSource.HELLO_LIST)
            }
            else -> {
                FakeHelloDataSource.HELLO_LIST.filter { it.text.equals(keyword) }.forEach(smarSearchList::add)
                FakeBookDataSource.BOOK_LIST.filter { it.title.equals(keyword) }.forEach(smarSearchList::add)
            }
        }
        return smarSearchList
    }
}