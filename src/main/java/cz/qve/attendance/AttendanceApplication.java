package cz.qve.attendance;

import cz.qve.attendance.models.Attendance;
import cz.qve.attendance.repositories.AttendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class AttendanceApplication implements CommandLineRunner {

	private final AttendRepository attendRepository;

	@Autowired
	public AttendanceApplication(AttendRepository attendRepository){
		this.attendRepository = attendRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AttendanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Attendance> attendances= new ArrayList<>(List.of(
				new Attendance("Pepa Vomacka",true, 8.5F, "10-10-2024 05:00:11"),
				new Attendance("Pepa Vomacka",true, 8.0F, "10-11-2024 06:00:11"),
				new Attendance("Beda Travnicek",true, 8.5F, "10-12-2024 05:55:11"),
				new Attendance("Jan Vošmik",false, 0F, "10-11-2024 05:00:11")
		));
		for (Attendance attendance : attendances){
			attendRepository.save(attendance);
		}
	}
}
