package org.askiesolutions.accountui;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountUiApplication {
    static void main(String[] args) {
        SpringApplication.run(AccountUiApplication.class, args);
    }
}
