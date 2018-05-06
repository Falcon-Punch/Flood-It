/***********************************************************************
 File name:		ColorGenerator.java
 Author:     	Joseph Schell
 Date:			  01/11/2018
 Assignment: 	Flood-It
 Purpose:    	Color Generator class that stores colors based on random
 seed.
 **********************************************************************/
package edu.pacificu.cs.sche5694floodit;

import java.util.Random;
import java.util.ArrayList;

/**
 * Creates a ColorGenerator class where all colors are generated and stored
 * based on a given seed value
 */

public class ColorGenerator extends NewColor
{
  private ArrayList<NewColor> acColorArray;
  private static int round = 8;

  /**
   * Constructor that produces a random colors based on the passed in value
   * of the seed.
   *
   * @param seed: The passed in value to determine random generator
   */

  public ColorGenerator (int seed)
  {
    Random mRandomGenerator = new Random (seed);
    acColorArray = new ArrayList<NewColor> ();

    for (int i = 0; i < round; ++i)
    {
      NewColor color = new NewColor (mRandomGenerator.nextInt (round));

      while (acColorArray.contains (color))
      {
        color = new NewColor (mRandomGenerator.nextInt (round));
      }
      acColorArray.add (color);
    }
  }

  /**
   * Returns a Color
   *
   * @return a Color
   */

  public NewColor getColor ()
  {
    if (acColorArray.isEmpty ())
    {
      return null;
    }
    return acColorArray.remove (0);
  }
}

