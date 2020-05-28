package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    DirectorRepository directorRepository;
    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/home")
    public String homePage(Model model){
        model.addAttribute("directorList", directorRepository.findAll());
        return "directorList";
    }

    @RequestMapping("/addDirector")
    public String addDirector(Model model){
        model.addAttribute("newDirector", new Director());
        return "addDirector";
    }

    @PostMapping("/processDirector")
    public String processDirector(@ModelAttribute("newDirector") Director director){
        directorRepository.save(director);
        return "redirect:/home";
    }

    @PostMapping("/processUpdateDirector")
    public String processUpdateDirector(@ModelAttribute("newDirector") Director director){
        directorRepository.save(director);
        return "redirect:/home";
    }

    @RequestMapping("/addMovie")
    public String addMovie(Model model){
        model.addAttribute("newMovie", new Movie());
        model.addAttribute("directorList", directorRepository.findAll());
        return "addMovie";
    }

    @PostMapping("/processMovie")
    public String processMovie(@ModelAttribute("newMovie") Movie movie){
        movieRepository.save(movie);
        return "redirect:/home";
    }
    @PostMapping("/processUpdateMovie")
    public String processUpdateMovie(@ModelAttribute("newMovie") Movie movie){
        movieRepository.save(movie);
        return "redirect:/listMovie";
    }

    @RequestMapping("/deleteDirector/{id}")
    public String deleteDirector(@PathVariable("id") long id){
        directorRepository.deleteById(id);
        return "redirect:/home";
    }

    @RequestMapping("/updateDirector/{id}")
    public String updateDirector(@PathVariable("id") long id, Model model){
        model.addAttribute("newDirector", directorRepository.findById(id).get());
        return "updateDirector";
    }

    @RequestMapping("/listMovie")
    public String listMovie(Model model){
        model.addAttribute("movieLists", movieRepository.findAll());
        return "listMovie";
    }

    @RequestMapping("/updateMovie/{id}")
    public String updateMovie(@PathVariable("id") long id, Model model){
        model.addAttribute("newMovie", movieRepository.findById(id).get());
        model.addAttribute("directorList", directorRepository.findAll());
        return "updateMovie";
    }

    @RequestMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable("id") long id){
        movieRepository.deleteById(id);
        return "redirect:/listMovie";
    }
}
