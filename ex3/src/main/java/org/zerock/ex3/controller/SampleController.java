package org.zerock.ex3.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.LongFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.ex3.dto.SampleDTO;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {
  @GetMapping("/ex1")
  public void ex1(Model model) {
    // void일 때 요청된 url과 resource파일이 일치함
    // return 필요하지 않음
    log.info("ex1/.................");

    model.addAttribute("title", "Hello ex1");
  }

  @GetMapping({ "/ex2", "/exLink" })
  public void ex2(Model model) { // view의 내용을 보내주기 위함
    log.info("ex2/.................");
    model.addAttribute("title", "Hello ex2");
    // ("key","value")

    List<SampleDTO> list = IntStream.rangeClosed(1, 20)
        .asLongStream()
        .mapToObj(new LongFunction<SampleDTO>() {
          @Override
          public SampleDTO apply(long i) {
            SampleDTO dto = SampleDTO.builder()
                .sno(i)
                .first("First..." + i)
                .last("Last..." + i)
                .regTime(LocalDateTime.now())
                .build();

            return dto;
          }
        }).collect(Collectors.toList());
    model.addAttribute("list", list);
    // return "/sample/ex1"; // 경로 표시

  }

  @GetMapping({ "/exInline" })
  public String exInline(RedirectAttributes ra) {
    log.info("exInline.............");
    SampleDTO dto = SampleDTO.builder()
        .sno(100L).first("First...100")
        .last("Last...100")
        .regTime(LocalDateTime.now())
        .build();
    ra.addFlashAttribute("result", "success");
    ra.addFlashAttribute("dto", dto);
    // 일회성
    return "redirect:/sample/ex3";
  }

  @GetMapping("/ex3")
  public void ex3() {
    log.info("ex3...........");
  }

  @GetMapping({ "/exLayout1", "/exLayout2", "/exTemplate", "/exSidebar" })
  public void exLayout1() {
    log.info("exLayout1.........................");
  }

}
