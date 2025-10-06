package io.github.vfedoriv.javaoutput3.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentSubjectService {
    private Map<Long, List<String>> studentSubjects = new HashMap<>();
    private Map<String, Boolean> subjectRegistry = new HashMap<>();

    public String addSubject(Long studentId, String subject) {
        if (subject == null || subject.trim().isEmpty()) {
            return "Subject cannot be empty.";
        }
        if (subjectRegistry.containsKey(subject)) {
            return "Subject already exists.";
        }
        subjectRegistry.put(subject, true);
        studentSubjects.computeIfAbsent(studentId, k -> new ArrayList<>()).add(subject);
        return "Subject added successfully.";
    }

    public List<String> viewSubjects(Long studentId) {
        return studentSubjects.getOrDefault(studentId, new ArrayList<>());
    }

    public String updateSubject(Long studentId, String oldSubject, String newSubject) {
        if (newSubject == null || newSubject.trim().isEmpty()) {
            return "New subject cannot be empty.";
        }
        if (!studentSubjects.containsKey(studentId) || !studentSubjects.get(studentId).contains(oldSubject)) {
            return "Subject not found for the student.";
        }
        if (subjectRegistry.containsKey(newSubject)) {
            return "New subject already exists.";
        }
        studentSubjects.get(studentId).remove(oldSubject);
        studentSubjects.get(studentId).add(newSubject);
        subjectRegistry.remove(oldSubject);
        subjectRegistry.put(newSubject, true);
        return "Subject updated successfully.";
    }

    public String deleteSubject(Long studentId, String subject) {
        if (!studentSubjects.containsKey(studentId) || !studentSubjects.get(studentId).remove(subject)) {
            return "Subject not found for the student.";
        }
        subjectRegistry.remove(subject);
        return "Subject deleted successfully.";
    }
}