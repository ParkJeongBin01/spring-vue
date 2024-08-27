package org.scoula.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@Slf4j
public class CommonExceptionAdvice { //CommonExceptionAdvice 자체가 controller이다.
    //@ExceptionHandler(Exception.class) //catch할 예외
    //모든 예외는 Exception.class 이녀석이 다 처리 할 것이다.

//    public String except(Exception ex, Model model){
//
//        log.error("Exception............" + ex.getMessage());
//        model.addAttribute("exception", ex);
//        log.error(model);
//        return "error_page";
//    } //500에러가 나면 이 녀석이 다 처리함.

    //@ExceptionHandler(NoHandlerFoundException.class)
    //@ResponseStatus(HttpStatus.NOT_FOUND)
    //public String handle404(NoHandlerFoundException ex) {return "custom404"; }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404(NoHandlerFoundException ex) {
        return "/resources/index.html";
    }

}
