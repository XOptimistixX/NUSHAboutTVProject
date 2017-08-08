package sg.edu.nushigh.schooltvprojectabout;

import android.graphics.drawable.Drawable;

/**
 * Created by Jeff Sieu on 6/8/2017.
 */

public class Person {
    private String name, description;
    private Drawable picture;

    public Person(String name, String description, Drawable picture) {
        this.name = name;
        this.description = description;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Drawable getPicture() {
        return picture;
    }
}
