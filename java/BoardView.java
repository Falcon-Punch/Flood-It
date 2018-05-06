/*******************************************************************
 File name:		BoardView.java
 Author:     	Joseph Schell
 Date:		  	01/16/2018
 Assignment: 	Flood-It
 Purpose:    	Implements view object of the game board into the UI
 ******************************************************************/
package edu.pacificu.cs.sche5694floodit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;

public class BoardView extends View
{
  private ShapeDrawable[][] mcDrawable;
  private Cell[][] mcBoard;
  private int mBoardSize;
  private int mCellSize;

  /**
   * Constructor
   */
  public BoardView (Context context)
  {
    super(context);
  }

  /**
   * Constructor
   */
  public BoardView (Context context, AttributeSet attribute)
  {
    super(context, attribute);
  }

  /**
   * Sets the size of the board
   *
   * @param boardSize: integer that determines board size
   * @return none
   */
  public void setBoardSize (int boardSize)
  {
    this.mBoardSize = boardSize;
    mcDrawable = new ShapeDrawable[boardSize][boardSize];
  }

  /**
   * Sets the size of the cells
   *
   * @param cellSize: integer that determines cell size
   * @return none
   */
  public void setCellSize (int cellSize)
  {
    this.mCellSize = cellSize;
  }

  /**
   * Resets the board view
   *
   * @param board: integer that determines cell size
   * @return none
   */
  public void resetView(Cell[][] board)
  {
    for (int i = 0; i < mBoardSize; ++i)
    {
      for (int j = 0; j < mBoardSize; ++j)
      {
        Cell newCell = board[i][j];
      }
    }

    this.mcBoard = board;
    postInvalidate ();
  }

  /**
   * Measures the size of the Board
   *
   * @param widthMeasureSpec: int with width measurement
   * @param heightMeasureSpec: int with height measurement
   * @return none
   */
  @Override
  protected void onMeasure (int widthMeasureSpec,
                            int heightMeasureSpec)
  {
    if (0 == widthMeasureSpec || 0 == heightMeasureSpec)
    {
      super.onMeasure (widthMeasureSpec, heightMeasureSpec);
    }
    int size = Math.max (widthMeasureSpec, heightMeasureSpec);
    super.onMeasure (size, size);
  }

  /**
   * Draws the board view on the UI canvas
   *
   * @param canvas: Canvas to be drawn on
   * @return none
   */
  @Override
  protected void onDraw (Canvas canvas)
  {
    for (int i = 0; i < mBoardSize; ++i)
    {
      int x = 0;
      int y = mCellSize * i;
      int bottomBound = mCellSize * (i + 1);
      for (int j = 0; j < mBoardSize; ++j)
      {
        mcDrawable[i][j] = new ShapeDrawable();
        mcDrawable[i][j].getPaint().setColor
          (mcBoard[i][j].getColor());
        mcDrawable[i][j].setBounds(x + mCellSize * j, y,
          mCellSize * (j + 1), bottomBound);
        mcDrawable[i][j].draw(canvas);
      }
    }
  }
}
