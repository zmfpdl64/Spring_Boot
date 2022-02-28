package hello.hellospring.service;

import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepoistory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class SpringConfig {

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    private DataSource dataSource;
    private EntityManager em;

    @Bean
    public MemberService memberService() throws SQLException {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepoistory memberRepository() throws SQLException {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
