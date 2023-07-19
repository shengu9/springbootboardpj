package org.spring.springbootboardpj;

import org.junit.jupiter.api.Test;
import org.spring.springbootboardpj.dto.BoardDto;
import org.spring.springbootboardpj.dto.MemberDto;
import org.spring.springbootboardpj.entity.BoardEntity;
import org.spring.springbootboardpj.entity.MemberEntity;
import org.spring.springbootboardpj.repository.BoardRepository;
import org.spring.springbootboardpj.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTest {

    @Autowired
    private BoardRepository boardRepository;
    
    @Test
    void boardInsert(){

    // 게시글 title, content, writer -> member_tb_3 테이블의 member_id 있는

        // Dto -> Entity

        BoardDto boardDto = new BoardDto();
        boardDto.setTitle("제목1");
        boardDto.setContent("내용1");
        boardDto.setWriter("닉네임1");

        MemberDto memberDto = new MemberDto();
        memberDto.setId(1L);
        MemberEntity memberEntity = MemberEntity.toMemberEntity2(memberDto);

        boardDto.setMemberEntity(memberEntity);
        
        // Dto -> Entity
        BoardEntity boardEntity = BoardEntity.toBoardEntity(boardDto);
        
        // 게시글 저장 실행
        boardRepository.save(boardEntity);
        
    }

}
