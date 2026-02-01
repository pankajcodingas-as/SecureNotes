package pk.coding.`as`.securenotes.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pk.coding.`as`.securenotes.model.Safe
import pk.coding.`as`.securenotes.repository.SafeRepository


class SafeViewModel(
    private val safeRepository: SafeRepository
): ViewModel() {



    fun addSafe(safe: Safe) {
        viewModelScope.launch() {
            safeRepository.addSafe(safe)
        }
    }

    fun updateSafe(safe: Safe) {
        viewModelScope.launch() {
            safeRepository.updateSafe(safe)
        }
    }


    fun deleteSafe(safe: Safe) {
        viewModelScope.launch() {
            safeRepository.deleteSafe(safe)
        }
    }

    fun readAllSafe() = safeRepository.readAllSafe()

    fun getAllSafeCount(safeName: String) {
        viewModelScope.launch() {
            safeRepository.getAllSafeCount(safeName)
        }

    }

}