package pankaj.coding.`as`.com.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import pankaj.coding.`as`.com.Model.NotesEntity

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NotesEntity)

    @Update
    suspend fun updateNote(note: NotesEntity)

    @Delete
    suspend fun deleteNote(note: NotesEntity)

    @Query("Select * from notes_table order by dateLastUpdated DESC")
    fun getAllNotes(): LiveData<List<NotesEntity>>
}