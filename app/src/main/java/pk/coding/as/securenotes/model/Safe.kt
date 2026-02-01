package pk.coding.`as`.securenotes.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "safe_table")
data class Safe(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val safeName: String,
    val password: String,
    val passwordEnable: Int
)