package com.example.lab_1

import java.io.Serializable

data class Fox(
    val type: String,
    val binomialName: String,
    val description: String,
    val imageRes: Int
): Serializable