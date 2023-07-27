package com.example.graphqlmsn.data

import com.example.graphqlmsn.Model.GameSchedule
import com.example.graphqlmsn.Model.Item
import com.plcoding.GameScheduleQuery
import com.plcoding.selections.GameScheduleQuerySelections

fun GameScheduleQuery.GameSchedule.toSimpleGameSchedule(): GameSchedule{
    return GameSchedule(
        limit = limit!!,
        offset = offset!!,
        items = listOf()
    )
}