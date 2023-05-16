package Spring.demo.Controller;

import Spring.demo.Model.UserModel;
import Spring.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public  UserController(UserService userService){
        this.userService = userService;

    }

    @GetMapping("/index")
    public String getHomePage(Model model){
        model.addAttribute("homepage", new UserModel());
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("requestLogin", new UserModel());
        return "login";
    }
@GetMapping("/SignUp")
    public String SignUp (Model model){
        model.addAttribute("requestSignUp", new UserModel());
        return "SignUp";
    }
    @GetMapping("/voting")
    public String getVotingPage (Model model){
        model.addAttribute("requestVoting", new UserModel());
        return "voting_page";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute UserModel userModel){
        System.out.println("request register: " + userModel);
        UserModel registerUser= userService.createUser(userModel);
        return registerUser == null ? "error_page" : "redirect:/login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, Model model){
        System.out.println("Login Request: " + userModel);
        UserModel authenticate = userService.getUser(userModel);

        if(authenticate!= null){
            model.addAttribute("userLogin", authenticate.getEmail());
            return  "voting_page";
        }else {
            return "error_page";
        }
    }
}
