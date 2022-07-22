package org.zerock.mrerview.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.mrerview.dto.PageRequetDTO;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.mrerview.dto.MovieDTO;
import org.zerock.mrerview.sevice.MovieService;


@Controller
@RequestMapping("/movie")
@Log4j2
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    @GetMapping("/register")
    public void register(){

    }
    @PostMapping("/register")
    public String register(MovieDTO movieDTO, RedirectAttributes redirectAttributes){
        log.info("movieDTO: " + movieDTO);
        Long mno = movieService.register(movieDTO);
        redirectAttributes.addAttribute("msg", mno);
        return "redirect:/movie/list";
    }

    @GetMapping("/list")
    public void list(PageRequetDTO pageRequestDTO, Model model){
        log.info("pageRequestDTO" + pageRequestDTO);
        model.addAttribute("result", movieService.getList(pageRequestDTO));
    }

    @GetMapping({"/read", "/modify"})
    public void read(long mno, @ModelAttribute("requestDTO") PageRequetDTO requestDTO, Model model){
        log.info("mno= {}",mno);
        MovieDTO movieDTO = movieService.getMovie(mno);
        model.addAttribute("dto", movieDTO);
    }
}

