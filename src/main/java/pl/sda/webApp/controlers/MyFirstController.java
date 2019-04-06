package pl.sda.webApp.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world";
    }
}
