package bitcamp.myapp.controller;

import bitcamp.util.Component;

@Component
public class AboutController {

    @RequestMapping("/about")
    public String home()
        throws Exception {
        return "/about.jsp";
    }
}
