package com.o0u0o.dianping.controller;

import com.o0u0o.dianping.commom.CommonError;
import com.o0u0o.dianping.commom.R;
import com.o0u0o.dianping.commom.enums.BusinessErrorEnum;
import com.o0u0o.dianping.commom.exception.BusinessException;
import com.o0u0o.dianping.model.UserModel;
import com.o0u0o.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author aiuiot
 * @Date 2020/2/27 12:03 上午
 * @Descripton:
 **/
@Controller("/user")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }

    @RequestMapping("/index")
    public ModelAndView index(){
        String name = "张三";
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("name", name);
        return modelAndView;
    }

    @GetMapping("/get")
    @ResponseBody
    public R getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        UserModel userModel = userService.getUser(id);
        if (userModel == null){
            throw new BusinessException(BusinessErrorEnum.NO_OBJECT_FOUND);
            //return R.fail(new CommonError(BusinessErrorEnum.NO_OBJECT_FOUND));
        }
        return R.success(userModel);
    }
}
