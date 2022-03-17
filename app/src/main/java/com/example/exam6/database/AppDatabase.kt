package com.example.exam6.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.exam6.database.dao.RoomDao
import com.example.exam6.database.entity.CardName

@Database(entities = [CardName::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract val roomDao: RoomDao
    companion object{
        private var instance : AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context):AppDatabase{
            if (instance == null){
                instance = Room.databaseBuilder(context,AppDatabase::class.java, "post_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}