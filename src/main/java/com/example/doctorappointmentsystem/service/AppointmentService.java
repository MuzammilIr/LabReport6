package com.example.doctorappointmentsystem.service;
import com.example.doctorappointmentsystem.model.Appointment;
import com.example.doctorappointmentsystem.model.Status;
import com.example.doctorappointmentsystem.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
/**
 * @author Muzammil Irshad
 */
@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment bookAppointment(Appointment appointment) {
        appointment.setStatus(Status.SCHEDULED);
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointmentStatus(Long id, Status status) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if (optionalAppointment.isPresent()) {
            Appointment appointment = optionalAppointment.get();
            appointment.setStatus(status);
            return appointmentRepository.save(appointment);
        }
        return null;
    }

    public void deleteAppointment(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        appointment.ifPresent(a -> {
            if (a.getStatus() == Status.CANCELED) {
                appointmentRepository.deleteById(id);
            }
        });
    }
}