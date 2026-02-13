package com.example.readingtrackerapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.readingtrackerapp.data.local.entity.DailySession
import kotlinx.coroutines.flow.Flow
@Dao
interface StatsDao {
    @Insert
    suspend fun insertDailyStats(session: DailySession)

    @Query("SELECT SUM(readPages) FROM sessions_db")
    fun getTotalPagesRead(): Flow<Int?>
}