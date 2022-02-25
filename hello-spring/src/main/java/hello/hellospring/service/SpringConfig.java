package hello.hellospring.service;

import hello.hellospring.repository.MemberRepoistory;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepoistory memberRepository() {
        return new MemoryMemberRepository();
    }
}
