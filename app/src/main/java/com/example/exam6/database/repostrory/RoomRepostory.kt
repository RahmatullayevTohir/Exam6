package com.example.exam6.database.repostrory

import android.app.Application
import com.example.exam6.database.AppDatabase
import com.example.exam6.database.dao.RoomDao
import com.example.exam6.database.entity.CardName

class RoomRepository(application: Application) {
    private var roomDao: RoomDao

    init {
        val db: AppDatabase = AppDatabase.getInstance(application)
        roomDao = db.roomDao
    }

    fun saveExamModel(cardName: CardName) {
        roomDao.insertCardRoom(cardName)
    }

    fun getCardRoomList(): List<CardName> {
        return roomDao.getCardRoomList()
    }
}