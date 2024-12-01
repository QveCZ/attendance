package cz.qve.attendance.repositories;

import cz.qve.attendance.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AttendRepository extends JpaRepository<Attendance,Long> {

    @Query(value = "SELECT * from attendances WHERE is_present = true", nativeQuery = true)
    List<Attendance> findAllisPresent();

    List<Attendance> findAttendanceByNameContainsIgnoreCase(String s);
    @Query(value = "SELECT * from attendances WHERE date > :date AND date < :date2", nativeQuery = true)
    List<Attendance> findAttendanceByDate(@Param("date") LocalDateTime d, @Param("date2") LocalDateTime d2);
}
