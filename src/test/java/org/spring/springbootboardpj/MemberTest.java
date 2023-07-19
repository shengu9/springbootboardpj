package org.spring.springbootboardpj;

import org.junit.jupiter.api.Test;
import org.spring.springbootboardpj.dto.MemberDto;
import org.spring.springbootboardpj.entity.MemberEntity;
import org.spring.springbootboardpj.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void memberInsert() {
        // 회원가입
        // form -> Controller

        MemberDto memberDto = new MemberDto();
        memberDto.setName("m2");
        memberDto.setEmail("m2@gmail.com");

        // Dto -> Entity

        MemberEntity memberEntity
                = MemberEntity.toMemberEntity(memberDto);

        memberRepository.save(memberEntity);


    }






}
