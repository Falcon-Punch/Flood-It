/*******************************************************************
 File name:		GameOverActivity.java
 Author:     	Joseph Schell
 Date:			  01/16/2018
 Assignment: 	Flood-It
 Purpose:    	Game Over activity class used to handle the end of each
              game played by the user.
 ******************************************************************/
package edu.pacificu.cs.sche5694floodit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity
{
  /**
   * Handles actions once the game over activity is created
   *
   * @return none
   */
  @Override
  protected void onCreate (Bundle savedInstanceState)
  {
    super.onCreate (savedInstanceState);
    setContentView (R.layout.activity_game_over);

    Intent intent = getIntent ();
    boolean isWon = intent.getBooleanExtra
      (MainActivity.GAME_WON, false);

    TextView gameOverText = (TextView) findViewById
      (R.id.gameOverText);

    if (isWon)
    {
      String winNumSteps = intent.getStringExtra
        (MainActivity.WIN_NUM_MOVES);
      gameOverText.setText (String.format
        (getString(R.string.sYouWon), winNumSteps));
    }
    else
    {
      gameOverText.setText (R.string.sYouLose);
    }

    ((Button) findViewById (R.id.btnRetry)).setOnClickListener
      (new View.OnClickListener ()
    {
      @Override
      public void onClick (View v)
      {
        startActivity (new Intent
          (v.getContext (), MainActivity.class));
      }
    });

    ((Button) findViewById(R.id.btnMainMenu)).setOnClickListener
      (new View.OnClickListener ()
    {
      @Override
      public void onClick (View v)
      {
        startActivity (new Intent (v.getContext (),
          MainPageActivity.class));
      }
    });
  }
}
