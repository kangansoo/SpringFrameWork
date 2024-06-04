package springFw.ex06.mvc02;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
   // model => spring, locale => java
   @RequestMapping(value = "/")
   public String home(Locale locale, Model model) {
      String reuslt = "home";   // 확장자 .jsp는 빼도 된다
      model.addAttribute("serverType", "서버시간");
      
      return reuslt;
   }
}

