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

    var safeAddMsg: String = ""



    fun addSafe(safe: Safe) {
        viewModelScope.launch() {
            val count = safeRepository.getAllSafeCount(safe.safeName)
            if (count == 0) {
                safeRepository.addSafe(safe)
                safeAddMsg = "Safe added successfully"
            }
            else{
                safeAddMsg = "Safe already exists"
            }

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

    fun getAllSafe() = safeRepository.getAllSafe()

    fun getAllSafeCount(safeName: String) {
        viewModelScope.launch() {
            safeRepository.getAllSafeCount(safeName)
        }

    }

}