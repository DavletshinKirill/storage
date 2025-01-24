package dev.telegrambot.storage.service.impl;

import dev.telegrambot.storage.CourseNotFoundException;
import dev.telegrambot.storage.domain.course.Course;
import dev.telegrambot.storage.repository.CourseRepository;
import dev.telegrambot.storage.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Course getCourse(String courseName) {
        return courseRepository.findByName(courseName).orElseThrow(
                () -> new CourseNotFoundException(String.format("Course with name %s not found", courseName))
        );
    }
}
