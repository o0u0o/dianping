package com.o0u0o.dianping.controller.admin;

import com.o0u0o.dianping.commom.AdminPermission;
import com.o0u0o.dianping.commom.enums.BusinessErrorEnum;
import com.o0u0o.dianping.commom.exception.BusinessException;
import com.o0u0o.dianping.service.SellerService;
import com.o0u0o.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import static com.o0u0o.dianping.commom.utils.encryptPwdUtil.encodeByMd5;

/**
 * @Author aiuiot
 * @Date 2020/3/8 6:16 下午
 * @Descripton: 管理员控制器
 **/
@Controller("/admin/admin")
@RequestMapping("/admin/admin")
public class AdminController {

    @Value("${admin.email}")
    private String email;

    @Value("${admin.encryptPassword}")
    private String encryptPassword;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private UserService userService;

    @Autowired
    private SellerService sellerService;

    public static final String CURRENT_ADMIN_SESSION = "currentAdminSession";

    /**
     * 跳转至管理员页面
     * @return
     */
    @RequestMapping("/index")
    //@AdminPermission(produceType = "application/json")
    @AdminPermission
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/admin/admin/index");
        modelAndView.addObject("userCount", userService.countAllUser());
        modelAndView.addObject("sellerCount", sellerService.countAllSeller());
        modelAndView.addObject("CONTROLLER_NAME", "admin");
        modelAndView.addObject("ACTION_NAME","index");
        return modelAndView;
    }

    /**
     * 跳转至登录页面
     * @return
     */
    @RequestMapping("/loginpage")
    public ModelAndView loginPage(){
        ModelAndView modelAndView = new ModelAndView("/admin/admin/login");
        return modelAndView;
    }

    /**
     * 登录接口
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(name = "email") String email,
                              @RequestParam(name = "password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if (StringUtils.isEmpty(email)||StringUtils.isEmpty(password)){
            throw new BusinessException(BusinessErrorEnum.PARAMETER_VALIDATION_ERROR, "用户名密码不能为空");
        }
        if (email.equals(this.email) && encodeByMd5(password).equals(this.encryptPassword)){
            //登录成功 设置session
            httpServletRequest.getSession().setAttribute(CURRENT_ADMIN_SESSION, email);
            return "redirect:/admin/admin/index";
        } else {
            throw new BusinessException(BusinessErrorEnum.PARAMETER_VALIDATION_ERROR, "用户名密码错误");
        }
    }
}
