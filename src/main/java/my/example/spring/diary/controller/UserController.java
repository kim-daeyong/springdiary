package my.example.spring.diary.controller;

import my.example.spring.diary.dto.User;
import my.example.spring.diary.service.UserService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/joinform")
    public String joinform() {
        return "joinform";
    }

    @PostMapping("/join")
//    public String join(@RequestParam(name = "name") String name,
//                       @RequestParam(name = "nickname") String nickname,
//                       @RequestParam(name = "email") String email,
//                       @RequestParam(name = "passwd) String passwd,
//                       @RequestHeader(name = "Accept") String accept,
//                       HttpSession session){
    public String join(@ModelAttribute User user,
                       @RequestHeader(name = "Accept") String accept,
                       HttpSession session,
                       Model model) {

        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();

        String encodePasswd = passwordEncoder.encode(user.getPasswd());
        user.setPasswd(encodePasswd);
        User newuser = userService.addUser(user);
        newuser.getNickname();

        model.addAttribute("user", newuser);
        return "loginform";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/loginform")
    public String loginform() {
        return "loginform";
    }

    @PostMapping("/login")
    @Transactional(readOnly = true)
    public String login(@RequestParam(name = "email") String email,
                        @RequestParam(name = "passwd") String passwd,
                        HttpSession session) {
        User userInfo = userService.getUserByEmail(email);
        if (userInfo != null) {
            if (userInfo.getPasswd() != null) {
                String encodePasswd = userInfo.getPasswd();
                PasswordEncoder passwordEncoder =
                        PasswordEncoderFactories.createDelegatingPasswordEncoder();
                boolean matches = passwordEncoder.matches(passwd, encodePasswd);
                if (matches) {
                    // 로그인정보를 세션에 저장.
                    session.setAttribute("logininfo", userInfo);
                    System.out.println("암호가 맞아요.");
                } else {
                    // 암호가 틀렸어요.
                    System.out.println("암호가 틀렸어요.");
                }
            }
            return "redirect:/welcome";
        }
        else{
            return "/loginform";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("logininfo");
        return "redirect:/main";
    }
}
