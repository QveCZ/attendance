package cz.qve.attendance.repositories;

import cz.qve.attendance.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendRepository extends JpaRepository<Attendance,Long> {

    @Query(value = "SELECT * from attendances WHERE is_present = true", nativeQuery = true)
    List<Attendance> findAllisPresent();
}
