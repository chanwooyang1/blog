package com.sparta.blog.model;

import com.sparta.blog.option.Timestamped;
import com.sparta.blog.dto.NoteRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Note extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contents;



    public Note(NoteRequestDto noteDto) {
        this.name = noteDto.getName();
        this.contents = noteDto.getContents();
        this.title = noteDto.getTitle();
    }

    public void update(NoteRequestDto noteDto) {
        this.name = noteDto.getName();
        this.title = noteDto.getTitle();
        this.contents = noteDto.getContents();

    }
}