package com.demo.nasabahapps.controller;

import com.demo.nasabahapps.model.Nasabah;
import com.demo.nasabahapps.service.NasabahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NasabahController {

    @Autowired
    private NasabahService nasabahService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listNasabah", nasabahService.getAllNasabah());
        return "index";
    }

    @GetMapping("/nsForm")
    public String nsForm(Model model) {
        Nasabah ns = new Nasabah();
        model.addAttribute("nasabah", ns);
        return "save_ns";
    }

    @PostMapping("/saveNs")
    public String saveNasabah(@ModelAttribute("nasabah") Nasabah req) {
        nasabahService.save(req);
        return "redirect:/";
    }

    @PostMapping("/updateNs")
    public String updateNasabah(@ModelAttribute("nasabah") Nasabah req) {
        nasabahService.update(req);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") int id, Model model) {

        Nasabah ns = nasabahService.getNasabahById(id);

        model.addAttribute("nasabah", ns);
        return "update_ns";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") int id) {

        this.nasabahService.deleteById(id);
        return "redirect:/";
    }

}
