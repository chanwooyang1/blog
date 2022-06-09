package com.sparta.blog.model;


import com.sparta.blog.option.Timestamped;
import com.sparta.blog.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String comment;



    @Column(nullable = false)
    private Long noteId;

    public Comment(String comment, Long noteId){
        this.comment = comment;
        this.noteId = noteId;
    }
    public Comment(CommentRequestDto commentDto){
        this.comment = commentDto.getComment();
        this.noteId = commentDto.getNoteId();
    }
    public void update(CommentRequestDto commentDto){

        this.comment = commentDto.getComment();
    }
    public void post(CommentRequestDto commentDto){
        this.comment = commentDto.getComment();
        this.noteId = commentDto.getNoteId();
    }
}
