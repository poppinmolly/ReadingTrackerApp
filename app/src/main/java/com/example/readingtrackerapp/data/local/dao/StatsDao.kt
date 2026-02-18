package com.example.readingtrackerapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.readingtrackerapp.data.local.entity.DailySession
import com.example.readingtrackerapp.domain.model.TotalStatsModel
import kotlinx.coroutines.flow.Flow
@Dao
interface StatsDao {
    @Insert
    suspend fun insertDailyStats(session: DailySession)

    @Query("SELECT * FROM sessions_db")
    suspend fun getAllTimeStats(): List<DailySession>

    @Query("""
        SELECT * FROM sessions_db WHERE date >= :sevenDaysAgo
    """)
    suspend fun getLastWeekStats(sevenDaysAgo: Long): List<DailySession>
}