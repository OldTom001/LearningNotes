package com.jeff;

import java.util.Timer;
import java.util.TimerTask;

//直接实现定时任务
public class TimerTaskApp {
    public static void main(String[] args) {
        Timer timer = new Timer();
        int a = 1;
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时任务执行...");
            }
        };
        timer.schedule(task, 0, 2000);
    }
}
