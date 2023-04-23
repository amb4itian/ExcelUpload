package amb.poc.excelwork.controller;

import amb.poc.excelwork.entity.Student;
import amb.poc.excelwork.repo.StudentRepo;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class RestControlller {

    private Logger logger = LoggerFactory.getLogger(RestControlller.class);
    @Autowired
    private StudentRepo repo;

    @GetMapping("")
    public List<Student> test() {

        Student st = new Student();
        st.setId(1);
        st.setCity("Bangalore");
        st.setFirstName("Ambrish");
        return repo.findAll();
    }

    @PostMapping("/new")
    public Student save(@RequestBody Student student) {
        logger.info(student.toString());
        return repo.save(student);
    }
}


