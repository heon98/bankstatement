package dev.bank.bankstatement.web.model;

import lombok.Getter;

/**
 * 은행의 부가적인 정보를 가지고있는 모델 클래스
 */
@Getter
public class BankProperties {
    private String name = "fastpay";
    private String description = "pay fast, live fast";

}
