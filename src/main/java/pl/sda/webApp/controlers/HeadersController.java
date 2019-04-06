package pl.sda.webApp.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeadersController {
    @GetMapping(value = "/headers")
    public void displayHeaderInfo(@RequestHeader("Accept") String value) {
        System.out.println(value);
    }
}
