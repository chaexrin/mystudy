package bitcamp.myapp.controller;

import org.springframework.stereotype.Component;

@Component
public class AboutController {

    public AboutController() {
        System.out.println("AboutController() 호출됨!");
    }

    @RequestMapping("/about")
    public String home() throws Exception {
        return "/about.jsp";
    }
}
