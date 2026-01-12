package pankaj.coding.`as`.com.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "notes_table")
@Parcelize
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val fileName: String,
    val key: String,
    val value: String,
    val dateLastUpdated: String
): Parcelable