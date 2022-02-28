package hello.hellospring.repository.SpringData;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepoistory;
import org.springframework.data.jpa.repository.JpaRepository;
//JpaRepository 라이브러리를 이용하여 인터페이스만 구현한 파일에 구현체를 만들어낸다.
import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<Member, Long>, MemberRepoistory{
//스프링 데이터 jpa가 jpa레포지토리를 받고있으면 자동으로 빈을 등록해준다.

    @Override
    Optional<Member> findByName(String name);
}
