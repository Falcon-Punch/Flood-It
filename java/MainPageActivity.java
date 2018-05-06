/*********************************************************************
 File name:		MainActivity.java
 Author:     	Joseph Schell
 Date:		  	01/16/2018
 Assignment: 	Flood-It
 Purpose:    	Implements Main Page for Flood-It game
 ********************************************************************/
package edu.pacificu.cs.sche5694floodit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPageActivity extends AppCompatActivity
{
  /**
   * Handles actions once the main activity is created
   *
   * @return none
   */
  @Override
  protected void onCreate (Bundle savedInstanceState)
  {
    super.onCreate (savedInstanceState);
    setContentView (R.layout.activity_main_page);

    ((Button) findViewById (R.id.btnPlay)).setOnClickListener
      (new View.OnClickListener ()
    {
      @Override
      public void onClick (View view)
      {
        playGame ();
      }
    });

    ((Button) findViewById(R.id.btnSettings)).setOnClickListener
      (new View.OnClickListener()
    {
      @Override
      public void onClick (View view)
      {
        startSettings ();
      }
    });
  }

  /**
   * Starts a new game activity
   *
   * @return none
   */
  public void playGame ()
  {
    startActivity(new Intent(this, MainActivity.class));
  }

  /**
   * Starts a new settings menu activity
   *
   * @return none
   */
  public void startSettings ()
  {
    startActivity(new Intent(this, SettingsActivity.class));
  }
}
