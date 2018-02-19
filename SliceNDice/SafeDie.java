public class SafeDie extends CombatDie {
    /**
     * Constructs a 6-sided die with the following faces:
     * 3 Sword faces
     * 2 Shield faces
     * 1 Heal face
     */
    public SafeDie() {
        this.faces = new DiceFace[6];
        faces[0] = new DiceFace(DiceFace.FaceType.SWORD, 1);
        faces[1] = new DiceFace(DiceFace.FaceType.HEAL, 1);
        faces[2] = new DiceFace(DiceFace.FaceType.SHIELD, 1);
        faces[3] = new DiceFace(DiceFace.FaceType.SHIELD, 1);
        faces[4] = new DiceFace(DiceFace.FaceType.SWORD, 1);
        faces[5] = new DiceFace(DiceFace.FaceType.SWORD, 1);
        this.faceUpIndex = 0;
    }
}
