package org.spring.springbootboardpj.controller;

import lombok.RequiredArgsConstructor;
import org.spring.springbootboardpj.dto.BoardDto;
import org.spring.springbootboardpj.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping({"","index"})
    public String index(){
        return "board/index";
    }

    @GetMapping("/join")
    public String join(){
        return "board/join";
    }

//    @PostMapping("/join")
//    public String joinOk(BoardDto boardDto){
//        int rs = boardService.boardInsert(boardDto);
//
//        if(rs!=1){
//            System.out.println("글 작성 실패(컨트롤)");
//            return "redirect:/member/join";
//
//        }else {
//            System.out.println("극 작성 성공(컨트롤)");
//            return "redirect:/board/join";
//        }
//    }

}
