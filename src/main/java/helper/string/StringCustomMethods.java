package helper.string;

import data.model.common.Date;

public abstract class StringCustomMethods {
    public static Date stringToDate(String date) {
        String[] dateSplit = date.split("-");
        int year = Integer.parseInt(dateSplit[0]);
        int month = Integer.parseInt(dateSplit[1]);
        int day = Integer.parseInt(dateSplit[2]);
        
        Date output = new Date(month, day, year);
        return output;
    }
}
