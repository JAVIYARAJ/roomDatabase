package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database =UserRoomDb.getInstance(this);

        GlobalScope.launch {

            database.userDao().insertUser(
                UserEntity(
                    3,
                    "alpesh",
                    "alpesh@gmail.com",
                    arrayListOf("pateel samaja", "near telecome tower", "talada"),0
                )
            )

            //database.userDao().updateUser("RAJ JAVIYA", "javiyaraj4@gmail.com", "1")
            //database.userDao().updateUserData(UserEntity(1,"meet-javiya","meet@gmail.com"))

            //database.userDao().deleteUser(UserEntity(2,"raj-javiya","raj@gmail.com"))
            //database.userDao().deleteUserData("2")
        }

//        database.userDao().getAllUsers().observe(this) {
//            Log.d("Practice", it.toString())
//        }
    }
}