package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.function.IntPredicate;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
