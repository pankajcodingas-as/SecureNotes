package pk.coding.`as`.securenotes.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import pk.coding.`as`.securenotes.model.Safe

@Dao
interface SafeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSafe(safe: Safe)

    @Update
    suspend fun updateSafe(safe: Safe)

    @Delete
    suspend fun deleteSafe(safe: Safe)

    @Query("SELECT * FROM safe_table ORDER BY safeName ASC")
    fun getAllSafe(): LiveData<List<Safe>>

    @Query("select count(safeName) from safe_table where safeName = :safeName")
    suspend fun getAllSafeCount(safeName: String): Int

}