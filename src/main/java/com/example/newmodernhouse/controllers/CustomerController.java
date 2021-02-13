package com.example.newmodernhouse.controllers;

import com.example.newmodernhouse.models.TechnicalTask;
import com.example.newmodernhouse.repository.TechnicalTaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping
public class CustomerController {
    private final TechnicalTaskRepository technicalTaskRepository;

    public CustomerController(TechnicalTaskRepository technicalTaskRepository) {
        this.technicalTaskRepository = technicalTaskRepository;
    }

    @GetMapping("/task")
    public String task(){
        return "technical-task";
    }

    @PostMapping("/technical_task")
    public String technicalTask(TechnicalTask form) {
        Date currentDate = new Date();
//        http://www.seostella.com/uk/article/2012/02/05/formatuvannya-dati-v-java.html
        SimpleDateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("dd:MM:YYYY");
        System.out.println("Constructor 2: " + dateFormat.format(currentDate));

        String nameTask = dateFormat.format(currentDate) + "@" + form.getHouse_name();

        TechnicalTask newTask = TechnicalTask.builder()
                .nameTask(nameTask)
                .architecture(form.isArchitecture())
                .landscaping(form.isLandscaping())
                .constructive(form.isConstructive())
                .specification(form.isSpecification())
                .engineering(form.isEngineering())
                .engineering_energy(form.isEngineering_energy())
                .house_name(form.getHouse_name())
                .phone(form.getPhone())
                .text(form.getText())
                .build();
        technicalTaskRepository.save(newTask);
        return "okay";
    }
}
