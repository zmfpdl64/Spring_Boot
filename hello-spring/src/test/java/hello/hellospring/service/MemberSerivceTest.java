package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepoistory;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();    //그냥 비즈니스 로직 없는 회원창고
        memberService = new MemberService(memberRepository);    //비즈니스 로직을 추가한 회원 창고
    }                                                       //둘 다 같은 회원 창고를 사용하고 있다.

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setname("hello");
        //when
        Long savedId = memberService.join(member);

        //then
        Member findmember = memberService.findOne(savedId).get();
        assertThat(member.getname()).isEqualTo(findmember.getname());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setname("spring");

        Member member2 = new Member();
        member2.setname("spring");

        //when

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//      try, catch문을 사용하기 번거로우니 assertThrows메서드를 사용할 수 있다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        memberSerivce.join(member1);
//        try {
//            memberSerivce.join(member2);
//        } catch(IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        //then
    }

    @Test
    void 회원수일치() {
        Member member1 = new Member();
        member1.setname("woojin");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setname("hello");
        memberService.join(member2);

        List<Member> a = memberService.findMembers();
        for(Member b : a) {
            System.out.println(b.getname());
        }
        assertThat(a.size()).isEqualTo(2);

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}