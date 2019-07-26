package com.itw.notes.service;

import com.itw.notes.model.Note;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteServiceTest {

    @Autowired
    NoteService noteService;

    Long mockID;

    @Before
    public void before(){
        noteService.save(new Note("A Note", "This is Text"));
        mockID = noteService.findAll().get(0).getID();
    }

    @After
    public void after(){
        List<Note> noteList = noteService.findAll();
        for (Note note: noteList) noteService.deleteById(note.getID());
    }

    @Test
    public void save() {
        noteService.save(new Note("A Second Note", "This Is More Text"));
        assertEquals(2, noteService.findAll().size());
    }

    @Test
    public void findAll() {
        assertEquals(1, noteService.findAll().size());
    }

    @Test
    public void findById() {
        assertEquals("A Note", noteService.findById(mockID).getTitle());
    }

    @Test
    public void deleteById() {
        noteService.deleteById(mockID);
        assertEquals(0, noteService.findAll().size());
    }
}