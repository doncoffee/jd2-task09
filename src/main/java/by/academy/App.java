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
        EntityManager entityManager = HibernateUtil.getEntityManager();

        DAO<Administrator> adminDAO = new AdministratorDAOImpl();
        DAO<Assignment> assignmentDAO = new AssignmentDAOImpl();
        DAO<Course> courseDAO = new CourseDAOImpl();
        DAO<Student> studentDAO = new StudentDAOImpl();
        DAO<Teacher> teacherDAO = new TeacherDAOImpl();

        Administrator administrator = Administrator.builder()
                .id(null)
                .courses(null)
                .teachers(null)
                .build();
        Student student = Student.builder()
                .id(null)
                .courses(null)
                .assignments(null)
                .build();
        Teacher teacher = Teacher.builder()
                .id(null)
                .administrator(administrator)
                .courses(null)
                .build();
        Assignment assignment = Assignment.builder()
                .id(null)
                .mark(10)
                .review("Excellent job")
                .students(null)
                .build();
        Course course = Course.builder()
                .id(null)
                .teacher(teacher)
                .administrator(administrator)
                .students(null)
                .build();
        Administrator administrator1 = new Administrator(null, null, null);
        Student student1 = new Student(null, null, null);
        Teacher teacher1 = new Teacher(null, administrator1, null);
        Assignment assignment1 = new Assignment(null, 8, "good", null);
        Course course1 = new Course(null, teacher1, administrator1, null);

        Set<Course> courses = new HashSet<>();
        Set<Teacher> teachers = new HashSet<>();
        Set<Assignment> assignments = new HashSet<>();
        Set<Student> students = new HashSet<>();
        courses.add(course);
        courses.add(course1);
        administrator.setCourses(courses);
        administrator1.setCourses(courses);
        student.setCourses(courses);
        student1.setCourses(courses);
        teacher.setCourses(courses);
        teacher1.setCourses(courses);

        teachers.add(teacher);
        teachers.add(teacher1);
        administrator.setTeachers(teachers);
        administrator1.setTeachers(teachers);

        assignments.add(assignment);
        assignments.add(assignment1);
        student.setAssignments(assignments);
        student1.setAssignments(assignments);

        students.add(student);
        students.add(student1);
        assignment.setStudents(students);
        assignment1.setStudents(students);
        course.setStudents(students);
        course1.setStudents(students);

//        // create
//        adminDAO.create(administrator);
//        adminDAO.create(administrator1);
//        assignmentDAO.create(assignment);
//        assignmentDAO.create(assignment1);
//        courseDAO.create(course);
//        courseDAO.create(course1);
//        studentDAO.create(student);
//        studentDAO.create(student1);
//        teacherDAO.create(teacher);
//        teacherDAO.create(teacher1);
//
//        // read
//        System.out.println(adminDAO.read());
//        System.out.println(assignmentDAO.read());
//        System.out.println(courseDAO.read());
//        System.out.println(studentDAO.read());
//        System.out.println(teacherDAO.read());
//
//        // update
//        assignmentDAO.update(new Assignment(2, 3, "bad", students));
//
//        // delete
//        assignmentDAO.create(new Assignment(3, null, null, null));
//        assignmentDAO.delete(3);

        entityManager.getTransaction().begin();
        entityManager.persist(administrator);
        entityManager.persist(administrator1);
        entityManager.persist(assignment);
        entityManager.persist(assignment1);
        entityManager.persist(course);
        entityManager.persist(course1);
        entityManager.persist(student);
        entityManager.persist(student1);
        entityManager.persist(teacher);
        entityManager.persist(teacher1);
        entityManager.getTransaction().commit();

        HibernateUtil.close();
    }
}
