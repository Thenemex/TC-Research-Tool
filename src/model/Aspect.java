package model;

import javafx.scene.image.Image;

import java.util.Objects;

/**
 * Class représentative d'un aspect de Thaumcraft
 */
public abstract class Aspect {

    protected final String name;
    protected final Image picture;

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
     * Indique si l'aspect est un aspect composé
     * @return Vrai si composé, Faux si primaire
     */
    public abstract boolean isCompound();
}
