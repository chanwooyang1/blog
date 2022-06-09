package com.sparta.blog.dto;

import com.sparta.blog.repository.NoteRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@NoArgsConstructor

public class CommentRequestDto {



    @NotEmpty(message = "댓글을 입력하세요")
    private String comment;

    @NotEmpty
    private Long NoteId;
}
