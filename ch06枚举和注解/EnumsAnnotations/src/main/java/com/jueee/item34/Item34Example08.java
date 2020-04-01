package com.jueee.item34;

public class Item34Example08 {

    // Enum that switches on its value to share code - questionable
    enum PayrollDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
        SATURDAY, SUNDAY;

        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minutesWorked, int payRate) {
            int basePay = minutesWorked * payRate;

            int overtimePay;
            switch(this) {
              case SATURDAY: case SUNDAY: // Weekend
                overtimePay = basePay / 2;
                break;
              default: // Weekday
                overtimePay = minutesWorked <= MINS_PER_SHIFT ?
                  0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
            }
            return basePay + overtimePay;
        }
    }

}
