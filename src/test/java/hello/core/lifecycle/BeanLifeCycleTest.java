package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class); // 1.스프링 컨테이너 생성
        NetworkClient client = ac.getBean(NetworkClient.class); // 5.빈 사용
        ac.close(); //6.소멸 전 콜백
    }

    @Configuration
    static class LifeCycleConfig {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();// 2.스프링 빈 생성
            networkClient.setUrl("http://hello-spring.dev"); // 3.의존관계 주입
            return networkClient;

        }
    }
}
