package be.vinci.ipl.frontenduser.controllers;



import be.vinci.ipl.frontenduser.config.CustomProperties;
import be.vinci.ipl.frontenduser.model.User;
import be.vinci.ipl.frontenduser.proxy.FrontendUserProxy;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class FrontendUserController {

    private FrontendUserProxy proxyUser;



    public FrontendUserController(FrontendUserProxy fup, CustomProperties props){
        this.proxyUser = fup;

    }



    public ModelAndView loginPage(){
        return new ModelAndView();
    }
}
