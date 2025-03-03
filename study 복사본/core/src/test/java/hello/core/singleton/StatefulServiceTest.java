package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        //userA 가 10000원 주문후 userB가 20000원 주문.
        int userA_Price = statefulService1.order("userA", 10000);

        int userB_Price = statefulService1.order("userB", 20000);
        //userA의 금액조회 --> 20000원

        Assertions.assertThat(userA_Price).isNotEqualTo(userB_Price);

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}