package pk.coding.`as`.securenotes.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val safeName: String,
    val topic: String,
    val value: String,
    val lastDateUpdated: String
)