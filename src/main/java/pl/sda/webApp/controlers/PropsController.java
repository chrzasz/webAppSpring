package pl.sda.webApp.controlers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/props")
@RestController
public class PropsController {

    @Value("${pl.sda.value}")
    private String value;

    @GetMapping("/")
    public String getValue() {
        return value;
    }

    @GetMapping("/list")
    public List<String> show() {

        int val = Integer.valueOf(value);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < val; i++) {
            list.add("JAVA");
        }

        return list;
    }

}
