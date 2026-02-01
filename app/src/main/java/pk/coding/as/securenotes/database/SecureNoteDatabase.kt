package pk.coding.`as`.securenotes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pk.coding.`as`.securenotes.dao.NoteDao
import pk.coding.`as`.securenotes.dao.SafeDao
import pk.coding.`as`.securenotes.model.Note
import pk.coding.`as`.securenotes.model.Safe





@Database(entities = [Note::class, Safe::class], version = 1)
abstract class SecureNoteDatabase: RoomDatabase() {

    abstract fun safeDao(): SafeDao
    abstract fun noteDao(): NoteDao

    companion object{
        @Volatile
        private var INSTANCE: SecureNoteDatabase? = null

        fun getDatabase(context: Context): SecureNoteDatabase{
            synchronized(this){

                if(INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        SecureNoteDatabase::class.java,
                        "secure_note_database"
                    ).build()
                }

            }
            return INSTANCE!!
        }

    }


}