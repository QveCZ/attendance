package cz.qve.attendance.controllers;

import cz.qve.attendance.models.Attendance;
import cz.qve.attendance.services.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Objects;

@Controller
public class MainController {

    private final AttendService attendService;

    @Autowired
    public MainController(AttendService attendService){
        this.attendService = attendService;
    }
    @GetMapping("/")
    public String getMainPage(Model model, @RequestParam(value = "search", required = false) String search) {
        model.addAttribute("welcomeString", "Welcome to the Hell Attendance");
        //if(Objects.nonNull(search)){
       //     model.addAttribute("birds", attendService.getBirdsByName(search));
       // } else {
            model.addAttribute("attendances", attendService.getAttendances());
       // }
        return "index";
    }
    @GetMapping("/add-attendance")
    public String getAttendForm() {

        return "add-attendance";
    }
    @PostMapping("/add-attendance")
    public String createAttend(@RequestParam String name,
                               @RequestParam(required = false, defaultValue = "false") boolean isPresent,
                               @RequestParam float workedHours,
                               @RequestParam String date) {
       Attendance attendance = new Attendance(name, isPresent,workedHours,date);
        attendService.saveAttendance(attendance);
        return "redirect:/";
    }

}
