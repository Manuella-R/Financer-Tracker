package com.example.financetracker

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense_table")
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Long = 0, // Primary key with auto-generate
    val title: String,
    val amount: Double,
    val date: String
)
