package dev.telegrambot.storage.service;

import dev.telegrambot.storage.domain.course.Course;

public interface CourseService {
    Course getCourse(String courseName);
}
