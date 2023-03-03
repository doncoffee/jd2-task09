package by.academy;

import by.academy.dao.DAO;
import by.academy.dao.impl.*;
import by.academy.entity.*;
import by.academy.util.HibernateUtil;
import jakarta.persistence.EntityManager;

import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {
//        EntityManager entityManager = HibernateUtil.getEntityManager();

        DAO<Administrator> adminDAO = new AdministratorDAOImpl();
        DAO<Assignment> assignmentDAO = new AssignmentDAOImpl();
        DAO<Course> courseDAO = new CourseDAOImpl();
        DAO<Student> studentDAO = new StudentDAOImpl();
        DAO<Teacher> teacherDAO = new TeacherDAOImpl();

        // create entities
        Administrator administrator = Administrator.builder()
                .courses(null)
                .teachers(null)
                .build();
        Student student = Student.builder()
                .courses(null)
                .assignments(null)
                .build();
        Teacher teacher = Teacher.builder()
                .administrator(administrator)
                .build();
        Assignment assignment = Assignment.builder()
                .mark(10)
                .review("Excellent job")
                .build();
        Course course = Course.builder()
                .administrator(administrator)
                .build();
        Administrator administrator1 = new Administrator(null, null, null);
        Student student1 = new Student(null, null, null);
        Teacher teacher1 = new Teacher(null, administrator1);
        Assignment assignment1 = new Assignment(null, 8, "good");
        Course course1 = new Course(null, administrator1);

        // fulfil collections and create some objects
        Set<Course> courses = new HashSet<>();
        Set<Teacher> teachers = new HashSet<>();
        Set<Assignment> assignments = new HashSet<>();
        adminDAO.create(administrator);
        adminDAO.create(administrator1);

        courseDAO.create(course);
        courseDAO.create(course1);
        courses.add(course);
        courses.add(course1);
        administrator.setCourses(courses);
        administrator1.setCourses(courses);
        student.setCourses(courses);
        student1.setCourses(courses);

        teachers.add(teacher);
        teachers.add(teacher1);
        administrator.setTeachers(teachers);
        administrator1.setTeachers(teachers);

        assignmentDAO.create(assignment);
        assignmentDAO.create(assignment1);
        assignments.add(assignment);
        assignments.add(assignment1);
        student.setAssignments(assignments);
        student1.setAssignments(assignments);

        // create
        studentDAO.create(student);
        studentDAO.create(student1);
        teacherDAO.create(teacher);
        teacherDAO.create(teacher1);

        // read
        System.out.println(adminDAO.read());
        System.out.println(assignmentDAO.read());
        System.out.println(courseDAO.read());
        System.out.println(studentDAO.read());
        System.out.println(teacherDAO.read());
        System.out.println(assignmentDAO.selectById(3));

        // update
        assignmentDAO.update(new Assignment(2, 3, "bad"));

//        // delete
//        studentDAO.delete(1);
//        studentDAO.delete(2);
//        assignmentDAO.delete(1);

//        entityManager.getTransaction().begin();
//        entityManager.persist(administrator);
//        entityManager.persist(administrator1);
//        entityManager.persist(assignment);
//        entityManager.persist(assignment1);
//        entityManager.persist(course);
//        entityManager.persist(course1);
//        entityManager.persist(student);
//        entityManager.persist(student1);
//        entityManager.persist(teacher);
//        entityManager.persist(teacher1);
//        entityManager.getTransaction().commit();
//
//        HibernateUtil.close();
    }
}
