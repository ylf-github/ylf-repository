package controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bean.Date_Number;
@Controller
public class FormatController {
         @RequestMapping(value="/test",method=RequestMethod.POST)
         public String test(@ModelAttribute Date_Number date_number,Model model){
			model.addAttribute("date_number",date_number);
        	 return "formatSucc";
         }
}
