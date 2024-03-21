package bitcamp.app2;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalControllerAdvice {


    // DispatcherServlet은
    // request handler가 던지는 예외에 따라
    // 그 예외를 받을 수 있는 메서드를 찾아 호출한다.
    // 단, @ExceptionHandler 가 선언된 메서드여야 한다.
    //
    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception ex) {
        System.out.println("GlobalControllerAdvice 호출됨!");
        ModelAndView mv = new ModelAndView();
        mv.addObject("error", ex);
        mv.setViewName("error3");
        return mv;
    }
}
