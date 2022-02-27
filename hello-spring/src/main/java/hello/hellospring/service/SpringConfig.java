package hello.hellospring.service;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepoistory;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class SpringConfig {

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private DataSource dataSource;

    @Bean
    public MemberService memberService() throws SQLException {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepoistory memberRepository() throws SQLException {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
