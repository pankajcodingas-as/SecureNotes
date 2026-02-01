package pk.coding.`as`.securenotes.repository

import pk.coding.`as`.securenotes.dao.SafeDao
import pk.coding.`as`.securenotes.model.Safe

class SafeRepository(private val safeDao: SafeDao){

    suspend fun addSafe(safe: Safe) {
        safeDao.addSafe(safe)
    }

    suspend fun updateSafe(safe: Safe) {
        safeDao.updateSafe(safe)
    }

    suspend fun deleteSafe(safe: Safe) {
        safeDao.deleteSafe(safe)
    }

    fun readAllSafe() = safeDao.readAllSafe()

    suspend fun getAllSafeCount(safeName: String) = safeDao.getAllSafeCount(safeName)


}