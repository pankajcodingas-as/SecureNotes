package pk.coding.`as`.securenotes.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import pk.coding.`as`.securenotes.model.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note_table where safeName = :safeName ORDER BY lastDateUpdated DESC")
    fun getAllNoteFromSafe(safeName: String): LiveData<List<Note>>

    @Query("SELECT * FROM note_table ORDER BY lastDateUpdated DESC")
    fun getAllNote(): LiveData<List<Note>>


}