/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.Subjetcs;

import school.Persons.Student;
import school.Persons.Teacher;


public abstract class Subject implements Comparable <Subject> {
    
    private String name; 
    private Teacher teacher;
    private Student[] students; 
    private int year; 
    
    public Subject(String name, Teacher teacher, Student[] students, int year) {
    
        this.name = name; 
        this.teacher = teacher; 
        this.students = students; 
        this.year = year;         
    
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Student[] getStudents() {
        return students;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    /**
     * <p>Metodo que compara dos objetos Subject e indica cuando {@code this}
     * precede o postcede a {@code o} ordenado por lexicograficamente segun
     * su nombre.
     * 
     * El orden lexicografico viene determinado por la comparacion de cada uno
     * de sus caracteres en la posicion "i" de cada String de su nombre. Cuando
     * ningun caracter es diferente, el orden viene dado por la comparacion
     * del largo de sus Strings.
     * 
     * @param o Objeto Subject con el cual comparar a this.
     * @return un entero que puede ser: Negativo si el nombre de {@code this} 
     * precede lexicograficamente al nombre de {@code o} | Cero (0) si ambos 
     * {@code this} y {@code o} tienen el mismo nombre | Positivo si el nombre 
     * de {@code o} precede lexicograficamente al nombre de {@code this}. </p>
     */
    @Override
    public int compareTo(Subject o) {
        return this.name.compareTo(o.name);
    }
    
}
