package amb.poc.excelwork.controller;

import amb.poc.excelwork.entity.Student;
import amb.poc.excelwork.repo.StudentRepo;
import amb.poc.excelwork.service.MyService;
import lombok.extern.log4j.Log4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/student")
public class RestControlller {

    private Logger logger = LoggerFactory.getLogger(RestControlller.class);
    @Autowired
    private StudentRepo repo;

    @Autowired
    private MyService myService;

    @GetMapping("/")
    public List<Student> test() {

        return repo.findAll();
    }

    @PostMapping("/new")
    public Student save(@RequestBody Student student) {
        logger.info(student.toString());
        return repo.save(student);
    }

    @PostMapping(path = "/processFile")
    public List<Student> processFile(@RequestParam("file") MultipartFile file) throws IOException, Exception {
//        FileInputStream files = new FileInputStream(new File(file));
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet sheet = workbook.getSheetAt(0);
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            XSSFRow row = sheet.getRow(i);
            if (i == 0)
                continue;
            Student s = new Student.StudentBuilder()
                    .firstName(row.getCell(0).toString())
                    .lastName(row.getCell(1).toString())
                    .city(row.getCell(2).toString())
                    .dob(myService.getDate(row.getCell(3).toString()))
                    .build();
            list.add(s);
            System.out.println(row.getCell(0));
            System.out.println(row.getCell(1));
            System.out.println(row.getCell(2));
            System.out.println(row.getCell(3));
        }
        System.out.println(file.getClass().getSimpleName());

        return repo.saveAll(list);
    }
}


