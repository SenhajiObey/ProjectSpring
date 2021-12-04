package be.vinci.ipl.frontenduser.controllers;



import be.vinci.ipl.frontenduser.config.CustomProperties;
import be.vinci.ipl.frontenduser.model.User;
import be.vinci.ipl.frontenduser.model.UserDTO;
import be.vinci.ipl.frontenduser.proxy.FrontendUserProxy;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/")
public class FrontendUserController {

    private FrontendUserProxy proxyUser;
    private UserDTO userDTO;



    public FrontendUserController(FrontendUserProxy fup, CustomProperties props){
        this.proxyUser = fup;

    }
    @GetMapping("/login")
    public String login(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @GetMapping("/success")
    public String success(Model model){

        return "succed";
    }


    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("user") User user, HttpServletResponse response) throws Exception {

        if (proxyUser.checkUser(user)) {

            Cookie cookie = new Cookie("token", proxyUser.createToken(user));
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            //A renvoyez dans les autres services (User mais sans le mot de passe)
            userDTO= new UserDTO(user);
            //Placement du user en cookie
            Cookie cookieUser = new Cookie("user", userDTO.toString());
            cookieUser.setHttpOnly(true);
            response.addCookie(cookieUser);
            return new ModelAndView("redirect:/success");
        }


        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("user") User user, HttpServletResponse response) throws Exception{
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        if(proxyUser.createUser(user)){
            return new ModelAndView("redirect:/login");
        }
    return new ModelAndView("redirect:/register");
    }

    public ModelAndView loginPage(){
        return new ModelAndView();
    }
}
