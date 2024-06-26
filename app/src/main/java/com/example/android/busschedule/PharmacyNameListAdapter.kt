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

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.busschedule.database.schedule.Schedule
import com.example.android.busschedule.databinding.PharmacyNameItemBinding

class PharmacyNameAdapter(
    private val onItemClicked: (Schedule) -> Unit
) : ListAdapter<Schedule, PharmacyNameAdapter.PharmacyNameViewHolder>(DiffCallback) {





    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Schedule>() {
            override fun areItemsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
                return oldItem == newItem
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmacyNameViewHolder {
        val viewHolder = PharmacyNameViewHolder(
            PharmacyNameItemBinding.inflate(
                LayoutInflater.from( parent.context),
                parent,
                false
            )
        )
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemClicked(getItem(position))
        }
        return viewHolder
    }






    override fun onBindViewHolder(holder: PharmacyNameViewHolder, position: Int) {
        holder.bind(getItem(position))
    }





    class PharmacyNameViewHolder(
        private var binding: PharmacyNameItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SimpleDateFormat")
        fun bind(schedule: Schedule) {
            binding.airlineNameTextView.text = schedule.pharmacyName
            binding.terminalNumTextView.text = schedule.pharmacyLocation
            binding.statusTextView.text = schedule.time_
            binding.arrivalTimeTextView.text = schedule.date_

        }
    }
}
