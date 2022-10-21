package poc.personal.togglemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ToggleManagerApplication {

    public static void main(final String[] args) {

        SpringApplication.run(ToggleManagerApplication.class, args);
    }

}
