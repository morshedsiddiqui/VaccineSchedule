/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.busschedule.database.schedule

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Provides access to read/write operations on the schedule table.
 * Used by the view models to format the query results for use in the UI.
 */
@Dao // This annotation is important
interface ScheduleDao {

//    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
//    fun getAll(): Flow<List<Schedule>>
//
//
//
//    @Query("SELECT * FROM schedule WHERE stop_name = :airlineName ORDER BY arrival_time ASC")
//    fun getByStopName(airlineName: String): Flow<List<Schedule>>  // Flow<Int>
    @Query("SELECT * FROM schedule ORDER BY pharmacy_name ASC")
    fun getAll(): Flow<List<Schedule>>

    @Query("SELECT * FROM schedule WHERE pharmacy_name = :pharmacyName ORDER BY time ASC")
    fun getByPharmacyName(pharmacyName: String): Flow<List<Schedule>>




/*

    @Insert
    fun insertSchedule():Flow<List<Schedule>>

    @Update
    fun updateSchedule():Flow<List<Schedule>>

    @Delete
    fun deleteSchedule():Flow<List<Schedule>>
  */

}
// Important topic for  Test02
// Built on the top of Kotlin co-routines

