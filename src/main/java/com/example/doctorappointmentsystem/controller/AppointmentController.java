package com.example.doctorappointmentsystem.controller;
import com.example.doctorappointmentsystem.model.Appointment;
import com.example.doctorappointmentsystem.model.Status;
import com.example.doctorappointmentsystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
/**
 * @author Muzammil Irshad
 */
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Optional<Appointment> getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping
    public Appointment bookAppointment(@RequestBody Appointment appointment) {
        return appointmentService.bookAppointment(appointment);
    }

    @PutMapping("/{id}/status")
    public Appointment updateAppointmentStatus(@PathVariable Long id, @RequestParam Status status) {
        return appointmentService.updateAppointmentStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "Appointment deleted (if it was canceled).";
    }
}