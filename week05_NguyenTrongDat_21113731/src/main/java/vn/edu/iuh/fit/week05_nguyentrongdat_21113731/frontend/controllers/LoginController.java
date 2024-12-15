package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services.ICandidate;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.services.ICompany;


@Controller

public class LoginController {
    @Autowired
    private ICandidate candidateService;
    @Autowired
    private ICompany companyService;


    @GetMapping("/login")
    public String showLogin() {
        return "index";
    }
    @PostMapping("/login")
    public String handleLogin(Model model, @RequestParam("id") String id, @RequestParam("choice") String choice) {
        Long idFind = Long.parseLong(id);
        if (choice.equals("candidate")) {
            if (candidateService.existsById(idFind)) {
                return "redirect:/home/candidate?id="+idFind;
            } else {
                model.addAttribute("enrorr_login", "Candidate not found");
                return "index";
            }
        } else {
            if (companyService.existsById(idFind)) {

                return "redirect:/home/company?id="+idFind;
            } else {
                model.addAttribute("enrorr_login", "Company not found");
                return "index";
            }
        }

    }
}
