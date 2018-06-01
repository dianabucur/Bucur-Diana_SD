package com.mkyong.controller;

import com.mkyong.Models.*;
import com.mkyong.Service.MedicineService;
import com.mkyong.Service.PatientService;
import com.mkyong.Service.ServiceMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;
import java.util.List;

@Controller
public class NurseController {

    @Autowired
    ServiceMaker serviceMaker;

    @RequestMapping("/prescription")
    String home(Model model) {
        addAttributes(model);
        model.addAttribute("cureobj", new Cure());
        return "prescription";
    }

    @RequestMapping(value = "/prescription/add-med", method = RequestMethod.POST)
    public String addMed(@ModelAttribute("cureobj") Cure cure, BindingResult bindingResult, Model model){
        Patient patient = serviceMaker.findByIdPatient(cure.getPatient_id());
        List<Medicine> pacientMeds = patient.getMedication();
        Medicine med = serviceMaker.findByIdMedicine(cure.getMed_id());
        pacientMeds.add(med);
        patient.setMedication(pacientMeds);
        serviceMaker.insertPatient(patient);
        return "redirect:/prescription";
    }

    private void addAttributes(Model model){
        model.addAttribute("patients", serviceMaker.findAllPatient());
        model.addAttribute("meds", serviceMaker.findAllMedicine());
    }

    @RequestMapping(value = "/view-calls")
    public String viewCalls(Model model){
        List<Call> calls = serviceMaker.findAllCall();
        LinkedList<Call> callsordered = new LinkedList<>();
        CallIterator callIterator = new CallIterator(calls);
        while(callIterator.hasNext()){
            Call next = callIterator.next();
            if(next.getReason().equals("EMERGENCY")){
                callsordered.addFirst(next);
            }
            else
                callsordered.add(next);
        }
        model.addAttribute("allcalls", callsordered);
        return "/view-calls";
    }

    @RequestMapping(value = "/view-calls/take-call")
    public String takeCall(Model model){
        List<Call> calls = serviceMaker.findAllCall();
        LinkedList<Call> callsordered = new LinkedList<>();
        CallIterator callIterator = new CallIterator(calls);
        while(callIterator.hasNext()){
            Call next = callIterator.next();
            if(next.getReason().equals("EMERGENCY")){
                callsordered.addFirst(next);
            }
            else
                callsordered.add(next);
        }
        int id = callsordered.get(0).getId();
        serviceMaker.removeCall(id);
        return "redirect:/view-calls";
    }



}
