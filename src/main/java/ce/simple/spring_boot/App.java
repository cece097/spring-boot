package ce.simple.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ce.simple.spring_boot.common.data.ExpandRepositoryFactoryBean;

/**
 * Hello world!
 * @author zss
 * @date 2017年4月20日
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableJpaRepositories(repositoryFactoryBeanClass = ExpandRepositoryFactoryBean.class)
public class App {
    public static void main( String[] args ){
        System.setProperty("spring.devtools.restart.enabled", "true");
        SpringApplication.run(App.class, args);
    }
}
