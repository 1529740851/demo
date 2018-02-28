package com.example.demo.Controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Date;
import java.util.Map;


import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Service.IiService;
import com.example.demo.entity.Ii;


@Controller
public class Yemian {

	@Autowired
private IiService service;	
	
	 @RequestMapping("/test")
	    public String test(){ 
	        return "index";
	    }
	 @RequestMapping("/index2")
	 public String index2(Map<String,Object> map) {
		 map.put("hello","hello");
	        return "index2";
	    }
	 @RequestMapping("/index")
	 public String index(Map<String,Object> map) {
		 map.put("Ii",service.Select());
		// service.Select2();
	        return "index";
	    }
	 /*
		 * Optional<String> 参数可传可不传
		 * */
		@RequestMapping("/insert")
		public  String  insert( Ii i,String  userName){
			System.out.println(i.getId3());
			service.insert(i);
			return "redirect:/index";
		}
		@RequestMapping("/delete")
		public  String  delete(String id ){
			if(StringUtils.isNotBlank(id)  ){
				service.delete(id);
				
			}
			return "redirect:/index";
			
			
		}
	 
}