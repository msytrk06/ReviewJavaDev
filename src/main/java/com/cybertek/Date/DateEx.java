package com.cybertek.Date;

import java.time.*;

public class DateEx {
    public static void main(String[] args) {

        System.out.println("*****LOCALDATE*****");
        LocalDate l=LocalDate.now();
        System.out.println(l.getDayOfMonth());
        System.out.println(l.getDayOfWeek());
        System.out.println(l.getDayOfYear());
        System.out.println(l.getChronology());
        System.out.println(l.plusMonths(1));

        System.out.println("*****LOCALTIME*****");
        LocalTime lt=LocalTime.now();
        System.out.println(lt.getHour());
        System.out.println(lt.getMinute());


        System.out.println("*****LOCALDATETIME*****");
        LocalDateTime ldt=LocalDateTime.now();
        System.out.println(ldt.getDayOfYear());
        System.out.println(ldt.getSecond());


        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.now()));


        System.out.println("*****PERIOD*****");

        LocalDate birt=LocalDate.of(2014, Month.DECEMBER,5);
        LocalDate now=LocalDate.now();

        Period p = Period.between(birt,now);

        System.out.println(p.getDays()+" "+p.getYears());

        System.out.println("*****ZONEID*****");

        ZoneId z=ZoneId.systemDefault();
        System.out.println(z);

        ZoneId zone=ZoneId.of("America/New_York");
        LocalTime tm=LocalTime.now(zone);
        System.out.println("tm = " + tm);


    }
}
