package com.example.contactstestproject.utils;

import android.content.Context;

/*
in order to call context less in different classes of app
 */

public class ApplicationUtils {
    private static Context sContext;

    public static Context getContext() {
        return sContext;
    }

    public static void setContext(Context Context) {
        sContext = Context;
    }
}
