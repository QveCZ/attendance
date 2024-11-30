package cz.qve.attendance.repositories;

import cz.qve.attendance.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendRepository extends JpaRepository<Attendance,Long> {
}
