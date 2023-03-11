package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.plcoding.cleanarchitecturenoteapp.ui.theme.*

@Entity
data class Notes(
    val title: String,
    val description: String,
    val color: Int,
    val time: Long,
    @PrimaryKey val id: Int? = null
) {
    companion object {
       val noteColors = listOf(RedOrange, RedPink, LightGreen, LightBlue, Violet)
    }
}
