package com.example.readingtrackerapp.domain.usecase

import com.example.readingtrackerapp.domain.model.UserRankInfo
import com.example.readingtrackerapp.domain.utills.getBookProgress
import com.example.readingtrackerapp.domain.utills.getUserRank
import javax.inject.Inject

class GetCurrentRankProgressUseCase @Inject constructor(){

    operator fun invoke(booksRead: Int): UserRankInfo{
        val rank = getUserRank(booksReadTotal = booksRead)
        val progress = getBookProgress(booksReadTotal = booksRead)
        return UserRankInfo(rank,progress)
    }
}