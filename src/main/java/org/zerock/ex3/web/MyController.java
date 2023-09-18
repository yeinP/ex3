package org.zerock.ex3.web;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Log4j2
@Controller
public class MyController {
    @GetMapping("/main")
    public void  main() {
        log.info("===================================");
    }

}
