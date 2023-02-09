package model;

import javafx.scene.image.Image;

import java.util.Objects;

/**
 * Class représentative d'un aspect de Thaumcraft
 */
public class Aspect {

    private final String name;
    private final Image picture;
    private Aspect aspect1 = null;
    private Aspect aspect2 = null;

    /**
     * Constructeur avec le nom et l'image
     * @param name Le nom de l'aspect
     * @param fileName Le nom du fichier de l'image
     */
    public Aspect(String name, String fileName) {
        this.name = name;
        this.picture = new Image(Objects.requireNonNull(getClass().getResourceAsStream(fileName)));
    }

    /**
     * Getter pour le nom de l'aspect
     * @return Le nom
     */
    public String getName() {
        return name;
    }
    /**
     * Getter pour l'image de l'aspect
     * @return L'image
     */
    public Image getPicture() {
        return picture;
    }

    /**
     * Setter pour les deux aspects qui composent l'aspect
     * @param aspect1 Le premier aspect
     * @param aspect2 Le deuxième aspect
     */
    public void setCompounds(Aspect aspect1, Aspect aspect2) {
        this.aspect1 = aspect1;
        this.aspect2 = aspect2;
    }

    /**
     * Indique le tier de l'aspect
     * @return Le tier
     */
    public int tier() {
        if (isPrimal()) return 0;
        else if (aspect1.isPrimal() && aspect2.isPrimal()) return 1;
        else return Math.max(aspect1.tier(), aspect2.tier());
    }

    /**
     * Indique si l'aspect est un aspect composé
     * @return Vrai si composé, Faux si primaire
     */
    public boolean isPrimal() {
        return aspect1 == null && aspect2 == null;
    }
    /**
     * Indique si l'aspect peut se lier sur la recherche avec l'argument
     * @param a L'aspect à lier
     * @return Vrai si les deux aspects sont liables
     */
    public boolean canLinkTo(Aspect a) {
        return equals(a.aspect1) && equals(a.aspect2) && a.equals(aspect1) && a.equals(aspect2);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aspect)) return false;
        Aspect aspect = (Aspect) o;
        return name.equals(aspect.name);
    }
    @Override public int hashCode() {
        return Objects.hash(name);
    }
}
