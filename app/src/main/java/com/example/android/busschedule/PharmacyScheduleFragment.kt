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
package com.example.android.busschedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.example.android.busschedule.databinding.StopScheduleFragmentBinding
import com.example.android.busschedule.databinding.PharmacyScheduleFragmentBinding

import com.example.android.busschedule.viewmodels.PharmacyScheduleViewModel
import com.example.android.busschedule.viewmodels.PharmacyScheduleViewModelFactory
import kotlinx.coroutines.launch

class PharmacyScheduleFragment: Fragment() {

    companion object {
        var AIRLINE_NAME = "airlineName"
    }
    private var _binding: PharmacyScheduleFragmentBinding? = null
//    private var _binding: AirlineScheduleFragmentBinding? = null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    private lateinit var airlineName: String

    private val viewModel: PharmacyScheduleViewModel by activityViewModels {
        PharmacyScheduleViewModelFactory(
            (activity?.application as PharmacyScheduleApplication).database.scheduleDao()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            airlineName = it.getString(AIRLINE_NAME).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PharmacyScheduleFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val airlineNameAdapter = PharmacyNameAdapter({})
        // by passing in the airline name, filtered results are returned,
        // and tapping rows won't trigger navigation
        recyclerView.adapter = airlineNameAdapter
        lifecycle.coroutineScope.launch {
            viewModel.scheduleForAirlineName(airlineName).collect() {
                airlineNameAdapter.submitList(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
