package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello";
    } 
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-mvc";
    }
    
    @GetMapping("hello-string")
    @ResponseBody   //body부에 리졸버를 사용하지 않고 바로 데이터를 바디에 전달해준다.
    public String hellostring(@RequestParam("name") String name) {
        return "hello " + name;
    }


    //api방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(name, 25);
        return hello;   //Hello 객체를 반환해서 {key : value}를 반환한다.
    }

     class Hello{   //GETTER SETTER를  CTRL + ENTER  이것을 프로퍼티 접근방식이라 한다.
        private String name;
        private int age;

        public Hello(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getage() {
            return this.age;
        }
        public void setage(int age) {
            this.age = age;
        }
    }
    // http://localhost:8080/hello-mvc?name=woojin 이런식으로 인자를 넘길 수 있다.
}
