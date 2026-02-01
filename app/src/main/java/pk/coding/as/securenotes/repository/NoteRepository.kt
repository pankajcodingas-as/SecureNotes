package pk.coding.`as`.securenotes.repository

import pk.coding.`as`.securenotes.dao.NoteDao
import pk.coding.`as`.securenotes.model.Note

class NoteRepository(private val noteDao: NoteDao) {

    suspend fun addNote(note: Note) {
        noteDao.addNote(note)
    }

    suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    fun getAllNoteFromSafe(safeName: String) = noteDao.getAllNoteFromSafe(safeName)

    fun getAllNote() = noteDao.getAllNote()

}