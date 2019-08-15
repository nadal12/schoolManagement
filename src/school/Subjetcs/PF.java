/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.Subjetcs;

import school.Persons.Student;
import school.Persons.Teacher;

public class PF extends Subject {

    private PFModality type;

    public PF(String name, Teacher teacher, Student[] students, int year, PFModality type) {

        super(name, teacher, students, year);
        this.type = type;

    }

    public PFModality getType() {
        return type;
    }

    public void setType(PFModality type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PF{Title= " + this.getName() + ", Teacher= " + 
                this.getTeacher().getName() + ", Nº of students= " + 
                this.getStudents().length + ", Degree= " + 
                type.toString().toLowerCase()+"}";
    }
}
