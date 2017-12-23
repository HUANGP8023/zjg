package com.stkj.webService;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;  

import com.stkj.common.ApiVersion;
   
@RequestMapping("{version}")  
@RestController  
public class HelloController  {  
  
    @ApiVersion(1.1)  
    @RequestMapping("hello")  
    public @ResponseBody Map<String,Object> hello1(){  
    	Map<String,Object> resMap=new HashMap<String,Object>();
    	resMap.put("errorCode", "0");
    	resMap.put("errorMsg","hello1");
        return resMap;
    }  
      
    @ApiVersion(1.2)  
    @RequestMapping("hello")  
    public @ResponseBody Map<String,Object> hello2(){  
    	Map<String,Object> resMap=new HashMap<String,Object>();
    	resMap.put("errorCode", "0");
    	resMap.put("errorMsg","hello2");
        return resMap;
    }  
}  