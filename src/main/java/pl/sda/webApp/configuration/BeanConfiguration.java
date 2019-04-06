package pl.sda.webApp.configuration;

import org.springframework.context.annotation.Bean;
import pl.sda.webApp.service.AnimalService;

public class BeanConfiguration {

    @Bean
    public AnimalService animalService() {
        return new AnimalService();
    }

    @Bean
    public String abc() {
        return "abc";
    }

    @Bean
    public String def() {
        return "def";
    }
}
