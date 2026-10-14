package hu.unimiskolc.student_service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/students")
    public List<Student> all() {
        return repo.findAll();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> one(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student s) {
        return repo.save(s);
    }
    @GetMapping("/students/search")
    public List<Student> search(@RequestParam String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/info")
    public Map<String, String> info() throws UnknownHostException {
        return Map.of(
                "host", InetAddress.getLocalHost().getHostName(),
                "java", System.getProperty("java.version")
        );
    }
}
