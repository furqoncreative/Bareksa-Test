package com.bareksa.test.data.model.fund

data class Fund(
    val funId: Int,
    val fundName: String,
    val fundIcon: Int,
    val fundType: String,
    val fundYield: String,
    val managedFund: String,
    val minimumPurchase: String,
    val timePeriod: String,
    val riskLevel: String,
    val launchDate: String
)
