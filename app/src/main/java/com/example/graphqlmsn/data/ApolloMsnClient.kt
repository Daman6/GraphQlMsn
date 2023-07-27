package com.example.graphqlmsn.data

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.exception.ApolloException
import com.example.graphqlmsn.Model.GameSchedule
import com.example.graphqlmsn.domain.MsnClient
import com.plcoding.GameScheduleQuery

class ApolloMsnClientException(message: String, cause: Throwable? = null) : Exception(message, cause)
class ApolloMsnClient(
    private val apolloClient: ApolloClient
): MsnClient {
    override suspend fun getGameScheduleData(
        site: String,
        limit: Int,
        offset: Int,
        startDate: Int
    ): GameSchedule? {
        val response = apolloClient.query(
            GameScheduleQuery(
                site, limit, offset, startDate, Optional.absent(),
                sortBy = Optional.absent(),
                Optional.absent()
            )
        ).execute()

        if (response.hasErrors()) {
            val errorMessages = response.errors?.map { it.message }?.get(0)
            throw ApolloException(errorMessages)
        }
        return response.data?.gameSchedule?.toSimpleGameSchedule()

    }
}