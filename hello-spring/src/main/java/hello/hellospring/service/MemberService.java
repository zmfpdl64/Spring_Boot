package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepoistory;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {    //회원관리, 추가, 전체회원, 특정회원
    private final MemberRepoistory memberRepository;
//    @Autowired
    public MemberService(MemberRepoistory memberRepository) {

        this.memberRepository = memberRepository;
    }
    /*
     *회원가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원x
//        Optional<Member> result = memberRepository.findByName(member.getname());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
//                Member member1 = result.get(); 직접 바로 꺼내는 방식 권장하지 않는다.
//        Member member1 = result.orElseGet(); 바로 꺼내는 작업을 한다면 이 메서드를 사용한다.
        validateDuplicateMember(member);    //중복 회원 검증
        memberRepository.save(member);
        return member.getid();
    }


    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getname()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
            // Optional이라는 메서드가 있으면 내용이 복잡해 보이기 때문에 단축시킬 수 있다.
        });
    }
    //전체 회원 출력
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    //특정 회원 출력
    public Optional<Member> findOne(Long memberid) {
        return memberRepository.findById(memberid);
    }

}
