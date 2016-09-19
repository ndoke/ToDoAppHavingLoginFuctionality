/**
 * Ajay Vijayakumaran Nair
 * Ayang
 * Nachiket Doke
 */
package com.example.inclass08;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends Activity {

	public static final String LOGGING_KEY = "inc8";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		// getActionBar().setTitle("Login");
		if(ParseUser.getCurrentUser() != null){
			Intent intent = new Intent(LoginActivity.this, ToDoActivity.class);
			startActivity(intent);
			finish();
		}

	}

	public void signUpClicked(View view) {
		Intent intent = new Intent(LoginActivity.this, SignUp.class);
		startActivity(intent);
		finish();
	}

	public void loginClicked(View view) {
		String email = ((EditText) findViewById(R.id.editTextEmail)).getText().toString();
		String pass = ((EditText) findViewById(R.id.editTextPassword)).getText().toString();
		if (email == null || email.isEmpty() || pass ==null || pass.isEmpty()) {
			Toast.makeText(this, "Mandatory login fields cant be empty", Toast.LENGTH_LONG).show();
			return;

		}
		logUserIn(email, pass);
		
	}

	private void logUserIn(String email, String pass) {
		ParseUser.logInInBackground(email, pass, new LogInCallback() {
			public void done(ParseUser user, ParseException e) {
				if (user != null) {
					Log.d(LoginActivity.LOGGING_KEY, "User logged in");
					Intent intent = new Intent(LoginActivity.this, ToDoActivity.class);
					startActivity(intent);
					finish();
				} else {
					Log.d(LoginActivity.LOGGING_KEY, "User couldnt b logged in");
					if (e.getCode() == ParseException.OBJECT_NOT_FOUND) {
						Toast.makeText(LoginActivity.this, "Dint find given user in server", Toast.LENGTH_LONG).show();
					}
				}
			}
		});
	}
}
