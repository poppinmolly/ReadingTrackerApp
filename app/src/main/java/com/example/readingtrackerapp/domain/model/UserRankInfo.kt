package com.example.readingtrackerapp.domain.model

import com.example.readingtrackerapp.domain.utills.UserRank

data class UserRankInfo(
    val rank: UserRank,
    val progress: String,

)
