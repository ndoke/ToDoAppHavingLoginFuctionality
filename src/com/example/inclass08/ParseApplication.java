/**
 * Ajay Vijayakumaran Nair
 * Ayang
 * Nachiket Doke
 */
package com.example.inclass08;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;

public class ParseApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // Initialize Crash Reporting.
    //ParseCrashReporting.enable(this);

    // Enable Local Datastore.
    //Parse.enableLocalDatastore(this);

    // Add your initialization code here
    Parse.initialize(this, "F7eVmsQtZ8GLIqBFCWxJ0qAXpNHzUh0riVvivSAG", "2PzvHf5I1HyHlv5EyLaCW6vzRYZZ5GYXl4Bl1ej4");

    //ParseUser.enableAutomaticUser();
    ParseACL defaultACL = new ParseACL();
    // Optionally enable public read access.
    // defaultACL.setPublicReadAccess(true);
    //ParseUser.getCurrentUser().saveInBackground();
    ParseACL.setDefaultACL(defaultACL, true);
  }
}
