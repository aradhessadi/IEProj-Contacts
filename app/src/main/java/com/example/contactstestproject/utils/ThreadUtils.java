package com.example.contactstestproject.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtils {
    public static ExecutorService dataBaseWriteExecutor = Executors.newSingleThreadExecutor();
}
