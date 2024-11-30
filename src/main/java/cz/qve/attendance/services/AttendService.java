package cz.qve.attendance.services;

import cz.qve.attendance.models.Attendance;

import java.util.List;

public interface AttendService {

    public List<Attendance> getAttendances();
    public void updateAttendance(Long id);

    public void saveAttendance(Attendance attendance);
}
