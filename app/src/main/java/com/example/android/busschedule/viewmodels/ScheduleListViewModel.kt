package com.example.android.busschedule.viewmodels
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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.busschedule.database.schedule.Schedule
import com.example.android.busschedule.database.schedule.ScheduleDao
import kotlinx.coroutines.flow.Flow

class PharmacyScheduleViewModel(private val scheduleDao: ScheduleDao): ViewModel() {

    fun fullSchedule(): Flow<List<Schedule>> = scheduleDao.getAll()

    fun scheduleForAirlineName(name: String): Flow<List<Schedule>> = scheduleDao.getByPharmacyName(name)
}

class PharmacyScheduleViewModelFactory(
    private val scheduleDao: ScheduleDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PharmacyScheduleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PharmacyScheduleViewModel(scheduleDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
