package com.itw.notes.controller;

import com.itw.notes.model.Note;
import com.itw.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private NoteService noteService;

    @GetMapping (value = "/")
    public String getIndex(Model model){
        clearEdit();
        List<Note> noteList = noteService.findAll();
        model.addAttribute("notes", noteList);
        return "index";
    }

//    @GetMapping(value = "/note/new")
//    public String newNote (){
//        Note note = new Note("A New Note", "Replace This Text");
//        noteService.save(note);
//        String iD = note.getID().toString();
//        return "redirect:/";
//    }

    @GetMapping(value = "/note/new")
    public String getNoteForm(Model model){
        clearEdit();
        model.addAttribute("note", new Note());
        return "newNote";
    }

    @PostMapping(value = "/note/new")
    public String submitNoteForm(@Valid Note note, BindingResult bindingResult){
        if (!bindingResult.hasErrors()) {
            noteService.save(note);
            return "redirect:/";
        }
        return "newNote";
    }

    @GetMapping(value = "/note/{id}")
    public String editNote(@PathVariable Long id, Model model){
        clearEdit();
        List<Note> noteList = noteService.findAll();
        Note note = noteService.findById(id);
        note.setEdit(true);
        noteService.save(note);
        model.addAttribute("notes", noteList);
        model.addAttribute("noteEdit", note);
        return "index";
    }

    @PostMapping(value = "/note/{id}")
    public String submitEditNote(@Valid Note note, BindingResult bindingResult, Model model){
        if (!bindingResult.hasErrors()) {
            note.setEdit(false);
            noteService.save(note);
            return "redirect:/";
        }
        List<Note> noteList = noteService.findAll();
        model.addAttribute("notes", noteList);
        model.addAttribute("noteEdit", note);
        return "index";
    }

    @DeleteMapping(value = "/note/{id}")
    public String deleteNote(@PathVariable Long id) {
        clearEdit();
        noteService.deleteById(id);
        return "redirect:/";
    }

    private void clearEdit(){
        List<Note> notes = noteService.findAll();
        for (Note note : notes){
            note.setEdit(false);
            noteService.save(note);
        }
    }
}
