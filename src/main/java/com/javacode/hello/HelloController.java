package com.javacode.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    private List<String> names = new ArrayList<>();
    private List<String> dates = new ArrayList<>();

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("names", names);
        model.addAttribute("dates", dates);
        return "helloWorld";
    }

    @PostMapping("/submit")
    public String handleSubmit(@RequestParam String name, @RequestParam String date, Model model) {
        names.add(name);
        dates.add(date);
        return "redirect:/";
    }

    @PostMapping("/delete/{index}")
    public String handleDelete(@PathVariable int index, Model model) {
        if (index >= 0) {
            names.remove(index);
            dates.remove(index);
        }
        return "redirect:/";
    }

    @PostMapping("/update/{index}")
    public String handleUpdate(@PathVariable int index, @RequestParam String newName, @RequestParam String newDate,
            Model model) {
        if (index >= 0) {
            names.set(index, newName);
            dates.set(index, newDate);

        }
        return "redirect:/";
    }
}
