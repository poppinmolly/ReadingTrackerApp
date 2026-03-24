package com.example.readingtrackerapp.domain.utills

sealed class UserRank(val title: String, val range: IntRange){
    object Beginner: UserRank("Beginner", 0..2)
    object Reader: UserRank("Reader", 3..9)
    object Bookworm: UserRank("Bookworm", 10..24)
    object Legend: UserRank("Legend", 25..49)
    object Pappy: UserRank("Pappy", 50..Int.MAX_VALUE)
}

fun getUserRank(booksReadTotal: Int): UserRank = when (booksReadTotal){
    in UserRank.Beginner.range -> UserRank.Beginner
    in UserRank.Reader.range -> UserRank.Reader
    in UserRank.Bookworm.range -> UserRank.Bookworm
    in UserRank.Legend.range -> UserRank.Legend
    in UserRank.Pappy.range -> UserRank.Pappy

    else -> {
        UserRank.Pappy
    }
}

fun getBookProgress(booksReadTotal: Int): String{
    val rank = getUserRank(booksReadTotal)
    if (rank is UserRank.Pappy) return "Max rank archived"
    val current = booksReadTotal - rank.range.first
    val total = rank.range.last - rank.range.first + 1
    return "$current of $total books completed"
}