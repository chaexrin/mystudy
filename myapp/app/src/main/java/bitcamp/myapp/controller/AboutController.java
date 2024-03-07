package bitcamp.myapp.controller;

import org.springframework.stereotype.Component;

@Component
public class AboutController {

    @RequestMapping("/about")
    public String home()
        throws Exception {
        return "/about.jsp";
    }
}
