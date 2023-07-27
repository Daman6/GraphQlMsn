package com.example.graphqlmsn.domain

import com.apollographql.apollo3.exception.ApolloException
import com.example.graphqlmsn.Model.GameSchedule
import com.example.graphqlmsn.common.Resource
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow

class GetScheduleGameUseCase(
    private val msnClient: MsnClient
) {
    suspend fun execute(
        site: String,
        limit: Int,
        offset: Int,
        startDate: Int
    ): Resource<GameSchedule?> {
        return try {
            Resource.Loading(null)
            val gameSchedule =msnClient.getGameScheduleData(site, limit, offset, startDate)
            Resource.Success(gameSchedule)
        }catch (e:ApolloException){
            Resource.Error("GraphQL Error: ${e.message}")
        }catch (e: Exception) {
        Resource.Error("Unexpected error occurred: ${e.message}")
    }
//        return msnClient.getGameScheduleData(site, limit, offset, startDate)
    }
}