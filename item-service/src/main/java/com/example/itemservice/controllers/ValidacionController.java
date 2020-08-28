package com.example.itemservice.controllers;

import com.example.itemservice.controllers.DAO.PlanesDao;
import com.example.itemservice.models.Planes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ValidacionController {
    @Autowired
    RestTemplate restTemplate;
    private Object PlanesDao;
    @RequestMapping("/")
    public String index(Model model, Principal principal ){

        model.addAttribute("titulo", "J&R CXA");
        return "redirect:/login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "registrar", method = RequestMethod.GET)
    public String registrar (){
        return "registrar";
    }

    @RequestMapping (value = "/compra")
    public String compra(Model model){
       PlanesDao [] objectoplanes =  restTemplate.getForObject("http://servicio-productos/api/venta",PlanesDao[].class);
        List<PlanesDao> planesDaoList = new ArrayList<>();
        for(int i=0; i<objectoplanes.length; i++ ){
            planesDaoList.add(objectoplanes[i]);
        }
        model.addAttribute("titulo", "MULTIMEDIA CXA");
        model.addAttribute("planes",planesDaoList);
        return "compra";
    }
}
