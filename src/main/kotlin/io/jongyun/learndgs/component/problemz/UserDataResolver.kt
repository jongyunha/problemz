package io.jongyun.learndgs.component.problemz

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.InputArgument
import io.jongyun.learndgs.DgsConstants
import io.jongyun.learndgs.types.*
import org.springframework.web.bind.annotation.RequestHeader

@DgsComponent
class UserDataResolver {

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.Me)
    fun accountInfo(@RequestHeader(name = "authToken", required = true) authToken: String): User? {
        return null
    }

    @DgsData(parentType = DgsConstants.MUTATION.TYPE_NAME, field = DgsConstants.MUTATION.UserCreate)
    fun createUser(@InputArgument(name = "user") userCreateInput: UserCreateInput): UserResponse? {
        return null
    }

    @DgsData(parentType = DgsConstants.MUTATION.TYPE_NAME, field = DgsConstants.MUTATION.UserLogin)
    fun login(@InputArgument(name = "user") userLoginInput: UserLoginInput): UserResponse? {
        return null
    }

    @DgsData(parentType = DgsConstants.MUTATION.TYPE_NAME, field = DgsConstants.MUTATION.UserActivation)
    fun userActivationResponse(@InputArgument(name = "user") userActivationInput: UserActivationInput): UserActivationResponse? {
        return null
    }

}