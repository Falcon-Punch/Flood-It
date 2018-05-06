/***********************************************************************
 File name:		NewColor.java
 Author:     	Joseph Schell
 Date:		  	01/11/2018
 Assignment: 	Learn Your Colors
 Purpose:    	Class to store all colors and make comparisons.
 **********************************************************************/
package edu.pacificu.cs.sche5694floodit;

/**
 * Creates a Color class where all colors can be found and compared with one
 * another
 */
public class NewColor
{
  private int mColorId;
  private static final String sBlack = "Black";
  private static final String sRed = "Red";
  private static final String sGreen = "Green";
  private static final String sYellow = "Yellow";
  private static final String sBlue = "Blue";
  private static final String sPurple = "Purple";
  private static final String sCyan = "Cyan";
  private static final String sWhite = "White";
  private static final String sAnsiBlack = "\u001B[30m";
  private static final String sAnsiRed = "\u001B[31m";
  private static final String sAnsiGreen = "\u001B[32m";
  private static final String sAnsiYellow = "\u001B[33m";
  private static final String sAnsiBlue = "\u001B[34m";
  private static final String sAnsiPurple = "\u001B[35m";
  private static final String sAnsiCyan = "\u001B[36m";
  private static final String sAnsiWhite = "\u001B[37m";

  /**
   * Default constructor that initializes data member to 0.
   */

  public NewColor ()
  {
    mColorId = 0;
  }

  /**
   * Constructor that initializes data member to the value that is passed
   * through.
   *
   * @param id: the color ID that is passed in to set member variable
   * value
   */

  public NewColor (int id)
  {
    this.mColorId = id;
  }

  /**
   * Returns the name of a color
   *
   * @return the name of a color
   */

  public String getName ()
  {
    switch (mColorId)
    {
      case 0:
        return sBlack;
      case 1:
        return sRed;
      case 2:
        return sGreen;
      case 3:
        return sYellow;
      case 4:
        return sBlue;
      case 5:
        return sPurple;
      case 6:
        return sCyan;
      case 7:
        return sWhite;
      default:
        return null;
    }
  }

  /**
   * Returns an ANSI code
   *
   * @return an ANSI code
   */

  public String getANSI ()
  {
    switch (mColorId)
    {
      case 0:
        return sAnsiBlack;
      case 1:
        return sAnsiRed;
      case 2:
        return sAnsiGreen;
      case 3:
        return sAnsiYellow;
      case 4:
        return sAnsiBlue;
      case 5:
        return sAnsiPurple;
      case 6:
        return sAnsiCyan;
      case 7:
        return sAnsiWhite;
      default:
        return null;
    }
  }

  /**
   * Compares two objects of the Color class returning a value of true if the
   * ANSI code and Color string are the same.
   *
   * @param colorObject: a color object
   * @return true if objects are equal; else, false
   */

  @Override
  public boolean equals (Object colorObject)
  {
    if (colorObject instanceof NewColor)
    {
      NewColor color = (NewColor) colorObject;
      return (color.getName ().equals (getName ()));
    }
    else
    {
      return false;
    }
  }
}

