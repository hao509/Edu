package com.yang.edu.controller;

import com.yang.edu.entity.Student;
import com.yang.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Controller
public class LoginController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String loginPage(){
        return "welcome";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String stuLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public void loginout(HttpSession session,HttpServletResponse response) throws IOException {
        //清除session
        session.invalidate();
        //退出后重新返回到登录选择界面
        response.sendRedirect("/edu/login");
    }

    /**
     * 获取验证码，将用户名和当前日期作为key，验证码为value存进redis，并设置过期时间
     * @param request
     * @return
     */
    @RequestMapping(value = "/login/getCheckNum",method = RequestMethod.GET)
    @ResponseBody
    public int getCheckNum(HttpServletRequest request){

        /**
         * 将用户名和当前日期作为key
         */
        String user = request.getParameter("user");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
        user = user+simpleDateFormat.format(date);

        int flag  = (int)((Math.random() * 9 + 1) * 1000);

        redisTemplate.opsForValue().set(user,flag,5, TimeUnit.MINUTES);

        return flag;
    }

    /**
     * 登录逻辑处理
     * @return
     */

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map login( HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("userName");
        String userPassword  = request.getParameter("userPassword");
        //0-管理员   1-教职工   2-学生
        String flag = request.getParameter("flag");

        Map<String,String> message = new HashMap<>();

        if("2".equals(flag)){
            Student student = new Student();
            student = studentService.getStudent(userName);
            if(student==null){
                message.put("content","用户不存在");
                message.put("status","0");
                return message;
            }else if(userPassword.equals(student.getStudentPassword())){
                HttpSession session = request.getSession();
                //将成功登录的用户信息注入到session中
                session.setAttribute("user_session_key", student);

                message.put("content","登录成功");
                message.put("status","1");
                message.put("user","2");
                return message;
            }else{
                message.put("content","密码错误");
                message.put("status","0");
                message.put("user","2");
                return message;
            }
        }else if ("1".equals(flag)){
            return message;
        }else {
            return message;
        }
    }
}

