package com.example.doctorappointmentsystem.repository;

import com.example.doctorappointmentsystem.model.Appointment;
import com.example.doctorappointmentsystem.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByStatus(Status status);
}
