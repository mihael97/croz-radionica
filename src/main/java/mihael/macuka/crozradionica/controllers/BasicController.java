package mihael.macuka.crozradionica.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BasicController {
    @GetMapping("/")
    public ResponseEntity<?> testController() {
        return ResponseEntity.ok("Hello World");
    }
}
