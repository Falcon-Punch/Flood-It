/*******************************************************************
 File name:		SettingActivity.java
 Author:     	Joseph Schell
 Date:		  	01/16/2018
 Assignment: 	Flood-It
 Purpose:    	Settings activity class used to handle the settings
 menu and components
 ******************************************************************/
package edu.pacificu.cs.sche5694floodit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SettingsActivity extends AppCompatActivity
{
  Spinner mLevelMenu;

  /**
   * Handles actions once the settings activity is created
   *
   * @return none
   */
  @Override
  protected void onCreate (Bundle savedInstanceState)
  {
    super.onCreate (savedInstanceState);
    setContentView (R.layout.activity_settings);

    setLevelMenu ();

    ((Button) findViewById (R.id.btnSave)).setOnClickListener
      (new View.OnClickListener ()
    {
      @Override
      public void onClick (View v)
      {
        finish();
      }
    });
  }

  /**
   * Sets spinner menu for difficulty level selection by user.
   *
   * @return none
   */
  private void setLevelMenu ()
  {
    mLevelMenu = (Spinner) findViewById(R.id.levelSpinner);
    ArrayAdapter<CharSequence> adapter =
      ArrayAdapter.createFromResource (this,
      R.array.sLevelsArr, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource
      (android.R.layout.simple_spinner_dropdown_item);
    mLevelMenu.setAdapter (adapter);

    mLevelMenu.setOnItemSelectedListener
      (new AdapterView.OnItemSelectedListener()
    {
      @Override
      public void onItemSelected
        (AdapterView<?> parent, View view, int position, long id)
      {
        setLevel ((String) parent.getItemAtPosition (position)
        );
      }

      @Override
      public void onNothingSelected (AdapterView<?> parent)
      {
        // required, produces error if taken out.
      }
    });
  }

  /**
   * Sets level of difficulty for the game
   *
   * @param levelChoice: numerical value to depict difficulty setting
   * @return none
   */
  private void setLevel (String levelChoice)
  {
    switch (levelChoice)
    {
      case "Select Level":
        Difficulty.getValue ().setLevel (Level.DEFAULT);
        break;
      case "Easy":
        Difficulty.getValue ().setLevel (Level.EASY);
        break;
      case "Medium":
        Difficulty.getValue ().setLevel (Level.MEDIUM);
        break;
      case "Hard":
        Difficulty.getValue ().setLevel (Level.HARD);
        break;
      default:
        break;
    }
  }
}
