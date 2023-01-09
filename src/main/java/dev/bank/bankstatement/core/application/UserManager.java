package dev.bank.bankstatement.core.application;

import dev.bank.bankstatement.core.domain.User;
import dev.bank.bankstatement.core.infrastructure.UserRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * UserFinder 인터페이스 구현체(구현 클래스)
 *
 * 전통적인 인터페이스, 구현클래스 네이밍 방식
 * 인터페이스명: UserService.java
 * 구현클래스명: UserService'Impl'.java or 'I'UserService.java
 *
 * java.util에서 제공하는 List interface
 * 인터페이스명: List
 * 구현클래스명: ArrayList<>(), LinkedList<>() (구체적)
 */
@Service
public class UserManager implements UserFinder, UserEditor {
    private UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        // Dummy Data 테스트, DB 사용 전 -> 일단 메소드 내부에서 객체 생성 후 List<User>로 변환해서 반환
//        User user1 = new User("gugutemi", "1234");
//        User user2 = new User("susutemi", "5678");
//        List<User> users = new ArrayList<>(Arrays.asList(user1, user2));
//
//        // user가 한 명도 없을 경우, null 대신 비어있는 리스트 반환
//        if (users.isEmpty()) return Collections.emptyList(); // immutable 불변리스트로 반환해줌.

        return userRepository.findAll();
    }

    @Override
    public User findUser(String id) {
//        if (id == null) {
//            throw NoSuchElementException(message);
//        }
//        User u = new User(id, "1234");

        String message = String.format("%s에 해당하는 User가 없습니다.", id);
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException(message));
        return user;
    }


    @Override
    public String create(User newUser) {
        if(userRepository.findById(newUser.getId()).isPresent()) {
            String message = String.format("이미 존재하는 user id 입니다. %s", newUser.getId());
            throw new IllegalArgumentException(message);
        }
        userRepository.save(newUser);
        return newUser.getId();
    }

    @Override
    public User update(User updateUser) {

        User user = findUser(updateUser.getId());
        user.setPassword(updateUser.getPassword());
        userRepository.save(user);
        return user;
//        return userRepository.save(findUser(updateUser.getId()).setPassword(updateUser.getPassword()));
        // .setPassword()의 반환 타입이 void 이기 때문에 save()메소드 안에 들어갈 수 없음.
    }

    @Override
    public String delete(String id) {
        userRepository.deleteById(id);
        return id;
    }
}
