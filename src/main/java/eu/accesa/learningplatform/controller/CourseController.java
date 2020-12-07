package eu.accesa.learningplatform.controller;

import eu.accesa.learningplatform.model.dto.CourseDto;
import eu.accesa.learningplatform.service.CourseService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/courses")
@OpenAPIDefinition
@Tag(name = "Courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    @ApiResponse(responseCode = "201", description = "Successfully created a course")
    public ResponseEntity<CourseDto> createNewCourse(@Valid @RequestBody CourseDto courseDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addNewCourse(courseDto));
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved a course by ID")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getCourseById(id));
    }

    @GetMapping("/name/{name}")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved a course containing by name")
    public ResponseEntity<List<CourseDto>> getCourseByNameContainingKeyword(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getCoursesByNameContainingKeyword(name));
    }

    @GetMapping("/trainer/{id}")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved all courses from a trainer")
    public ResponseEntity<List<CourseDto>> getCoursesByTrainer(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getCoursesByTrainer(id));
    }

    @PutMapping
    @ApiResponse(responseCode = "200", description = "Successfully updated a course")
    public ResponseEntity<CourseDto> updateCourse(@Valid @RequestBody CourseDto programDto) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.updateCourse(programDto));
    }


    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Successfully deleted a program by id")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourseById(id);
    }
}
