package com.mkyong.controller;

import com.mkyong.Models.Call;
import com.mkyong.Models.Patient;
import com.mkyong.Models.User;
import com.mkyong.Service.CallService;
import com.mkyong.Service.PatientService;
import com.mkyong.Service.ServiceMaker;
import com.mkyong.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.Authenticator;
import java.util.stream.Collectors;


@Controller
public class PatientController {

    @Autowired
    ServiceMaker serviceMaker;



    @RequestMapping("/addpatient")
    String home(Model model) {
        addAttributes(model);
        model.addAttribute("newPatient", new Patient());
        model.addAttribute("patientobj", new Patient());
        model.addAttribute("userobj", new User());
        return "addpatient";
    }

    @RequestMapping(value = "/addpatient/create-patient", method = RequestMethod.POST)
    public String create(@ModelAttribute("newPatient") Patient patient, BindingResult bindingResult, Model model){
        serviceMaker.insertPatient(patient);
        return "redirect:/addpatient";
    }

    @RequestMapping(value = "/addpatient/create-account", method = RequestMethod.POST)
    public String createAccount(@ModelAttribute("userobj") User user, BindingResult bindingResult, Model model){
        serviceMaker.insertUser(user);
        return "redirect:/addpatient";
    }

    @RequestMapping(value = "/addpatient/update-patient", params="action=Update", method = RequestMethod.POST)
    public String update(@ModelAttribute("patientobj") Patient selectedPatient, BindingResult bindingResult, Model model){
        System.out.println(selectedPatient.getPatient_id());
        serviceMaker.insertPatient(selectedPatient);
        return "redirect:/addpatient";
    }

    @RequestMapping(value = "/addpatient/update-patient", params="action=Delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute("patientobj") Patient selectedPatient, BindingResult bindingResult, Model model){
        serviceMaker.removePatient(selectedPatient.getPatient_id());
        return "redirect:/addpatient";
    }

    @RequestMapping(value = "/viewfile")
    public String view(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User userlogged = serviceMaker.findByUsernameUser(username);
        Patient p = serviceMaker.findByIdPatient(userlogged.getId());
        System.out.println(p.getName());
        model.addAttribute("patientlogged", serviceMaker.findByIdPatient(userlogged.getId()));
        return "/viewfile";
    }

    @RequestMapping(value = "/home-patient/emergency")
    public String emergency(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User userlogged = serviceMaker.findByUsernameUser(username);
        Patient p = serviceMaker.findByIdPatient(userlogged.getId());
        Call call = new Call("EMERGENCY", p);
        serviceMaker.insertCall(call);
        return "redirect:/home-patient";
    }

    @RequestMapping(value = "/home-patient/medicine")
    public String medicineCall(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User userlogged = serviceMaker.findByUsernameUser(username);
        Patient p = serviceMaker.findByIdPatient(userlogged.getId());
        Call call = new Call("Medicine", p);
        serviceMaker.insertCall(call);
        return "redirect:/home-patient";
    }

    @RequestMapping(value = "/home-patient/water")
    public String waterCall(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User userlogged = serviceMaker.findByUsernameUser(username);
        Patient p = serviceMaker.findByIdPatient(userlogged.getId());
        Call call = new Call("Water", p);
        serviceMaker.insertCall(call);
        return "redirect:/home-patient";
    }

    private void addAttributes(Model model){
        model.addAttribute("patients", serviceMaker.findAllPatient());
    }
}
