package org.zerock.ex3.web;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.ex3.web.dto.SampleDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/ex1")
    public void ex1111() {
        log.info("ex1---------------------------");
    }

    @GetMapping({"/ex223", "/ex22", "/ex2", "/ex24", "/ex25",
            "/ex26", "/ex27","/ex229", "exLink"})
    public void exModel(Model model) {
        List<SampleDto> list2 = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            SampleDto dto = SampleDto.builder()
                    .sno((long) i)
                    .first("First" + i)
                    .last("Last" + i)
                    .regTime(LocalDateTime.now())
                    .build();
            list2.add(dto);
        }
    //위 아래 같음


        List<SampleDto> list = IntStream.rangeClosed(1,20).asLongStream().
                mapToObj(i -> {
                    SampleDto dto = SampleDto.builder()
                        .sno(i)
                        .first("First" + i)
                        .last("Last" + i)
                        .regTime(LocalDateTime.now())
                        .build();
                    return dto;
                }).collect(Collectors.toList());

        model.addAttribute("list", list);
    }

    @GetMapping({"/exInline"})
    public String exInline(RedirectAttributes redirectAttributes) {
        //리다이렉트 직전에 플래시에 저장하는 메소드
        //리다이렉트 이후에 소멸됨
        SampleDto dto = SampleDto.builder()
                .sno(100L)
                .first("First100")
                .last("Last100")
                .regTime(LocalDateTime.now())
                .build();
        redirectAttributes.addFlashAttribute("result", "success");
        redirectAttributes.addFlashAttribute("dto", dto);

        return "redirect:/sample/ex3"; //요청이 들어간다
    }

    @GetMapping("/ex3")
    public void ex3() {
        log.info("ex3");
    }
}
