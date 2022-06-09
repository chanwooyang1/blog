package com.sparta.blog.service;

import com.sparta.blog.model.Comment;
import com.sparta.blog.repository.CommentRepository;
import com.sparta.blog.dto.CommentRequestDto;
import com.sparta.blog.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;


    @Transactional
    public Comment update(Long comment_id, CommentRequestDto commentDto) {
        Comment comment = commentRepository.findById(comment_id).orElseThrow(
                () -> new IllegalArgumentException("댓글이 없습니다")
        );
        comment.update(commentDto);
        return comment;
    }

    public Long delete(Long id){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글이 없습니다")
        );
        commentRepository.deleteById(id);
        return id;
    }





}
