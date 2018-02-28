package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ni")
public class SSController {

	@RequestMapping("/oo")
	@ResponseBody
	public  String mi(){
		return "成功";
	}
	
}
