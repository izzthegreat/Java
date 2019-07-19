package com.itw.notes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Note {
    public Note(String title, String body){
        this.title = title;
        this.body = body;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "column_id")
    private Long iD;

    @NotEmpty(message = "Body cannot be empty")
    @Length(max = 250, message = "Note cannot have more than 250 characters")
    private String body;

    @NotEmpty(message = "Title cannot be empty")
    @Length(max = 50, message = "Title cannot have more than 50 characters")
    private String title;

    boolean edit = false;
}
