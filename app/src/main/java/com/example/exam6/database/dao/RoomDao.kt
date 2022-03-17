package com.example.exam6.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.exam6.database.entity.CardName

@Dao
interface RoomDao {

    @Insert
    fun insertCardRoom(cardRoom: CardName)

    @Query("SELECT * FROM cards")
    fun getCardRoomList(): List<CardName>
}