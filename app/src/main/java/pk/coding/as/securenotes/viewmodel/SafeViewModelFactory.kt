package pk.coding.`as`.securenotes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pk.coding.`as`.securenotes.repository.SafeRepository

class SafeViewModelFactory(private val safeRepository: SafeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SafeViewModel(safeRepository) as T


    }
}