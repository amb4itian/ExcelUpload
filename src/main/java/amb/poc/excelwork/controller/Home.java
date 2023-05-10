package amb.poc.excelwork.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@Controller
public class Home {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("text", "This is home url");
        return "home";
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("text", "This is dashboard url");
        return home(model);
    }

    @GetMapping("/amb")
    public String dashboard2(Model model) {
        model.addAttribute("text", "This is Ambi");
        return "home";
    }

    
}

