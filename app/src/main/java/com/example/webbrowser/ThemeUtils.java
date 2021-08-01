package com.example.webbrowser;

import android.app.Activity;
import android.content.Intent;

public class ThemeUtils {
    private static int cTheme;
    public static final int NORMAL = 0;
    public static final int HOT = 1;

    public static void changeTheme(Activity activity,int theme)
    {
        cTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity,activity.getClass()));
    }
    public static void onCreateTheme(Activity activity)
    {
        switch (cTheme)
        {
            case NORMAL:
                activity.setTheme(R.style.normalTheme);
                break;
            case HOT:
                activity.setTheme(R.style.hotTheme);
                break;
        }
    }
}
