package pk.coding.`as`.securenotes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pk.coding.`as`.securenotes.model.Note
import pk.coding.`as`.securenotes.repository.NoteRepository

class NoteViewModel(private val noteRepository: NoteRepository): ViewModel() {

        fun addNote(note: Note) {

            viewModelScope.launch() {
                noteRepository.addNote(note)
            }
        }

        fun updateNote(note: Note) {
            viewModelScope.launch() {
                noteRepository.updateNote(note)
            }
        }

        fun deleteNote(note: Note) {
            viewModelScope.launch() {
                noteRepository.deleteNote(note)
            }
        }

        fun getAllNoteFromSafe(safeName: String) = noteRepository.getAllNoteFromSafe(safeName)

        fun getAllNote() = noteRepository.getAllNote()

}