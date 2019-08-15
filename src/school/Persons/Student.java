/*
Clase Student. 

Hereda de la clase padre "Person". Implementa "Comparable". 
 */
package school.Persons;

public class Student extends Person implements Comparable <Student>{

    private int yearOfBirth;
    private boolean grant;
    
    
/**
 * Constructor del objeto Student
 * @param yearOfBirth Entero que indica el año de nacimiento. 
 * @param grant variable booleana para saber si tiene beca.
 * @param name String con el nombre del estudiante. 
 */
    public Student(int yearOfBirth, boolean grant, String name) {

        super(name);
        this.yearOfBirth = yearOfBirth;
        this.grant = grant;

    }
    
    /**
     * Contructor vacío.
     */
    public Student() {
    
        
    
    }

    /**
     * Método para asignar un año de nacimiento a {@code this}.
     * @param yearOfBirth Entero año de nacimiento. 
     */
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    /**
     * Método para asignar el estado de la beca de {@code this}.
     * @param grant Variable booleana para asignar beca. 
     */
    public void setGrant(boolean grant) {
        this.grant = grant;
    }

    /**
     * Método que devuelve el año de nacimiento de {@code this}.
     * @return Entero con el año de nacimiento.
     */
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    /**
     * Método que devuelve una variable booleana para saber si {@code this} 
     * dispone de beca. 
     * @return Boolean con el estado de la beca. Return true si {@code this}
     * tiene beca. False caso contrario. 
     */
    public boolean isGrant() {
        return grant;
    }

    /**
     * {@inheritDoc}
     * @return 
     */
    @Override
    public String toString() {
        return "Student{" + "Name=" + super.getName() + ", yearOfBirth=" + yearOfBirth + ", grant=" + grant + '}';
    }

    /**
     * <p>Metodo que compara dos objetos Student e indica cuando {@code this}
     * precede o postcede a {@code o} ordenado por lexicograficamente segun
     * su nombre.
     * 
     * El orden lexicografico viene determinado por la comparacion de cada uno
     * de sus caracteres en la posicion "i" de cada String de su nombre. Cuando
     * ningun caracter es diferente, el orden viene dado por la comparacion
     * del largo de sus Strings.
     * 
     * @param o Objeto Student con el cual comparar a this.
     * @return un entero que puede ser: Negativo si el nombre de {@code this} 
     * precede lexicograficamente al nombre de {@code o} | Cero (0) si ambos 
     * {@code this} y {@code o} tienen el mismo nombre | Positivo si el nombre 
     * de {@code o} precede lexicograficamente al nombre de {@code this}. </p>
     */
    @Override
    public int compareTo(Student o) {
        
        return this.getName().compareTo(o.getName());
        
    }

}
