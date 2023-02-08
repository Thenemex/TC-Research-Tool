package model;

public class AspectPrimal
extends Aspect {

    /**
     * Constructeur avec le nom et l'image
     * @param name Le nom de l'aspect
     * @param fileName Le nom du fichier de l'image
     */
    public AspectPrimal(String name, String fileName) {
        super(name, fileName);
    }

    /**
     * Indique si l'aspect est un aspect composé
     * @return Faux, c'est un aspect primaire
     */
    @Override public boolean isCompound() {
        return false;
    }
}
