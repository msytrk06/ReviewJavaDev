package com.cybertek.streams.exercises;

import com.cybertek.enums.Status;
import com.cybertek.oop.encapsulation.User;
import com.cybertek.oop.inheritance.Project;

import java.time.Duration;
import java.time.Period;
import java.util.List;

import static com.cybertek.streams.exercises.DataGenerator.*;

public class TestEx {

    public static void main(String[] args) {
        System.out.println("********* TASK 1 *************");
        List<Project> allProjects = StreamDemo.getListOfProject();
        allProjects.forEach(a-> System.out.println(a.getProjectName()));

        System.out.println("********* TASK 2 *************");
        List<Project> ByStatus = StreamDemo.getListOfProject(Status.OPEN);
        ByStatus.forEach(a-> System.out.println(a.getProjectName()));

        System.out.println("********* TASK 3 *************");
        User manager=getManagers().get(0);
        List<Project> ByManager = StreamDemo.getListOfProject(manager);
        ByManager.forEach(a-> System.out.println(a.getProjectName()));


        System.out.println("********* TASK 4 *************");
        List<Project> ByProjectCode = StreamDemo.getProjectByProjectCode("PRJ005");
        ByProjectCode.forEach(a-> System.out.println(a.getProjectName()));

        System.out.println("********* TASK 5 *************");
        List<User> allUsers = StreamDemo.getListUsers();
        allUsers.forEach(a-> System.out.println(a.getFirstName()+" "+a.getLastName()));

        System.out.println("********* TASK 6 *************");
        User user = StreamDemo.getUserByFirstName("Joseph");
        System.out.println(user.getFirstName()+" "+user.getLastName());

        System.out.println("********* TASK 7 *************");
        System.out.println(StreamDemo.getUserByUserId(12l));

        System.out.println("********* TASK 8 *************");
        List<User> lastVersion=StreamDemo.deleteUser("Sarah");
        lastVersion.forEach(x-> System.out.println(x.getId()+" "+x.getFirstName()));

        System.out.println("********* TASK 9 *************");
        List<Project> updateStatus = StreamDemo.updateProjectStatus(Status.IN_PROGRESS,Status.OPEN);
        updateStatus.forEach(a-> System.out.println(a.getProjectStatus()));

        System.out.println("********* TASK 10 *************");
        User managers=getManagers().get(0);
        List<Project> ByManagers = StreamDemo.getListOfProject(manager);
        ByManagers.forEach(a-> System.out.println(a.getProjectName()));

        System.out.println("********* TASK 11 *************");
        // Ex : how to find hours difference
        int a =project4.getLastUpdateDateTime().getHour()-project4.getInsertDateTime().getHour();
        System.out.println(a);
        // Ex : How can use Period
        Period v=Period.between(project4.getLastUpdateDateTime().toLocalDate(),
                project4.getInsertDateTime().toLocalDate());
        System.out.println("v.getDays() = " + v.getDays());
        // Ex : How can use Duration
        Duration d= Duration.between(project4.getInsertDateTime(), project4.getLastUpdateDateTime());
        System.out.println("v.getDays() = " + d.toHours());
        // Task solution
        System.out.println("StreamDemo.totalProjectDurationForManager(manager) = " + StreamDemo.totalProjectDurationForManager(manager));

        System.out.println("********* TASK 12 *************");
        System.out.println(StreamDemo.findTotalMaleInCompany());

    }
}
