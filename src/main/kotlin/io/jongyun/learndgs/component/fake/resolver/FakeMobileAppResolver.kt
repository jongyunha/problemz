package io.jongyun.learndgs.component.fake.resolver

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.InputArgument
import io.jongyun.learndgs.DgsConstants
import io.jongyun.learndgs.datsource.fake.FakeMobileAppDataSource
import io.jongyun.learndgs.types.MobileApp
import io.jongyun.learndgs.types.MobileAppFilter
import org.apache.commons.lang3.StringUtils

@DgsComponent
class FakeMobileAppResolver {

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.MobileApps)
    fun getMobileApps(
        @InputArgument(name = "mobileAppFilter", collectionType = MobileAppFilter::class)
        filter: MobileAppFilter?
    ): List<MobileApp> {
        return if (filter == null) {
            FakeMobileAppDataSource.MOBILE_APP_LIST
        } else {
            FakeMobileAppDataSource.MOBILE_APP_LIST
//            FakeMobileAppDataSource.MOBILE_APP_LIST.filter { matchFilter(filter, it) }
        }
    }
}

fun matchFilter(mobileAppFilter: MobileAppFilter, mobileApp: MobileApp): Boolean {
    val isAppMath = StringUtils.containsIgnoreCase(
        mobileApp.name, StringUtils.defaultIfBlank(mobileAppFilter.name, StringUtils.EMPTY)
    )
    return if (!isAppMath) {
        false
    } else if (StringUtils.isNoneBlank(mobileAppFilter.platform)) {
        return true
    } else {
        true
    }
}