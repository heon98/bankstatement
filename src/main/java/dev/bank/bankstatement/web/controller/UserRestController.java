package dev.bank.bankstatement.web.controller;


import dev.bank.bankstatement.core.application.UserEditor;
import dev.bank.bankstatement.core.application.UserFinder;
import dev.bank.bankstatement.core.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */

//@Controller
@RestController // @Controller + @ResponseBody를 한번에 하는 annotation
@RequestMapping(path = "/api/users")
public class UserRestController {

    private final Logger logger = LoggerFactory.getLogger(getClass()); // getClass()에서 UserRestController를 받아오는 것임. 로거 인스턴스를 받아오는것 // 콘솔 출력문을 형식과 맞게해주기 위함

    private final UserFinder finder;
    private final UserEditor editor;

    public UserRestController(UserFinder finder, UserEditor editor) {
        this.finder = finder;
        this.editor = editor;
    }

    //  다형성을 이용해서 UserFinder 생성자를 Controller에서 만들어주면서 UserManager객체를 new로 만들지 않고도 사용할 수 있게 됨.
//      public UserRestController(UserFinder finder) {
//        this.finder = finder;
//    } // 위에서 UserEditor 생성자랑 같이 만들었으니까 필요없어짐

    /**
     * 모든 User list를 반환한다.
     * @return List<User> users
     * @author heon
     */
//    @RequestMapping(path = "/api/users", method = RequestMethod.GET)
    @GetMapping
//    @ResponseBody // HttpServletRequest(Request 객체), HttpServletResponse(Response 객체)
    public List<User> findAll() {
        // intellij에서는 syso 단축키 대신 sout으로 씀
//        System.out.println("findAll() called");
        logger.info("-- GET: localhost:8080/api/users, findAll() called"); // 콘솔 출력문을 바꿔서 출력

        return finder.findAll();
    }

    @GetMapping("/{id}") // localhost:8080/api/users/guguttemi <- 이렇게 받을거임
    public User findUser(@PathVariable String id) { // @PathVariable 이렇게 해야 아이디 값을 받아올 수 있음. -> url 변수의 경우
        // @PathVariable에 대한 추가 정보 ref) https://leeborn.tistory.com/entry/Spring-PathVariable-%EA%B8%B0%EB%B3%B8%EA%B0%92-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0
        logger.info("-- GET: localhost:8080/api/users/{}, findUser() called", id); // 빈 중괄호에 id값이 들어간 상태로 출력되게 함.

        // log 레벨 조정 - trace, debug, info, warn, error 수준 => 필요한 로그만 출력해서 보자.
        // logging 하는 이유: 부가정보출력, 좋은 가독성, 콘솔 출력만이 아닌 네트워크, 파일등으로 남길 수 있음 등등,,,
        // ref) https://dev-monkey-dugi.tistory.com/149
        logger.debug("-- @PathVariable String id: {}", id); // debug level 에서 값이 잘 들어온건지 보고 싶을때 사용할 수 있는 방법.

        return finder.findUser(id);
    }

    @PostMapping // 요청 메소드가 다르기 때문에 findAll()과 구분이 되기 때문에 상관없음.
    public String createUser(@RequestBody @Validated User.Request newUser, BindingResult br) {
        // @RequestBody: 클라이언트에서 전송한 xml이나 json 등등 데이터를 컨트롤러에서  DOM객체나 자바 객체로 변환해서 송수신 해줌
        // 이때 변환시에(Convert할때) HttpMessageConverter를 사용
        // 이 어노테이션이 붙은 파라미터에는 http 요청의 본문(body)이 그대로 전달됨.
        // 일반적으로 GET/POST 방식에서는 사용할 일이 거의 없지만, 현재까지는 페이지에 view부분도 없고, 반응형도 아니어서,
        // test하기위해 사용함.
        logger.info("-- POST: localhost:8080/api/users, createUser() called");
        logger.info("-- @RequestBody User: {}", newUser);

        // ** BindinResult 파라미터는 @Validated annotation이 부여된 파라미터 바로 뒤에 작성해야됨.
        if (br.hasErrors()) {
            return "뭐하세요오?";
        }

//        return editor.create(newUser);
        return null;
    }

    @PutMapping
    public User UpdateUser(@RequestBody User updateUser) {
        logger.info("-- PUT: localhost:8080/api/users, UpdateUser() called");
        logger.info("-- @RequestBody User: {}", updateUser);

        return editor.update(updateUser);
    }

    @DeleteMapping
    public String deleteUser(@RequestParam("id") String id) {
        // @RequestParam("쿼리스트링에서 사용할 변수명") String id(Java에서 쿼리스트링을 통해 받았을 때 사용할 지역 변수 이름)
        // In Servlet, HttpServletRequest requst
        // request.getParameter("id"); 가 간소화된 형태
        logger.info("-- DELETE: localhost:8080/api/users, deleteUser() called");
        logger.info("-- @RequestParam id: {}", id);
        return editor.delete(id);
    }
}
