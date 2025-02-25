package com.lalan.android_learning.recyclerview_with_room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.lalan.android_learning.recyclerview_with_room.models.Message

@Dao
interface MessageDao {

    // @Insert to insert the entity into table.
    @Insert
    fun insert(message: Message): Long

    // @Query to fire a custom query.
    @Query("SELECT * FROM messages")
    fun getAll(): List<Message>

    // @Update to update an already existing entity by matching the primary key (ID).
    @Update
    fun update(message: Message)

    // @Delete to delete an entity from table by matching the primary key (ID).
    @Delete
    fun delete(message: Message)

}