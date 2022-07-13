package org.zerock.guestbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

  // static의 index로 가지 않고 template의 index로 감
  @RequestMapping({ "", "/" })
  public String index() {
    return "index";
  }

}
