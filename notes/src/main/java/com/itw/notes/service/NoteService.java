package com.itw.notes.service;

import com.itw.notes.model.Note;
import com.itw.notes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    NoteRepository noteRepository;

    public NoteService (NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    public void save(Note note){
        noteRepository.save(note);
    }

    public List<Note> findAll(){
        List<Note> notes = noteRepository.findAll();
        return notes;
    }

    public Note findById(Long id){
        Note note = noteRepository.findByID(id);
        return note;
    }

    public void deleteById(Long id){
        noteRepository.deleteById(id);
    }
}
