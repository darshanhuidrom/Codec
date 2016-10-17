package com.regalix.android.codec;

/**
 * Created by DARSHAN HUIDROJM on 10/13/2016.
 */
public class Constant {
    public static final int DEFAULT_PIN=7777;
    public static final String PASSWORD="password";
    public static final String IS_INSTALLED_FIRST= "is_installed_first";
    public static final String NO_OF_ATTEMPTS= "no_of_attemps";
    public static final long  MILLSEC_TO_MIN_FACTOR= 60000;
    public static final String  IS_TIMER_SET= "is_timer_set";
    public static final String  THRESHOLD_TIME= "threshold_time";
    public static final long  DELAY_TIME= 5;



    public static long getCurrentTime(){
        return System.currentTimeMillis();
    }

    public static void killApp(){
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
