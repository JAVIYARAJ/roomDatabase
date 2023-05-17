package com.example.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@TypeConverters(TypeConvertors::class)
@Database(entities = [UserEntity::class], version = 2)
abstract class UserRoomDb : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile //here volatile annotation broadcast latest object instance value to all working thread
        var INSTANCE: UserRoomDb? = null

        var migration_1_to_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("alter table User add column isActive integer not null default(0)")
            }
        }

        fun getInstance(context: Context): UserRoomDb {

            if (INSTANCE == null) {

                //synchronized look is use because multiple thread try to create instance of database object.
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, UserRoomDb::class.java, "user-db")
                            .addMigrations(
                                migration_1_to_2
                            ).build()
                }
            }
            return INSTANCE!!
        }

    }
}