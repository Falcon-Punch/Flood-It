/*******************************************************************
 File name:		Board.java
 Author:     	Joseph Schell
 Date:        01/16/2018
 Assignment: 	Flood-It
 Purpose:    	Board class that implements organization of the game
              board
 ******************************************************************/
package edu.pacificu.cs.sche5694floodit;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.Random;

public class Board
{
  private Cell[][] mcBoard;
  private Random mcRandom = new Random ();
  private int mSize;
  private int mNumColors;
  private static final int seed = 0;
  private static final int ARGBColors = 7;

  /**
   * Constructor
    */
  public Board (int size)
  {
    this.mSize = size;
    createBoard();
  }

  /**
   * Initializes board and its components
   *
   * @return none
   */
  private void createBoard ()
  {
    mNumColors = mSize;
    mcBoard = new Cell [mSize][mSize];
    floodFill();
  }

  /**
   * Fills board with random colors
   *
   * @return none
   */
  private void floodFill ()
  {
    int colors [];
    int color1, color2, color3, color4, color5;
    ColorGenerator generator = new ColorGenerator (seed);
    ArrayList<Integer> randNums = new ArrayList<Integer> ();

    while (randNums.size () < ARGBColors)
    {
      int randomColor = mcRandom.nextInt (ARGBColors);
      if (!randNums.contains (randomColor))
      {
        randNums.add (randomColor);
      }
    }

    NewColor newColor1 = new NewColor(randNums.get(0));
    color1 = Color.parseColor (newColor1.getName());
    NewColor newColor2 = new NewColor(randNums.get(1));
    color2 = Color.parseColor (newColor2.getName());
    NewColor newColor3 = new NewColor(randNums.get(2));
    color3 = Color.parseColor (newColor3.getName());
    NewColor newColor4 = new NewColor(randNums.get(3));
    color4 = Color.parseColor (newColor4.getName());
    NewColor newColor5 = new NewColor(randNums.get(4));
    color5 = Color.parseColor (newColor5.getName());

    switch (mNumColors)
    {
      case 10:
        colors = new int[] {color1, color2, color3, color1, color2,
          color3, color1, color2, color3, color1};
        break;
      case 12:
        colors = new int[] {color1, color2, color3, color4, color1,
          color2, color3, color4, color1, color2, color3, color4};
        break;
      case 15:
        colors = new int[] {color1, color2, color3, color4, color5,
          color1, color2, color3, color4, color5, color1, color2,
          color3, color4, color5};
        break;
      default:
        colors = new int[] {color1, color2, color3, color1, color2,
          color3, color1, color2, color3, color1};
        break;
    }

    for (int row = 0; row < mcBoard.length; ++row)
    {
      for (int col = 0; col < mcBoard[row].length; ++col)
      {
        mcBoard[row][col] = new Cell ();
        int randomNum = mcRandom.nextInt (mNumColors);
        mcBoard[row][col].setColor (colors[randomNum]);
      }
    }
  }

  /**
   * Checks for a win condition
   *
   * @return none
   */
  public boolean checkWon()
  {
    for (int row = 0; row < mcBoard.length; ++row)
    {
      for (int col = 0; col < mcBoard[row].length; ++col)
      {
        if (mcBoard[0][0].getColor() != mcBoard[row][col].getColor ())
        {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Retrieves the location of a clicked cell.
   *
   * @param x: an x coordinate
   * @param y: a y coordinate
   * @return location of a click Cell
   */
  public Cell getClickedCell (int x, int y)
  {
    for (int row = 0; row < mSize; ++row)
    {
      for (int col = 0; col < mSize; ++col)
      {
        Cell cell = mcBoard[row][col];
        int left = cell.getX ();
        int right = left + cell.getSize ();
        int top = cell.getY ();
        int bottom = top + cell.getSize();
        if (x <= right && x >= left && y <= bottom && y >= top)
        {
          return cell;
        }
      }
    }
    return null;
  }

  /**
   * Updates colors on board
   *
   * @param newColor: new color to update board with
   * @return false if color is the same, true if color is new
   */
  public boolean updateBoard (int newColor)
  {
    int oldColor = mcBoard[0][0].getColor();
    if (newColor == oldColor)
    {
      return false;
    }

    updateBoard (oldColor, newColor, 0, 0);
    return true;
  }

  /**
   * Updates colors on board recursively once we have
   * both old and new color.
   *
   * @param oldColor: previous color needed for comparison
   * @param newColor: new color to update board with
   * @param x: an x coordinate
   * @param y: a y coordinate
   * @return none
   */
  private void updateBoard (int oldColor, int newColor, int x, int y)
  {
    if (x < 0 || x >= mSize || y < 0 || y >= mSize ||
      mcBoard[x][y].getColor() != oldColor)
    {
      return;
    }

    mcBoard[x][y].setColor (newColor);

    updateBoard(oldColor, newColor, x - 1, y);
    updateBoard(oldColor, newColor, x + 1, y);
    updateBoard(oldColor, newColor, x, y - 1);
    updateBoard(oldColor, newColor, x, y + 1);
  }

  /**
   * Sets X and Y coords
   *
   * @param i: current x coord
   * @param j: current y coord
   * @param x: an x coordinate to set to
   * @param y: a y coordinate to set to
   * @param size: a y coordinate
   * @return none
   */
  public void setXY (int i, int j, int x, int y, int size)
  {
    mcBoard[i][j].setX(x);
    mcBoard[i][j].setY(y);
    mcBoard[i][j].setSize(size);
  }

  /**
   * Gets Board
   *
   * @return Board
   */
  public Cell[][] getBoard ()
  {
    return mcBoard;
  }
}
