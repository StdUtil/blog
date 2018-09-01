package xyz.stackoverflow.blog.web.controller;

import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.stackoverflow.blog.pojo.ResponseMessage;
import xyz.stackoverflow.blog.pojo.ValidateResult;
import xyz.stackoverflow.blog.pojo.entity.User;
import xyz.stackoverflow.blog.pojo.vo.RegisterVO;
import xyz.stackoverflow.blog.service.UserService;
import xyz.stackoverflow.blog.util.ValidateUtil;

@Controller
@RequestMapping("/user")
public class RegisterController {

    private final Integer success =  0;
    private final Integer vcodeError = 1;
    private final Integer fieldError = 2;
    private final Integer otherError = 3;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/register",method=RequestMethod.POST)
    @ResponseBody
    public ResponseMessage register(@RequestBody RegisterVO registerVO, ShiroHttpSession session){

        ResponseMessage responseMessage = new ResponseMessage();
        String vcode = (String) session.getAttribute("vcode");

        if(!vcode.equalsIgnoreCase(registerVO.getVcode())){
            responseMessage.setStatus(vcodeError);
            responseMessage.setData(new String("验证码错误"));
            return responseMessage;
        }

        ValidateResult result = ValidateUtil.validateRegisterInfo(registerVO);

        if(result.getStatus()==0){
            User user = registerVO.toUser();
            try{
                userService.addUser(user);
            }catch (Exception e){
                responseMessage.setStatus(otherError);
                responseMessage.setData(e.getMessage());
                return responseMessage;
            }
            responseMessage.setStatus(success);
        }else{
            responseMessage.setStatus(fieldError);
            responseMessage.setData(result);
        }
        return responseMessage;
    }

    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String register(){
        return "/user/register";
    }
}
