/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper.date;

import data.model.common.Date;
import java.time.LocalDate;

/**
 *
 * @author shreyajaiswal
 */
public abstract class localdateToDate {
    public static Date localToDate(LocalDate date) {
        int month = date.getDayOfMonth();
        int year = date.getYear();
        int day = date.getDayOfMonth();
        Date d = new Date(month, day, year);
        return d;
    }
}
