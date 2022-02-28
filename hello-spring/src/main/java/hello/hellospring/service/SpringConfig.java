package hello.hellospring.service;

import hello.hellospring.repository.MemberRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class SpringConfig {


    private final MemberRepoistory memberRepoistory;

    @Autowired //생성자가 하나일때는 생략 가능하다.
    public SpringConfig(MemberRepoistory memberRepoistory) {
        this.memberRepoistory = memberRepoistory;
    }

//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        this.dataSource = dataSource;
//        this.em = em;
//    }
//
//    private DataSource dataSource;
//    private EntityManager em;


    @Bean
    public MemberService memberService() throws SQLException {
//        return new MemberService(memberRepository());
        return new MemberService(memberRepoistory);
    }

//    @Bean
//    public MemberRepoistory memberRepository() throws SQLException {
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//    }
}
