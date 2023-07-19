package org.spring.springbootboardpj.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.spring.springbootboardpj.dto.BoardDto;
import org.spring.springbootboardpj.dto.MemberDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "board_tb_03")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto_increament
    @Column(name = "board_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(name = "writer", nullable = false)
    private String writer;

    @CreationTimestamp
    @Column(updatable = false)     // 수정시 X
    private LocalDateTime createTime;

    @UpdateTimestamp  // 수정 시간 자동
    @Column(insertable = false) // 처음 생성 시간 X
    private LocalDateTime updateDateTime;


    // 다 : 1 , N:1
    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    // Dto -> Entity

    public static BoardEntity toBoardEntity(BoardDto boardDto){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setTitle(boardDto.getTitle());
        boardEntity.setContent(boardDto.getContent());
        boardEntity.setWriter(boardDto.getWriter());

        boardEntity.setMemberEntity(boardDto.getMemberEntity());

        return boardEntity;
    }



}
