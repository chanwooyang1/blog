package com.sparta.blog.controller;


import com.sparta.blog.model.Comment;
import com.sparta.blog.model.Note;
import com.sparta.blog.repository.CommentRepository;
import com.sparta.blog.dto.CommentRequestDto;
import com.sparta.blog.repository.NoteRepository;
import com.sparta.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class CommentController {

    public final NoteRepository noteRepository;

    public final CommentRepository commentRepository;
    public final CommentService commentService;



    @PostMapping("api/notes/{note_id}/comments")
    public Comment createComment(@RequestBody CommentRequestDto commentDto){
        Comment comment = new Comment(commentDto);
        return commentRepository.save(comment);

    }
    @GetMapping("api/notes/{note_id}/comments")
    public List<Comment> getComment(@PathVariable ("note_id")Long id){
        return commentRepository.findAllByNoteId(id);
    };


    @DeleteMapping("api/notes/{note_id}/comments/{comment_id}")
    public Long deleteComment(@PathVariable ("comment_id")Long id) {
        return commentService.delete(id);


    }
    @PutMapping("api/notes/{note_id}/comments/{comment_id}")
    public Comment updateComment(@PathVariable ("comment_id")Long id, @RequestBody CommentRequestDto commentDto){

        return commentService.update(id, commentDto);
    }








}
