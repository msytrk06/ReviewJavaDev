package com.cybertek.streams.exercises;

import com.cybertek.enums.Gender;
import com.cybertek.enums.Status;
import com.cybertek.oop.encapsulation.User;
import com.cybertek.oop.inheritance.Project;

import java.time.Duration;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import static com.cybertek.streams.exercises.DataGenerator.getProjects;
import static com.cybertek.streams.exercises.DataGenerator.getUsers;

public class StreamDemo {



    //Task-1
    public static  List<Project> getListOfProject(){

    return getProjects();

    }


    //Task-2
    public static List<Project> getListOfProject(Status status){

        List<Project> filterByStatus = getProjects().stream().
                                                filter
                                                        (x->x.getProjectStatus().
                                                                equals(status)).
                                                collect(Collectors.toList());

        return filterByStatus;

    }

    //Task-3
    public static List<Project> getListOfProject(User manager){
        List<Project> filterByManager=getProjects().stream().
                                                filter
                                                        (x->x.getAssignedManager().
                                                                equals(manager)).
                                                collect(Collectors.toList());
        return filterByManager;
    }


    //Task-4
    public static List<Project> getProjectByProjectCode(String projectCode){

        List<Project> filterByProjectCode=getProjects().stream().
                                            filter
                                                    (x->x.getProjectCode().
                                                            equals(projectCode)).
                                            collect(Collectors.toList());

        return filterByProjectCode;

    }


   // Task-5
    public static List<User> getListUsers(){

        return getUsers();

    }

    //Task-6
    public static User getUserByFirstName(String firstName){

        return getUsers().stream().
                            filter(x->x.getFirstName().equals(firstName))
                            .findAny().get();

    }


    //Task-7
    public static String getUserByUserId(long id){

         User user = getUsers().stream().
                                filter(x->x.getId()==id)
                                .findFirst().get();
         return user.getFirstName()+" "+user.getLastName();

    }


    //Task-8
    public static List<User> deleteUser(String firstName){
        User searchedUser=getUsers().stream().
                            filter(x->x.getFirstName().
                                        equals(firstName)).findFirst().get();

        List<User> allUser=getUsers();
        allUser.remove(searchedUser);
        return  allUser;
    }


    //Task-9
    public static List<Project> updateProjectStatus(Status oldStatus,Status newStatus){

        List<Project> statusUpdated=getProjects();
        statusUpdated.stream().filter(x->x.getProjectStatus().equals(oldStatus))
                        .forEach(x->x.setProjectStatus(newStatus));



        return   statusUpdated;

    }


    //Task-10
    public static List<Project> findProjectByManager(User manager){

        List<Project> filterByManager=getProjects().stream().
                filter
                        (x->x.getAssignedManager().
                                equals(manager)).
                collect(Collectors.toList());
        return filterByManager;

    }


    //Task-11 - Duration
    public static long totalProjectDurationForManager(User manager){

       return getProjects().stream().
                filter
                        (x->x.getAssignedManager().
                                equals(manager)).
                map
                    (x -> Duration.between(x.getInsertDateTime().toLocalTime(),
                        x.getLastUpdateDateTime().toLocalTime()).toHours()).


                reduce( 0l,(x, y)->x+y);

    }


    //Task-12
    public static long findTotalMaleInCompany(){

        long  maleUsers=getUsers().stream().filter(x->x.getGender().equals(Gender.MALE)).count();
        return maleUsers;
    }





}
