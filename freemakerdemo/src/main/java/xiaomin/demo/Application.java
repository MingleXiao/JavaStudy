package xiaomin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);

        try {
            FreeMakerTemplate.OutPut();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

