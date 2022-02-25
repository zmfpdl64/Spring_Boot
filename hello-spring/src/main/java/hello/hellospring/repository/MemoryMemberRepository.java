package hello.hellospring.repository;

import java.util.*;
import java.util.Optional;

import hello.hellospring.domain.Member;


public class MemoryMemberRepository implements MemberRepoistory{

    private static Map<Long, Member> store = new HashMap<> ();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setid(++sequence);
        store.put(member.getid(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        
        return store.values().stream().filter(member -> member.getname().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
    
}
