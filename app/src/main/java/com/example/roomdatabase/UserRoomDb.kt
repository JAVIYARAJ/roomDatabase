package com.example.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [UserEntity::class], version = 1)
abstract class UserRoomDb : RoomDatabase() {

    abstract fun userDao(): UserDao
}