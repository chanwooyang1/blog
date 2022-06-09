package com.sparta.blog.repository;

import com.sparta.blog.model.Comment;
import com.sparta.blog.model.Note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByNoteId(Long note_id);

}