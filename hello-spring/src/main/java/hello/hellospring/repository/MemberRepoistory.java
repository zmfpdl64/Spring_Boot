package hello.hellospring.repository;
import hello.hellospring.domain.*;
import java.util.Optional;
import java.util.List;

public interface MemberRepoistory {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
