/*
Clase Person. 

Clase abstracta que define las características mínimas que tendrán los 
estudiantes y profesores. 
 */
package school.Persons;

public abstract class Person {

    private String name;
    
    
    public Person() {
    
    
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
