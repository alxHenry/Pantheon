package com.alexdhenry.pantheon;

import com.alexdhenry.pantheon.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

//The main menu for our app
public class MainActivity extends Activity implements OnClickListener{

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      
      //click listeners for all the buttons
      View mapButton = findViewById(R.id.lists_button);
      mapButton.setOnClickListener(this);
  }
  
  //This decides the action the app takes when one of the buttons is pressed. It 
  //determines which button was pressed and then lunches the appropriate activity.
  public void onClick(View v){
  	switch (v.getId()) {
      case R.id.lists_button:
  		Intent DisplayLists = new Intent(this, DisplayLists.class);
  		startActivity(DisplayLists);
        break;
  	}
  }
} 
