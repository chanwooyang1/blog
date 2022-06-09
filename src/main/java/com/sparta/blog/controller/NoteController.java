package com.sparta.blog.controller;

import com.sparta.blog.model.Note;
import com.sparta.blog.repository.NoteRepository;
import com.sparta.blog.dto.NoteRequestDto;
import com.sparta.blog.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class NoteController {


    private final NoteService noteService;

    private final NoteRepository noteRepository;

    @PostMapping("/api/notes")
    public Note creatNote(@Valid @RequestBody NoteRequestDto noteDto) {
        Note note = new Note(noteDto);
        return noteRepository.save(note);
    }

    @GetMapping("/api/notes")
    public List<Note> getNotes() {
        return noteRepository.findAllByOrderByCreatedAtDesc();

    }
    @GetMapping("/api/notes/{note_id}")
    public Note oneNote(@PathVariable Long note_id){
        return noteRepository.findById(note_id).orElseThrow(
                () -> new IllegalArgumentException("글이 존재하지 않습니다")
        );
    }

    @DeleteMapping("/api/notes/{note_id}")
    public Long deleteNote(@PathVariable Long note_id) {
        noteRepository.deleteById(note_id);
        return note_id;

    }

    @PutMapping("/api/notes/{note_id}")
    public Note updateNote(@Valid @PathVariable Long note_id, @RequestBody NoteRequestDto noteDto){

        return noteService.update(note_id, noteDto);
    }




}
