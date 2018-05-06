/*********************************************************************
 File name:		MainActivity.java
 Author:     	Joseph Schell
 Date:			  01/16/2018
 Assignment: 	Flood-It
 Purpose:    	Implements Flood-It game
 ********************************************************************/
package edu.pacificu.cs.sche5694floodit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity
{
  private TextView mMovesText;
  private BoardView mcBoardView;
  private Level mLevel;
  private Board mcBoard;
  private HashMap <Level, Integer>
    mChangeLevelToSize = new HashMap<>();
  private HashMap <Level, Integer>
    mChangelevelToNumMoves = new HashMap<>();
  private int mNumRows;
  private int mNumMoves;
  private int mInitNumMoves;
  protected static final String WIN_NUM_MOVES =
    "edu.pacificu.cs.sche5694floodit.WIN_NUM_MOVES";
  protected static final String GAME_WON =
    "edu.pacificu.cs.sche5694floodit.GAME_WON";

  /**
   * Handles actions once the main activity is created
   *
   * @return none
   */
  @Override
  protected void onCreate (Bundle savedInstanceState)
  {
    super.onCreate (savedInstanceState);
    setContentView (R.layout.activity_main);

    mLevel = Difficulty.getValue ().getLevel ();

    ((Button) findViewById (R.id.backButton)).setOnClickListener
      (new View.OnClickListener ()
    {
      @Override
      public void onClick (View v)
      {
        Intent myIntent = new Intent
          (v.getContext(), MainPageActivity.class);
        startActivity (myIntent);
      }
    });

    setupGame ();
    resetGame ();
  }

  /**
   * Resets Game and reinitializes all components on the game board
   *
   * @return none
   */
  private void resetGame()
  {
    mInitNumMoves = mChangelevelToNumMoves.get (mLevel);
    mNumMoves = mInitNumMoves;
    mNumRows = mChangeLevelToSize.get (mLevel);
    mcBoard = new Board (mNumRows);

    mMovesText = ((TextView) findViewById(R.id.movesText));
    mMovesText.setText (String.format
      (getString (R.string.sMoves), mInitNumMoves, mInitNumMoves));

    mcBoardView = (BoardView) findViewById(R.id.board_view);

    mcBoardView.setOnTouchListener (new View.OnTouchListener ()
    {
      @Override
      public boolean onTouch (View v, MotionEvent event)
      {
        if (event.getAction () == MotionEvent.ACTION_DOWN)
        {
          int touchedX = (int) event.getX();
          int touchedY = (int) event.getY();
          updateGame (touchedX, touchedY);
        }
        return true;
      }
    });

    mcBoardView.post (new Runnable ()
    {
      @Override
      public void run ()
      {
        initializeBoard (mNumRows, mcBoardView.getWidth (),
          mcBoardView.getHeight ());
      }
    });

    resetBoardView ();
  }

  /**
   * Initializes all components on the game board
   *
   * @param numRows: number of rows to create
   * @param boardWidth: width of the board
   * @param boardHeight: height of the board
   *
   * @return none
   */
  private void initializeBoard (int numRows,
    int boardWidth, int boardHeight)
  {
    int cellSize = Math.min(boardWidth, boardHeight) / numRows;

    for (int i = 0; i < numRows; ++i)
    {
      int x = 0;
      int y = cellSize * i;
      for (int j = 0; j < numRows; ++j)
      {
        mcBoard.setXY(i, j, x + cellSize * j, y, cellSize);
      }
    }

    mcBoardView.setBoardSize (numRows);
    mcBoardView.setCellSize (cellSize);
  }

  /**
   * Updates current state of the game
   *
   * @param touchedX: X coord previously touched by user
   * @param touchedY: Y coord previously touched by user
   * @return none
   */
  private void updateGame (int touchedX, int touchedY)
  {
    boolean updated = updateBoard (touchedX, touchedY);

    if (updated)
    {
      updateMovesText ();
      resetBoardView ();
    }

    checkForWin (mcBoard.checkWon ());
  }

  /**
   * Updates current state of the game
   *
   * @param isFilled: if filled or not
   *
   * @return none
   */
  private void checkForWin (boolean isFilled)
  {
    if (0 <= mNumMoves && isFilled)
    {
      int stepsUsed = mInitNumMoves - mNumMoves;
      String winNumMoves = String.format
        ("%d/%d", stepsUsed, mInitNumMoves);

      Intent intent = new Intent
        (this, GameOverActivity.class);
      intent.putExtra (WIN_NUM_MOVES, winNumMoves);
      intent.putExtra (GAME_WON, true);
      startActivity (intent);

    }
    else if (0 == mNumMoves)
    {
      Intent intent = new Intent
        (this, GameOverActivity.class);
      intent.putExtra (GAME_WON, false);
      startActivity (intent);
    }
  }

  /**
   * Updates game board
   *
   * @param touchedX: X coord previously touched by user
   * @param touchedY: Y coord previously touched by user
   *
   * @return true is board updated, else false
   */
  private boolean updateBoard (int touchedX, int touchedY)
  {
    Cell clickedCell = mcBoard.getClickedCell (touchedX, touchedY);

    if (null != clickedCell)
    {
      return mcBoard.updateBoard (clickedCell.getColor ());
    }
    return false;
  }

  /**
   * Resets Board View
   *
   * @return none
   */
  private void resetBoardView ()
  {
    mcBoardView.resetView (mcBoard.getBoard ());
  }

  /**
   * Sets up the game based on difficulty level chosen
   *
   * @return none
   */
  private void setupGame ()
  {
    mChangeLevelToSize.put (Level.DEFAULT, 10);
    mChangeLevelToSize.put (Level.EASY, 10);
    mChangeLevelToSize.put (Level.MEDIUM, 12);
    mChangeLevelToSize.put (Level.HARD, 15);

    mChangelevelToNumMoves.put (Level.DEFAULT, 12);
    mChangelevelToNumMoves.put (Level.EASY, 12);
    mChangelevelToNumMoves.put (Level.MEDIUM, 20);
    mChangelevelToNumMoves.put (Level.HARD, 32);
  }

  /**
   * Updates text that shows user how many moves remain
   *
   * @return none
   */
  private void updateMovesText ()
  {
    mNumMoves -= 1;
    mMovesText.setText(String.format (getString (R.string.sMoves),
      mNumMoves, mInitNumMoves));
  }
}
