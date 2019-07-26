package com.itw.notes.controller;

import com.itw.notes.model.Note;
import com.itw.notes.service.NoteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    @Autowired
    private MockMvc pract;

    @Autowired
    NoteService noteService;

    @Before
    public void before(){
        pract = MockMvcBuilders.webAppContextSetup(ctx).build();
        noteService.save(new Note("A Note", "This is Text"));
    }

    @Test
    public void getIndex() throws Exception {
        pract.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void getNoteForm() throws Exception {
        pract.perform(get("/note/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("newNote"));
    }

    @Test
    public void submitNoteForm() throws Exception {
        MockHttpServletRequestBuilder createNote = post("/note/new")
                .param("title", "A Second Note")
                .param("body", "This Is More Text");

        pract.perform(createNote)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void editNote() throws Exception{
        pract.perform(get("/note/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void submitEditNote() throws Exception {
        MockHttpServletRequestBuilder editNote = post("/note/{id}", 1)
                .param("title", "A Different Note")
                .param("body", "This Is NewText");

        pract.perform(editNote)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));;
    }

    @Test
    public void deleteNote() throws Exception {
        pract.perform(delete("/note/{id}", 1))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }
}