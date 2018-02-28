package com.example.demo.Controller;

import java.io.IOException;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Service.IiService;
import com.google.zxing.WriterException;

@RestController
@RequestMapping("/ni")
public class FengController {

	@Autowired
private IiService service;	
	
	@RequestMapping("/qrcode")
	public  String qrcode(HttpServletResponse response,String xiaoqu){
		try {
			service.qrcode(response, xiaoqu);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "成功";
	}
	
	
	@RequestMapping("/oo")

	public  String mi(){
		return "成功";
	}
	
	@RequestMapping("/o")
	public  Object mi1(){
		return  service.Select();
	}
	
}
