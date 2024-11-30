package cz.qve.attendance.services;

import cz.qve.attendance.models.Attendance;
import cz.qve.attendance.repositories.AttendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendImpl implements AttendService {
    private final AttendRepository attendRepository;
    @Autowired
    public AttendImpl(AttendRepository attendRepository) {
        this.attendRepository = attendRepository;
    }

    @Override
    public List<Attendance> getAttendances() {
        return attendRepository.findAll();
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        attendRepository.save(attendance);
    }


    @Override
    public void saveAttendance(Attendance attendance) {
        attendRepository.save(attendance);
    }

    @Override
    public Attendance getAttendById(Long id) {
        return attendRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Attedance with id " + id + " not found.")
        );
    }

    @Override
    public void deleteAttend(Long id) {
        Optional<Attendance> attend = attendRepository.findById(id);
        if (attend.isPresent()){
            attendRepository.delete(attend.get());
        }
    }

    @Override
    public List<Attendance> getIsPresent() {

        return attendRepository.findAllisPresent();
    }

}
