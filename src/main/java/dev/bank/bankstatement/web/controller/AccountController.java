package dev.bank.bankstatement.web.controller;

import dev.bank.bankstatement.web.model.BankProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC 구조에서 사용하는 방식
 * 페이지에 반환할때 modelandview로 반환할 수도 있고, 문자열 형태로 반환하는 것이 가장 흔한 방식
 */
@Controller // @Component의 보다 직관적인 annotation 표기(동작은 동일)
public class AccountController {
    private BankProperties bankProperties;

//@RequestMapping(path = "/api/accounts", method = RequestMethod.GET) // localhost:8080/api/accounts로 요청했을 때 findAll()가 동작
//    public ModelAndView findAll() {
//
//        // model 작성
//        bankProperties = new BankProperties();
//
//        // view(클라이언트에게 보여질 html 페이지) 작성
//
//        // 반환을 위해 비어있는 ModelAndView 객체 생성
//        ModelAndView mav = new ModelAndView();
//
//        mav.addObject("bankProperties", bankProperties); // Servlet에서의 getParameter()와 비슷한 기능 - 데이터 추가
//
//        Model 과 ModelAndView 의 차이점
//        model - model.addAttribute()를 사용해서 데이터만 저장
//        ModelAndView - mav.addObject()를 사용해서 데이터와 이동하고자 하는 View Page를 같이 저장
//        ref) https://highseekmj.tistory.com/19
//
//        mav.setViewName("accounts"); // .html을 제외한 파일명 기술
//
//
//        return mav;
//    }
//
//    @RequestMapping(path = "/api/accounts", method = RequestMethod.GET)
//    public String findAll(Model model) {
//
//        // ModelAndView에서 Model 부분에 해당
//        model.addAttribute("bankProperties", new BankProperties());
//
//        return "accounts"; // 반환값으로 view의 이름(accounts.html)을 지정
//    }

}
