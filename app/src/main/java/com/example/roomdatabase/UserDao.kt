package com.example.roomdatabase

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: UserEntity)

    @Query("update User set name=:name,email=:email where id=:id")
    suspend fun updateUser(name: String, email: String, id: String)

    @Update
    suspend fun updateUserData(user: UserEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Query("delete from User where id=:id")
    suspend fun deleteUserData(id:String)

    @Query("SELECT * FROM User")
    fun getAllUsers(): LiveData<List<UserEntity>>
}