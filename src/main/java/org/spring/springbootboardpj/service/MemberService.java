package org.spring.springbootboardpj.service;

import lombok.RequiredArgsConstructor;
import org.spring.springbootboardpj.dto.MemberDto;
import org.spring.springbootboardpj.entity.MemberEntity;
import org.spring.springbootboardpj.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    public int memberInsert(MemberDto memberDto) {
        int rs=0;

        MemberEntity memberEntity
                = MemberEntity.toMemberEntity(memberDto);
        // 회원 가입
        Long member_id = memberRepository.save(memberEntity).getId();
        // 회원가입 후 정상적으로 가입 되어 있으면 id가 존재
        Optional<MemberEntity> optionalMemberEntity
                = memberRepository.findById(member_id);
        if(optionalMemberEntity.isPresent()){
            System.out.println("회원가입 성공");
            return 1;
        } else {
            System.out.println("회원가입 실패");
            return 0;
        }

    }
}
