package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired  //생성자에 넣어주는 어노테이션
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
