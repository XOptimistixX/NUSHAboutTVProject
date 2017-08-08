package sg.edu.nushigh.schooltvprojectabout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeff Sieu on 6/8/2017.
 */

public class App {
    public String name;
    public List<Person> developers;

    public App(String name, List<Person> developers) {
        this.name = name;
        this.developers = developers;
    }

    public String getName() {
        return name;
    }

    public List<Person> getDevelopers() {
        return developers;
    }
}
