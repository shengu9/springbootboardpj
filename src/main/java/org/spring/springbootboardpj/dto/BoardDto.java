package org.spring.springbootboardpj.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.spring.springbootboardpj.entity.MemberEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private Long id;

    private String title;

    private String content;

    private String writer;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


    private MemberEntity memberEntity;
}
