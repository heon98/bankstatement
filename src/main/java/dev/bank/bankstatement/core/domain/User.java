package dev.bank.bankstatement.core.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    private String id;
//    @NotBlank
    private String password;

    // DTO(Data Transfer Object)를 이너 클래스(inner class) 형태로 작성
    public static class Request {
        @NotBlank
        private String id;
        @NotBlank
        @Length(min = 0, max = 12)
        // @Pattern(), 특정 정규표현식을 만족하게 하는 것
        private String password;

        public void setPassword(String password) {
            System.out.println("setID() called");
            this.password = password;
        }

        public void setId(String id) {
            System.out.println("setPassword() called");
            this.id = id;
        }
    }
}
