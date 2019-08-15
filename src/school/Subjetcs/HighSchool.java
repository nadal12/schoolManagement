/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.Subjetcs;

import school.Persons.Student;
import school.Persons.Teacher;


public class HighSchool extends Subject {
    
    private HighSchoolModality modality; 
    
    public HighSchool (String name, Teacher teacher, Student[] students, int year, HighSchoolModality modality) {
    
        super(name, teacher, students, year);
        this.modality = modality;        
    
    }

    public HighSchoolModality getModality() {
        return modality;
    }

    public void setModality(HighSchoolModality modality) {
        this.modality = modality;
    }

    @Override
    public String toString() {
        return "HighSchool{" + "Name=" + super.getName() + ", "
                + "Teacher Name= "+super.getTeacher().getName()+ ", "
                + "Number of students= "+super.getStudents().length+", "
                + "Modality= "+this.getModality().toString().toLowerCase()+ '}';
    }
    
}
