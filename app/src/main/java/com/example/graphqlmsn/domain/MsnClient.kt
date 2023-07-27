package com.example.graphqlmsn.domain

import com.example.graphqlmsn.Model.GameSchedule
import com.example.graphqlmsn.Model.MsnDataModel

interface MsnClient {
    suspend fun getGameScheduleData(
        site: String,
        limit: Int,
        offset: Int,
        startDate: Int
    ): GameSchedule?
}