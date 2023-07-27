package com.example.graphqlmsn.di

import com.apollographql.apollo3.ApolloClient
import com.example.graphqlmsn.data.ApolloMsnClient
import com.example.graphqlmsn.domain.GetScheduleGameUseCase
import com.example.graphqlmsn.domain.MsnClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://api.develop.monumentalsportsnetwork.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient): MsnClient {
        return ApolloMsnClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetScheduleGamesUseCase(msnClient: MsnClient): GetScheduleGameUseCase {
        return GetScheduleGameUseCase(msnClient)
    }
}