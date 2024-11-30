package cz.qve.attendance.services;

import cz.qve.attendance.models.Attendance;
import cz.qve.attendance.repositories.AttendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void updateAttendance(Long id) {

    }

    @Override
    public void saveAttendance(Attendance attendance) {
        attendRepository.save(attendance);
    }

}
