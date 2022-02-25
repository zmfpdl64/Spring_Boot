package hello.hellospring.domain;

import java.util.function.IntPredicate;

public class Member {
    
    private Long id;
    private String name;

    public Long getid() {
        return this.id;
    }
    public void setid(Long id) {
        this.id = id;
    }
    public String getname() {
        return this.name;
    }
    public void setname(String name) {
        this.name = name;
    }
    public IntPredicate isEqualTo(Member result) {
        return null;
    }
}
