import java.util.HashMap;
import java.util.Map;

/**
* <P>A class representing a die made for the SliceNDice game.
* <P>Each die has 2 or more sides, represented by the DiceFace class.
*
* @author Yourname Here
*/

public class CombatDie {
    protected DiceFace[] faces;
    protected int faceUpIndex;

    /**
     * Constructs a 4-sided die with a 1-value face of each variety (Sword,
     * Shield, Heal, and Broken Shield).
     */
    public CombatDie() {
        throw new UnsupportedOperationException();
    }

    /**
     * Constructs a die with the given faces.
     *
     * @param faces                       the array of faces this die will have
     * @throws IllegalArgumentException   if there are fewer than 2 faces
     *                                    in the given array
     */
    public CombatDie(DiceFace[] faces) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the dice face at the given index on this die.
     *
     * @param index   the index of a dice face within the die's arry of dice
     *                faces
     * @return        the dice face at the given index
     */
    public DiceFace getFaceAtIndex(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * Changes the face at the given index on this die to the given face.
     *
     * @param face    the new face to be placed at the given index
     * @param index   the index where the new face is to be placed.
     */
    public void setFaceAtIndex(DiceFace face, int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the number of faces that this die has.
     *
     * @return   this die's number of faces
     */
    public int getNumberOfFaces() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the index of the face that is face-up on the die.
     *
     * @return   the index of the face that is face-up on this die
     */
    public int getFaceUpIndex() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the face that is face-up on the die.
     *
     * @return   the face that is face-up on this die
     */
    public DiceFace getFaceUp() {
        throw new UnsupportedOperationException();
    }

    /**
     * Changes the face up side of this die to be the face at the given index.
     *
     * @param index                      the index of the new face-up face on
     *                                   this die
     * @throws IllegalArgumentException  if index isn't a valid index for the
     *                                   die
     */
    public void setFaceUpIndex(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the current face-up face of this die as a readable String.
     *
     * @return the current face-up face of this die in a String
     */
    public String currentFaceToString() {
        throw new UnsupportedOperationException();
    }

    /**
     * Rolls the die, changing the face up side to one of the die's sides at
     * random.
     */
    public void roll() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the number of faces this die has of a given DiceFace
     *
     * @param wantedFace  the dice face being looked for on this die
     * @return            the number of faces on the die equivalent to the
     *                    wanted face
     */
    public int faceCount(DiceFace wantedFace) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a string representation of the CombatDie, including all faces.
     *
     * @return  a String representation of the CombatDie
     */
    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }

    // Advanced Java---Proceed at own risk!
    /**
     * Indicates whether some other object is "equal to" this one,
     * of the same class and containing the same faces in the same amounts,
     * regardless of order.
     *
     * @param obj      the reference object with which to compare.
     * @return         <code>true</code> if this object is equal to the obj
     *                 argument; <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        CombatDie other = (CombatDie)obj;
        // Due to the possibility of duplicates, dice comparison is a notch trickier.
        // Our approach is to count the faces on each die then ensure that the faces
        // and counts are the same.
        return tally().equals(other.tally());
    }

    /**
     * Returns a Map tallying the number of times each dice face appears on the
     * CombatDie.
     *
     * @return         A Map tallying the amounts of each possible DiceFace
     */
    private Map<DiceFace, Integer> tally() {
        Map<DiceFace, Integer> result = new HashMap<DiceFace, Integer>();
        for (DiceFace diceFace: this.faces) {
            Integer value = result.get(diceFace);
            if (value == null) {
                result.put(diceFace, 1);
            } else {
                result.put(diceFace, value + 1);
            }
        }
        return result;
    }

}
