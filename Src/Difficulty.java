/*******************************************************************
 File name:		Difficulty.java
 Author:     	Joseph Schell
 Date:			  01/16/2018
 Assignment: 	Flood-It
 Purpose:    	Difficulty class that handles the level of difficulty
 choosen by the user.
 ******************************************************************/
package edu.pacificu.cs.sche5694floodit;

public class Difficulty
{
  private Level mcLevel;
  private static Difficulty mcValue;

  /**
   * Default Constructor
   */
  private Difficulty ()
  {
    mcLevel = Level.DEFAULT;
  }

  /**
   * Gets value of difficulty
   *
   * @return value of difficulty
   */
  public static Difficulty getValue ()
  {
    if (null == mcValue)
    {
      mcValue = new Difficulty ();
    }
    return mcValue;
  }

  /**
   * Sets level of difficulty
   *
   * @param level: level to be set to
   * @return none
   */
  public void setLevel (Level level)
  {
    this.mcLevel = level;
  }

  /**
   * Gets level of difficulty
   *
   * @return enum Level value
   */
  public Level getLevel ()
  {
    return mcLevel;
  }
}

/**
 * Enum container to store level values
 */
enum Level
{
  EASY,
  MEDIUM,
  HARD,
  DEFAULT
}

