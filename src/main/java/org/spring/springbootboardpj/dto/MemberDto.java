package org.spring.springbootboardpj.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.spring.springbootboardpj.entity.BoardEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private Long id;
    private String name;
    private String email;
    private LocalDateTime createTime;
    private LocalDateTime updateDateTime;
    private List<BoardEntity> boardEntityList=new ArrayList<>();

}
