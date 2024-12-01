package cz.qve.attendance.services;

import cz.qve.attendance.models.Attendance;

import java.util.List;

public interface AttendService {

    public List<Attendance> getAttendances();
    public void updateAttendance(Attendance attendance);

    public void saveAttendance(Attendance attendance);

    Attendance getAttendById(Long id);

    void deleteAttend(Long id);

    List<Attendance> getIsPresent();

    List<Attendance> getAttendancesByName(String name);

    List<Attendance> getAttendancesByDate(String date);



}
