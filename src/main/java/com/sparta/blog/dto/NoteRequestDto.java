package com.sparta.blog.dto;



import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



import javax.validation.constraints.NotEmpty;


@Setter
@Getter
@RequiredArgsConstructor
public class NoteRequestDto {

    @NotEmpty(message = "제목을 입력하세요")
    private  String title;
    @NotEmpty(message = "이름을 입력하세요")
    private  String name;
    @NotEmpty(message = "내용을 입력하세요")
    private  String contents;



    public NoteRequestDto(String title, String name, String contents){
        this.name = name;
        this.title = title;
        this.contents = contents;
    }
}
