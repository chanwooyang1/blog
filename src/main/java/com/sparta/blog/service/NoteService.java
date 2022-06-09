package com.sparta.blog.service;


import com.sparta.blog.model.Note;
import com.sparta.blog.repository.NoteRepository;
import com.sparta.blog.dto.NoteRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Transactional
    public Note update(Long note_id, NoteRequestDto noteDto){
        Note note = noteRepository.findById(note_id).orElseThrow(
                () -> new IllegalArgumentException("글이 존재하지 않습니다")
        );
        note.update(noteDto);
        return note;
    }


}
