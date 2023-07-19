package org.spring.springbootboardpj.controller;

import lombok.RequiredArgsConstructor;
import org.spring.springbootboardpj.dto.MemberDto;
import org.spring.springbootboardpj.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Member;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping({"", "/index"})
    public String index() {
        return "member/index";
    }

    @GetMapping("/join")
    public String join(){
        return "member/join";
    }

    @PostMapping("/join")
    public String joinOk(MemberDto memberDto){
        int rs = memberService.memberInsert(memberDto);

        if(rs!=1){
            System.out.println("회원 가입 실패(컨트롤)");
            return "redirect:/member/join";

        }else {
            System.out.println("회원 성공 성공(컨트롤)");
            return "redirect:/board/join";
        }

    }


}
