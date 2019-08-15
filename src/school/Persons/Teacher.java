/*
Clase Teacher. 

Hereda de la clase Person. Implementa Comparable. 
 */
package school.Persons;


public class Teacher extends Person implements Comparable<Teacher> {

    private String certification; 
    
    /**
     * Constructor del objeto Teacher. 
     * @param name String con el nombre del profesor.
     * @param certification String con la certificación del profesor. 
     */
    public Teacher (String name, String certification) {
    
        super(name);
        this.certification = certification; 
        
    }

    /**
     * Método que asigna un String al atributo certificación de {@code this}.
     * @param certification 
     */
    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getCertification() {
        return certification;
    }
    
    /**
     * <p>Metodo que compara dos objetos Teacher e indica cuando {@code this}
     * precede o postcede a {@code o} ordenado por lexicograficamente segun
     * su nombre.
     * 
     * El orden lexicografico viene determinado por la comparacion de cada uno
     * de sus caracteres en la posicion "i" de cada String de su nombre. Cuando
     * ningun caracter es diferente, el orden viene dado por la comparacion
     * del largo de sus Strings.
     * 
     * @param o Objeto Teacher con el cual comparar a this.
     * @return un entero que puede ser: Negativo si el nombre de {@code this} 
     * precede lexicograficamente al nombre de {@code o} | Cero (0) si ambos 
     * {@code this} y {@code o} tienen el mismo nombre | Positivo si el nombre 
     * de {@code o} precede lexicograficamente al nombre de {@code this}. </p>
     */
    @Override
    public int compareTo(Teacher o) {
        return this.getName().compareTo(o.getName()); //Comparacion Strings
    }
    
    /**
     * {@inheritDoc }
     * @return Devuelve un String con los atributos "Name" y "Certification"
     * del objeto Teacher. 
     */
    @Override
    public String toString() {
        return "Teacher{" + "Name=" + super.getName() + ", certification=" + certification + '}';
    }
}