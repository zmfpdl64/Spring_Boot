package hello.hellospring.controller;

public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;   //사용자가 name:"name"으로 form을 전달하면 스프링이 name값과 spring내의 name값을 매칭하여
        //MemberForm.setName(name) 함수를 통해 값이 밴엔드에 전달된다.
    }
}
