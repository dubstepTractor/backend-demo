package com.example.demo;

        import com.example.demo.models.AcademicDegree;
        import com.example.demo.repos.AcademicDegreeRepo;
        import com.example.demo.services.AcademicDegreeService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

        import javax.sql.DataSource;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final AcademicDegreeService academicDegreeService;

    @Autowired
    public ApiController(AcademicDegreeService academicDegreeService){
        this.academicDegreeService = academicDegreeService;
    }
    @GetMapping
    public String greetName(@RequestParam("name") String name){
        return "Hello "+name+'!';
    }
    @GetMapping("/full")
    public String greetFull(@RequestParam("name") String name, @RequestParam("surname") String surname){
        return "{ name: "+ name+",surname: "+surname+"}";
    }
//    @GetMapping("/degree")
//    public ResponseEntity<String> apiDegree(@RequestParam("id") Integer id){
//       List<AcademicDegree> ids = academicDegreeService.getAll();
//       return new ResponseEntity<>(ids, HttpStatus.OK);
//    }
    @GetMapping("/academic-degrees")
    public ResponseEntity<List<AcademicDegree>> getAcademicDegrees() {
        List<AcademicDegree> academicDegrees = academicDegreeService.getAll();
        return new ResponseEntity<>(academicDegrees, HttpStatus.OK);
    }

}