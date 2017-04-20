package ce.simple.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 * @author zss
 * @date 2017年4月20日
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class App {
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
    }
}
