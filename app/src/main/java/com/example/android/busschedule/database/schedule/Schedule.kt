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

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a single table in the database. Each row is a separate instance of the Schedule class.
 * Each property corresponds to a column. Additionally, an ID is needed as a unique identifier for
 * each row in the database.
 */
@Entity // This is called Annotations , we used to call them directives also
data class Schedule(



//    @PrimaryKey val id: Int,
//@NonNull @ColumnInfo(name = "airline_name") val airlineName: String,
//@NonNull @ColumnInfo(name = "terminal_num") val terminalNumber: String,
//@NonNull @ColumnInfo(name = "arrival_time") val arrivalTime: Int,
//@NonNull @ColumnInfo(name = "Status") val airlineStatus: String

    @PrimaryKey val id: Int,
@NonNull @ColumnInfo(name = "pharmacy_name") val pharmacyName: String,
@NonNull @ColumnInfo(name = "pharmacy_location") val pharmacyLocation: String,
@NonNull @ColumnInfo(name = "date") val date_: String,
@NonNull @ColumnInfo(name = "time") val time_: String


)


