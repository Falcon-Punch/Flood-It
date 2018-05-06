/*******************************************************************
 File name:		Cell.java
 Author:     	Joseph Schell
 Date:		  	01/16/2018
 Assignment: 	Flood-It
 Purpose:    	Cell class that implements cell objects on the game
              board
 ******************************************************************/
package edu.pacificu.cs.sche5694floodit;

public class Cell
{
  private int mX;
  private int mY;
  private int mColor;
  private int mSize;

  /**
   * Default Constructor
   */
  public Cell ()
  {

  }

  /**
   * Gets color of a cell
   *
   * @return color of a cell
   */
  public int getColor ()
  {
    return this.mColor;
  }

  /**
   * Gets size of a cell
   *
   * @return size of a cell
   */
  public int getSize ()
  {
    return mSize;
  }

  /**
   * Gets X coord of a cell
   *
   * @return X coord of a cell
   */
  public int getX ()
  {
    return this.mX;
  }

  /**
   * Gets Y coord of a cell
   *
   * @return Y coord of a cell
   */
  public int getY ()
  {
    return this.mY;
  }

  /**
   * Sets X coord of a cell
   *
   * @param x: X coord to set cell X coord to
   * @return none
   */
  public void setX (int x)
  {
    this.mX = x;
  }

  /**
   * Sets Y coord of a cell
   *
   * @param y: Y coord to set cell Y coord to
   * @return none
   */
  public void setY (int y)
  {
    this.mY = y;
  }

  /**
   * Sets size of a cell
   *
   * @param size: size to set cell size to
   * @return none
   */
  public void setSize (int size)
  {
    this.mSize = size;
  }

  /**
   * Sets color of a cell
   *
   * @param c: color to set cell color to
   * @return none
   */
  public void setColor (int c)
  {
    this.mColor = c;
  }
}
