package itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//声明该类是SpringBoot的引导类
@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
        //run方法表示运行SpringBoot的引导类  run参数就是SpringBoot引导类的字节码对象
        SpringApplication.run(MySpringBootApplication.class);
    }
}
