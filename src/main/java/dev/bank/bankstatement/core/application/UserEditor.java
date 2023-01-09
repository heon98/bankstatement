package dev.bank.bankstatement.core.application;

import dev.bank.bankstatement.core.domain.User;

/**
 * User 정보 편집기(update, delete 등)
 */
public interface UserEditor {
    /**
     * 새로운 User 등록
     * 등록 완료 시 user의 id 반환
     * @param newUser - 새로 등록할 User Entity
     * @return id - 가입된 user id
     */
    String create(User newUser);

    /**
     * User 정보 변경
     * @param updateUser - 새롭게 업데이트할 user 정보를 담고 있는 엔티티 객체
     * @return user - 수정된 user entity 객체
     */
    User update(User updateUser);

    /**
     * User 정보 제거
     * @param id - 제거할 User에 해당하는 id
     * @return id - 제거된 User id
     */
    String delete(String id);
}
