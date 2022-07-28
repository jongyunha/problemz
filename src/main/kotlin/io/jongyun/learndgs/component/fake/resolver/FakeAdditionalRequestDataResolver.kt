package io.jongyun.learndgs.component.fake.resolver

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import io.jongyun.learndgs.DgsConstants
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@DgsComponent
class FakeAdditionalRequestDataResolver {

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.AdditionalRequest)
    fun additionalOnRequest(
        @RequestHeader(required = false) optionalHeader: String,
        @RequestHeader(required = true) mandatoryHeader: String,
        @RequestParam(required = false) optionalParam: String,
        @RequestParam(required = true) mandatoryParam: String
    ): String {
        return with(StringBuilder()) {
            append("Optional header ${optionalHeader}, ")
            append("Mandatory header ${mandatoryHeader}, ")
            append("Optional param ${optionalParam}, ")
            append("Mandatory param ${mandatoryParam}")
            toString()
        }
    }

}