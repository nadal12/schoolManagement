/*
School Program 

Autores: Eugenio Doñaque y Nadal Llabrés. 
Asignatura: Algorítmia.
Fecha: 28/10/2018.

Entrega de la Práctica de POO. 

 */
package school;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import school.Persons.Student;
import school.Persons.Teacher;
import school.Subjetcs.HighSchool;
import school.Subjetcs.HighSchoolModality;
import school.Subjetcs.PF;
import school.Subjetcs.PFModality;
import school.Subjetcs.Subject;

public class School extends JFrame {

    //DECLARACIONES DE DATOS
    final static int NUMBER_OF_STUDENTS = 100000;                    
    final static int NUMBER_OF_TEACHERS = 1000;
    final static int NUMBER_OF_SUBJECTS = 100;
    
    static Student[] students;
    static Teacher[] teachers;
    static Subject[] subjects;

    /*
        DECLARACIONES DE INTERFAZ GRAFICA
     */
    //DECLARACIONES MENU
    JMenuBar jmBar;
    JMenu jMenuMain;
    JMenu jMenuActions;
    JMenu jMenuAbout;
    JMenuItem jmAcc1;
    JMenuItem jmAcc2;
    JMenuItem jmAcc3;
    JMenuItem jmAcc4;
    JMenuItem jmAcc5;
    JMenuItem jmAcc6;
    JMenuItem jmAcc7;
    JMenuItem jmAcc8;
    JMenuItem jmExit;
    JMenuItem jmAbout;
    JMenuItem jmClearConsole;

    //SPLIT PANEL QUE CONTENDRA TODO
    JSplitPane container;                                                        

    //CONTENEDORES DE BOTONES Y AREA DE LOG
    JSplitPane jWestContainer;
    JPanel jButtonContainer;
    
    JPanel jpAccBtn;
    JButton jbAcc1;
    JButton jbAcc2;
    JButton jbAcc3;
    JButton jbAcc4;
    JButton jbAcc5;
    JButton jbAcc6;
    JButton jbAcc7;
    JButton jbAcc8;
    JButton jbClear;                                                                       
    
    JPanel jpAccLb;
    JLabel jButtonsLabel;
    
    JScrollPane jLogContainer;
    JLabel jLogLabel;
    JTextArea jLogArea;
    
    JScrollPane jMainOutput;
    JLabel jOutputLabel;
    JTextArea jOutputArea;
    
    public School() {

        //Configuraciones de la ventana.                                   
        super("School");
        initComponents();
        
    }

    /**
     * Inicializa todos los elementos de la ventana.
     */
    public void initComponents() {
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDim = tk.getScreenSize();
        Dimension dimension;
        
        int width = (int)screenDim.getWidth()/6;                                   
        int height = (int)screenDim.getHeight()/8;                         
        this.setLocation(width, height);
        
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        //Ítems del menú "Acciones"
        jmAcc1 = new JMenuItem("Generate data");
        
        jmAcc2 = new JMenuItem("Ordered list of professors");
        jmAcc2.setEnabled(false);
        jmAcc3 = new JMenuItem("Remove a professor...");
        jmAcc3.setEnabled(false);
        jmAcc4 = new JMenuItem("Student list by subject");
        jmAcc4.setEnabled(false);
        jmAcc5 = new JMenuItem("Ordered list of subjects");
        jmAcc5.setEnabled(false);
        jmAcc6 = new JMenuItem("Remove a subject...");
        jmAcc6.setEnabled(false);
        jmAcc7 = new JMenuItem("Ordered list by degree (PF)");
        jmAcc7.setEnabled(false);
        jmAcc8 = new JMenuItem("Ordered list by modality (HighSchool)");
        jmAcc8.setEnabled(false);

        //Creación del menú "Acciones" e inclusión de los ítems. 
        jMenuActions = new JMenu("Actions");
        jMenuActions.add(jmAcc1);
        jMenuActions.add(jmAcc2);
        jMenuActions.add(jmAcc3);
        jMenuActions.add(jmAcc4);
        jMenuActions.add(jmAcc5);
        jMenuActions.add(jmAcc6);
        jMenuActions.add(jmAcc7);
        jMenuActions.add(jmAcc8);

        //Menú "About".
        jmAbout = new JMenuItem("About");
        jMenuAbout = new JMenu("About");
        jMenuAbout.add(jmAbout);

        //Main menu. 
        jmExit = new JMenuItem("Exit");
        jmClearConsole = new JMenuItem("Clear console");
        jMenuMain = new JMenu("Main menu");
        jMenuMain.add(jmClearConsole);
        jMenuMain.addSeparator();
        jMenuMain.add(jmExit);

        //Inclusión de los menús a la barra de menús. 
        jmBar = new JMenuBar();
        jmBar.add(jMenuMain);
        jmBar.add(jMenuActions);
        jmBar.add(jMenuAbout);

        //Inclusión de la barra de menús a la ventana. 
        this.setJMenuBar(jmBar);

        //CONTENEDOR DE LOS BOTONES
        //Inicialización de los botones.
        jbAcc1 = new JButton("Generate data");
        jbAcc2 = new JButton("Ordered list of professors");
        jbAcc2.setEnabled(false);
        jbAcc3 = new JButton("Remove a professor...");
        jbAcc3.setEnabled(false);
        jbAcc4 = new JButton("Student list by subject");
        jbAcc4.setEnabled(false);
        jbAcc5 = new JButton("Ordered list of subjects");
        jbAcc5.setEnabled(false);
        jbAcc6 = new JButton("Remove a subject...");
        jbAcc6.setEnabled(false);
        jbAcc7 = new JButton("Ordered list by degree (PF)");
        jbAcc7.setEnabled(false);
        jbAcc8 = new JButton("Ordered list by modality (HighSchool)");
        jbAcc8.setEnabled(false);
        jbClear = new JButton("Clear output console");

        //Action listener de los botones. 
        jbAcc1.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmAcc1ActionPerformed(evt);
            }
            
        });
        jbAcc2.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmAcc2ActionPerformed(evt);
            }
            
        });
        jbAcc3.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmAcc3ActionPerformed(evt);
            }
            
        });
        jbAcc4.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmAcc4ActionPerformed(evt);
            }
            
        });
        jbAcc5.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmAcc5ActionPerformed(evt);
            }
            
        });
        jbAcc6.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmAcc6ActionPerformed(evt);
            }
            
        });
        jbAcc7.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmAcc7ActionPerformed(evt);
            }
            
        });
        jbAcc8.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmAcc8ActionPerformed(evt);
            }
            
        });
        
        jbClear.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmClearConsoleActionPerformed(evt);
            }
            
        });

        //Texto "Actions" de cabecera para botones
        Font font = new Font("Albertus Extra Bold", Font.BOLD, 16);
        jButtonsLabel = new JLabel("Actions");        
        jButtonsLabel.setFont(font);

        //Inicialización del contenedor de botones. 
        jButtonContainer = new JPanel(new BorderLayout());

        /*
            MODIFICACION PARA USAR DOS CONTENEDORES Y SEPARAR BOTON DE ETIQUETA
            DE ACCIONES
         */
        jpAccLb = new JPanel();
        jpAccBtn = new JPanel();
        
        jpAccLb.add(jButtonsLabel);
        jpAccBtn.setLayout(new GridLayout(0, 2, 2, 2));

        //Añadir botones al contenedor de botones
        jpAccBtn.add(jbAcc1);
        jpAccBtn.add(jbAcc2);
        jpAccBtn.add(jbAcc3);
        jpAccBtn.add(jbAcc4);
        jpAccBtn.add(jbAcc5);
        jpAccBtn.add(jbAcc6);
        jpAccBtn.add(jbAcc7);
        jpAccBtn.add(jbAcc8);
        
        jButtonContainer.add(jpAccLb, BorderLayout.NORTH);
        jButtonContainer.add(jpAccBtn, BorderLayout.CENTER);
        jButtonContainer.add(jbClear, BorderLayout.SOUTH);

        //CONTENEDOR DEL LOG
        //Inicialización del contenedor del log. 
        jLogArea = new JTextArea();
        jLogArea.setEditable(false);
        jLogContainer = new JScrollPane(jLogArea);

        //Añadir jLogContainer y jButtonContainer a JSplitPane
        jWestContainer = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jButtonContainer, jLogContainer);

        //CONTENEDOR DE LA CONSOLA                                                      
        jOutputArea = new JTextArea();
        jOutputArea.setEditable(false);
        jMainOutput = new JScrollPane(jOutputArea);

        //Dimensionar contenedor JSplitPane
        width = (int)(screenDim.getWidth()*0.75);                                      
        height = (int) (screenDim.getHeight()*0.75);                                         
        dimension = new Dimension(width, height);
        
        container = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jWestContainer, jMainOutput);
        container.setSize(dimension);
        container.setPreferredSize(dimension);
        
        this.add(container);

        /*  
            Dimensionar resto de componentes
         */
        //Container
        container.setResizeWeight(0.0);

        //MainOutput
        width = container.getWidth() / 2;
        height = container.getHeight();
        jMainOutput.setMinimumSize(new Dimension(width, height));

        //jWestContainer
        jWestContainer.setPreferredSize(container.getPreferredSize());

        //jLogArea
        width = jWestContainer.getPreferredSize().width / 8;
        height =(int) (jWestContainer.getPreferredSize().height * 0.60);
        jLogContainer.setMinimumSize(new Dimension(width, height));
        
        this.pack();

        //Se añade un escuchador de acciones a cada ítem.
        jmAcc1.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmAcc1ActionPerformed(evt);
            }
            
        });
        
        jmAcc2.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmAcc2ActionPerformed(evt);
            }
            
        });
        
        jmAcc3.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmAcc3ActionPerformed(evt);
            }
            
        });
        
        jmAcc4.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmAcc4ActionPerformed(evt);
            }
            
        });
        
        jmAcc5.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmAcc5ActionPerformed(evt);
            }
            
        });
        
        jmAcc6.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmAcc6ActionPerformed(evt);
            }
            
        });
        
        jmAcc7.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmAcc7ActionPerformed(evt);
            }
            
        });
        
        jmAcc8.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmAcc8ActionPerformed(evt);
            }
            
        });
        
        jmAbout.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmAboutActionPerformed(evt);
            }
            
        });
        
        jmExit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmExitActionPerformed(evt);
            }
            
        });
        
        jmClearConsole.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmClearConsoleActionPerformed(evt);
            }
            
        });
        
    }

    //Se añaden las funcionalidades a cada ítem. 
    private void jmAcc1ActionPerformed(ActionEvent evt) {
        fillArrays();
        enableItemsAndButtons();
        jOutputArea.setText(arraysToString());
        jLogArea.setText(jLogArea.getText() + getCurrentTime() + " Generate data" + "\n");
    }
    
    private void jmAcc2ActionPerformed(ActionEvent evt) {
        
        jOutputArea.setText(jOutputArea.getText() + teacherList());
        jLogArea.setText(jLogArea.getText() + getCurrentTime() + " Ordered list of professors" + "\n");
        
    }
    
    private void jmAcc3ActionPerformed(ActionEvent evt) {
        String message = "Select one";
        
        jLogArea.setText(jLogArea.getText() + getCurrentTime() + " Remove professor\n");

        Teacher []arrayCopy = teachers.clone();
        
        Arrays.sort(arrayCopy);
        
        Object answer = JOptionPane.showInputDialog(null, 
                "Please, select an item from the list", "Remove professor",
                JOptionPane.INFORMATION_MESSAGE, null, arrayCopy, message);
        
        if (answer instanceof Teacher) {
            
            int value = removeTeacher((Teacher) answer);
            
            if (value == 0) {
            
                jOutputArea.setText(jOutputArea.getText() + "Professor " + answer + " was deleted.\n");
            
            } else {
            
                jOutputArea.setText(jOutputArea.getText() + "Something was wrong.\n");
            
            }
            
            
        } else {
            /*
                Si answer no es instancia de Teacher, el usuario no ha 
                seleccionado una opcion valida
            */
            jOutputArea.setText(jOutputArea.getText() + "Operation cancelled by user.\n");
        }
    }
    
    private void jmAcc4ActionPerformed(ActionEvent evt) {
        
      jLogArea.setText(jLogArea.getText() + getCurrentTime() + " Student list by subject" + "\n");
      Subject sbj = (Subject) JOptionPane.showInputDialog(null, "Select subject", "Elegir", JOptionPane.QUESTION_MESSAGE, null, subjects, null);
      
      if(sbj!=null) {     
     
          jOutputArea.setText(jOutputArea.getText() + viewStudentsFromSubject(sbj));

      }else {
    
          jOutputArea.setText(jOutputArea.getText() + "Operation cancelled by user.\n");
   
      }    
      
    }
    
    private void jmAcc5ActionPerformed(ActionEvent evt) {
        
        jOutputArea.setText(jOutputArea.getText() + subjectsList());
        jLogArea.setText(jLogArea.getText() + getCurrentTime() + " Ordered list of subjects" + "\n");
        
    }
    
    private void jmAcc6ActionPerformed(ActionEvent evt) {
        
      jLogArea.setText(jLogArea.getText() + getCurrentTime() + " Remove a subject" + "\n");
      Subject sbj = (Subject) JOptionPane.showInputDialog(null, "Select subject", "Choose", JOptionPane.QUESTION_MESSAGE, null, subjects, null);
      
      if(sbj!=null) {     
     
          if (removeSubject(sbj)==0) {
          
            jOutputArea.setText(jOutputArea.getText() + "Subject " + sbj.getName() + " was deleted.\n");
          }else{
          
            jOutputArea.setText(jOutputArea.getText() + "Something was wrong.\n");
          
          }
          

      }else {
    
          jOutputArea.setText(jOutputArea.getText() + "Operation cancelled by user.\n");
   
      }    
      
        
    }
    
    private void jmAcc7ActionPerformed(ActionEvent evt) {
        
        jOutputArea.setText(jOutputArea.getText() + pfList());
        jLogArea.setText(jLogArea.getText() + getCurrentTime() + " Ordered list by degree (PF)" + "\n");

    }
    
    private void jmAcc8ActionPerformed(ActionEvent evt) {
        
        jOutputArea.setText(jOutputArea.getText() + highSchoolList());
        jLogArea.setText(jLogArea.getText() + getCurrentTime() + " Ordered list by modality (High School)" + "\n");

    }
    
    private void jmAboutActionPerformed(ActionEvent evt) {
        
        programInfo();
        
    }
    
    private void jmClearConsoleActionPerformed(ActionEvent evt) {
        
        jOutputArea.setText(null);
        jLogArea.setText(jLogArea.getText() + getCurrentTime() + " Clear console" + "\n");
        
    }
    
    private void jmExitActionPerformed(ActionEvent evt) {
        
        System.exit(0);
        
    }
    
    public static void main(String[] args) {

        //Heredar estilo de menús del sistema operativo donde se ejecuta. 
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(School.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        School school = new School();
        school.setVisible(true);
    }

    /**
     * Rellena los arrays students, teachers y subjects con datos aleatorios.
     */
    public static void fillArrays() {

        //Inicializaciones
        students = new Student[NUMBER_OF_STUDENTS];
        teachers = new Teacher[NUMBER_OF_TEACHERS];
        subjects = new Subject[NUMBER_OF_SUBJECTS];

        //Declaraciones
        Random random = new Random();
        String name, aux;
        int year;
        boolean grant;
        Teacher teacher;
        Student[] studentsForSubject;
        Student auxStudent;
        PFModality pfm;
        HighSchoolModality hsm;

        /*Variable que servirá para comprobar que no se duplican alumnos 
        dentro de asignaturas.*/
        boolean found = true;

        //Rellenar el array "students".
        for (int i = 0; i < NUMBER_OF_STUDENTS; i++) {
            
            name = "StudentName" + (random.nextInt(400001) + 100000);
            //Año de nacimiento aleatorio. Rango [1950, 2000] 
            year = random.nextInt(50) + 1951;
            grant = random.nextBoolean();
            students[i] = new Student(year, grant, name);
            
        }

        //Rellenar el array "teachers". 
        for (int i = 0; i < NUMBER_OF_TEACHERS; i++) {
            
            name = "TeacherName" + (random.nextInt(9000) + 1000);
            aux = "Certification" + (random.nextInt(20) + 1);
            teachers[i] = new Teacher(name, aux);
            
        }

        //Rellenar el array de "subjects".
        for (int i = 0; i < NUMBER_OF_SUBJECTS; i++) {
            
            name = "Subject" + (i + 100);

            /*Los profesores se asignan de forma secuencial ya que en ningún
            sitio se especifica lo contrario*/
            teacher = (Teacher) teachers[i];

            /*Conjunto de estudiantes que se agregará a cada asignatura.
            La cantidad es un aleatorio que trabaja en este intervalo [15 y 20].*/
            studentsForSubject = new Student[random.nextInt(5) + 16];

            //Elección de los alumnos que formaran parte de la asignatura. 
            for (int e = 0; e < studentsForSubject.length; e++) {
                
                auxStudent = (Student) students[random.nextInt(NUMBER_OF_STUDENTS)];
                
                //Comprobación de estudiantes repetidos. 
                while (found) {
                    
                    auxStudent = (Student) students[random.nextInt(NUMBER_OF_STUDENTS)];
                    found = false;
                    
                    for (int k = 0; (k < (studentsForSubject.length) && !(found) && (e == k)); k++) {
                        
                        studentsForSubject[k] = (Student) students[random.nextInt(NUMBER_OF_STUDENTS)];
                        
                        if (studentsForSubject[k].equals(auxStudent)) {
                            
                            found = true;
                            
                        }                        
                        
                    }
                    
                }
                
                studentsForSubject[e] = auxStudent;
                found = true;
            }

            //Año de la asignatura. Rango [2010-2018].
            year = (random.nextInt(8) + 2011);

            /*Elección aleatoria de si se trata de una asignatura de FP o de 
            bachillerato.*/
            switch (random.nextInt(2)) {
                
                case 0:
                    
                    hsm = HighSchoolModality.values()[random.nextInt((HighSchoolModality.values().length))];
                    subjects[i] = new HighSchool(name, teacher, studentsForSubject, year, hsm);
                    
                    break;
                
                case 1:
                    
                    pfm = PFModality.values()[random.nextInt(PFModality.values().length)];
                    subjects[i] = new PF(name, teacher, studentsForSubject, year, pfm);
                    
                    break;
                
            }
            
        }
        
    }

    /**
     * Funcion que copia el array de la clase, lo ordena alfabeticamente y
     * concatena los datos [name, certification] contenidos en el nuevo array en
     * el String que devuelve.
     *
     * Cada linea del String viene con el formato: "Name: xxx | Certification:
     * yyy"
     *
     * @return s String con el contenido del array ordenado.
     */
    public static String teacherList() {
        Teacher[] array = teachers.clone(); //Copia del array de entrada
        //Ordena alfabeticamente segun implementacion del compareTo de Teacher
        Arrays.sort(array);
        
        String s = "";
        for (int i = 0; i < array.length; i++) {
            s += "Name: " + array[i].getName() + " | Certification: "
                    + array[i].getCertification() + "\n";
        }
        return s;
    }
    /**
     * Metodo que elimina el profesor en la posicion 'index' del array
     * 'teachers' y si este impartia clase en alguna asignatura, se consigue un
     * reemplazo para dicha asignatura.
     *
     * @param t Teacher a eliminar                                                      
     * @return -1 si {@code t} no corresponde al nombre de ningun profesor
     * del programa. 0 si no hay fallos.
     */
    public static int removeTeacher(Teacher t) {
        int i = 0;
        int j, index;
        boolean notAssigned = false; //Check si un Teacher ya esta asignado
        Random ran = new Random();
        
        
        /*
            Búsqueda del profesor en el array.
         */
        index = 0;
        while (index < teachers.length && 
                teachers[index] != t) {
            index++;
        }
        //Si no lo ha encontrado, retorna -1
        if (index == teachers.length && teachers[index-1] != t) {
            return -1;
        }
        
        /*
            Busqueda de asignatura en la cual imparte clase el profesor del
            indice 'index'
        */
        while (i < subjects.length && 
                subjects[i].getTeacher() != teachers[index]) {
            i++;
        }
        
        //Chequea que se haya conseguido al teacher
        if ((i==subjects.length)&&(subjects[i-1].getTeacher()!=teachers[index])) { 
            
            Object o[] = removeFromArray(teachers, index);
            teachers = new Teacher[o.length];
            for (int k = 0; k < o.length; k++) {
                teachers[k] = (Teacher) o[k];
            }
            
        } else { //El indice pasado por parametro no corresponde a algun
                 //profesor que imparta alguna clase

            Object o[] = removeFromArray(teachers, index);
            teachers = new Teacher[o.length];
            for (int k = 0; k < o.length; k++) {
                teachers[k] = (Teacher) o[k];
            }

            /*
                Busqueda de profesor libre de asignaturas
            */
            for (j = 0; j < teachers.length; j++) {
                
                int k = 0;
                while (k < subjects.length && 
                        teachers[j] != subjects[k].getTeacher()) { 
                    k++;
                }
 
                if (k == subjects.length && teachers[j] == subjects[k-1].getTeacher()) {
                    notAssigned = true;
                    break;
                } 
            }
            
            if (notAssigned) {
                subjects[i].setTeacher(teachers[j]);
            } else {
                subjects[i].setTeacher(teachers[ran.nextInt(teachers.length)]);
            }
            
        

        }
        
        return 0;
    }

    /**
     * Funcion que elimina el objeto almacenado en un array (a[index] = null;) y
     * crea un nuevo array de largo a.length-1.
     *
     * @param a array de entrada
     * @param index indice del objeto del array a eliminar
     * @return la instancia del nuevo array sin el objeto eliminado.
     */
    public static Object[] removeFromArray(Object[] a, int index) {
        a[index] = null;
        return Arrays.stream(a).filter(s -> (s != null)).toArray(Object[]::new);
    }

    /**
     * Funcion que lista los estudiantes de una asignatura. La asignatura
     * deseada se pasa por parámetro y se devuelve un String con los datos de
     * los estudiantes que la forman ordenados alfabéticamente.
     *
     * @param x Asignatura de entrada.
     * @return String con el formato: "Name: xxx, Grant: Yes/No, Year of birth:
     * YYYY".
     */
    public static String viewStudentsFromSubject(Subject x) {

        //Declaraciones
        Student[] auxArray = x.getStudents().clone();
        String s = "";
        String granted;

        //Ordenación del array. 
        Arrays.sort(auxArray);
        
        for (int i = 0; i < x.getStudents().length; i++) {

            //Comprobación de si tene beca o no. 
            if (auxArray[i].isGrant()) {
                
                granted = "Yes";
                
            } else {
                
                granted = "No";
                
            }

            //Concatenación al String que se devolverá. 
            s += "Name: " + auxArray[i].getName() + ", Grant: " + granted + ", "
                    + "Year of birth: " + auxArray[i].getYearOfBirth() + ".\n";
            
        }
        
        return s;
        
    }

    /**
     * Funcion que copia el array de la clase, lo ordena alfabeticamente y
     * concatena los datos [Title, teacher, Nº of students, type of studies,
     * modality of studies] contenidos en el nuevo array en el String que
     * devuelve.
     *
     * Cada linea del String viene con el formato: "Title: xxx | Teacher: yyy |
     * Nº of students: w | [type of studies], modality: m"
     *
     * @return s String con el contenido del array ordenado.
     */
    public static String subjectsList() {
        Subject[] array = subjects.clone();
        
        Arrays.sort(array);
        
        String s = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] instanceof HighSchool) {
                HighSchool hs = (HighSchool) array[i];
                s += "Title: " + hs.getName() + " | Teacher: "
                        + hs.getTeacher().getName() + " | Nº of students: "
                        + hs.getStudents().length + " | Highschool, modality: "
                        + hs.getModality() + "\n";
            } else {
                PF pf = (PF) array[i];
                s += "Title: " + pf.getName() + " | Profesor: "
                        + pf.getTeacher().getName() + " | Nº de alumnos: "
                        + pf.getStudents().length + " | PF, type: "
                        + pf.getType() + "\n";
            }
        }
        return s;
    }

    /**
     * Funcion que elimina una asignatura del conjunto. A través de la parte
     * paramétrica se especifica el nombre de la asignatura. Devuelve -1 si la
     * asignatura no se encuentra, o 0 si ha sido eliminada correctamente.
     *
     * @param subject String con el nombre de la asignatura.
     * @return -1 si no se encuentra la asignatura, 0 si el proceso de ha
     * completado correctamente.
     */
    public static int removeSubject(Subject subject) {

        //Declaraciones
        Subject sb = subject;
        boolean found = false;
        
        Object [] o; 

        //Búsqueda del nombre de la asignatura en el array. 
        for (int i = 0; i < subjects.length && !found; i++) {
            
            if (subjects[i]==sb) {
                
                found = true;
                o = removeFromArray(subjects, i);
                subjects = new Subject[o.length]; 
                for (int j = 0; j < o.length; j++) {
                    
                    subjects[j] = (Subject)o[j];                     
                    
                }
            }
            
                        
            
        }
        
        if (found) {
            
            return 0;
            
        } else {
            
            return -1;
            
        }
        
    }

    /**
     * Funcion que copia el array de la clase, lo divide en tantos ArrayList
     * como {@code PFModality} existan, ordena alfabeticamente cada ArrayList y
     * concatena los datos [Title, teacher, Nº of students, degree of studies]
     * contenidos en el nuevo array en el String que devuelve, separado por
     * lineas que indican a cual {@code PFModality} hace referencia.
     *
     * El String resultante viene con el formato: "PFModality 1" "Title: xxx |
     * Teacher: yyy | Nº of students: w | degree: PFModality 1" "PFModality 2"
     * "Title: xxx | Teacher: yyy | Nº of students: w | degree: PFModality 2"
     *
     * @return s String con el contenido del array ordenado.
     */
     public static String pfList() {
        //Declaraciones
        int c;
        String s = "";
        /*
            ArrayList de ArrayList de PF para poder tener un array de tamaño
            dinamico que se adapte a la cantidad de enums contenidos en 
            PFModality.
        */
        Subject []sbjCopy = subjects.clone();
        ArrayList<ArrayList<PF>> al = new ArrayList<>(PFModality.values().length);
        
        //Instanciacion ArrayLists
        for (int i = 0; i < PFModality.values().length; i++) {
            al.add(new ArrayList<>());
        }
       
        /*
            Separacion de asignaturas de PF segun su grado.
        */
        for (int i = 0; i < sbjCopy.length ; i++) {
            if (sbjCopy[i] instanceof PF) {
                PF pf = (PF) sbjCopy[i];
                
                c = 0; //Indice para busqueda
                /*
                    Busqueda del indice en el cual se ha de guardar el nuevo
                    elemento.
                */
                while (pf.getType() != PFModality.values()[c]) {
                    c++;
                }
                al.get(c).add(pf); //Añadir elemento en ArrayList correspondiente
            }
        }
        
        //Ordenar todos los arrayList
        for (int i = 0; i < al.size(); i++) {
            Collections.sort(al.get(i));
            s += "\n "+ PFModality.values()[i].toString() +" \n";
            for (int j = 0; j < al.get(i).size(); j++) {
                s += al.get(i).get(j).toString() + "\n";
            }
        }
     
        return s;
    }
    
      /**
     * Funcion que copia el array de la clase, lo divide en tantos ArrayList
     * como {@code HighSchoolModality} existan, ordena alfabeticamente cada ArrayList y
     * concatena los datos [Name, teacher, Nº of students, modality] 
     * contenidos en el nuevo array en el String que devuelve, separado por
     * lineas que indican a cual {@code PFModality} hace referencia.
     *
     * El String resultante viene con el formato: 
     * 
     * "PFModality 1"
     * "Name: xxx | Teacher: yyy | Nº of students: w | Modality: HighSchoolModality 1"
     * 
     * "HighSchoolModality 2"
     * "Name: xxx | Teacher: yyy | Nº of students: w | Modality: HighSchoolModality 2"
     * 
     * @return s String con el contenido del array ordenado.
     */
    public static String highSchoolList() {

        //Declaraciones
        String s = "";
        ArrayList<ArrayList<HighSchool>> al = new ArrayList<>(HighSchoolModality.values().length);
        Subject[] sb = subjects.clone();
        HighSchool hs;
        
        //Instanciacion ArrayLists
        for (int i = 0; i < HighSchoolModality.values().length; i++) {
            al.add(new ArrayList<>());
        }

        //Filtrado de de asignaturas "HighSchool"
        for (int i = 0; i < sb.length; i++) {

            if (sb[i] instanceof HighSchool) {

                hs = (HighSchool) sb[i];

                int counter = 0;
                //Insertarlas en la posición correcta del arrayList.
                while (hs.getModality()!= HighSchoolModality.values()[counter]) {

                    counter++;

                }

                al.get(counter).add(hs);

            }

        }

        //Ordenar arrayLists y agregarlos al string. 
        for (int i = 0; i < al.size(); i++) {

            Collections.sort(al.get(i));
            s += "\n "+ HighSchoolModality.values()[i].toString() +" \n";
            for (int j = 0; j < al.get(i).size(); j++) {

                s += al.get(i).get(j).toString() + "\n";
            }

        }

        return s;
    }

    /**
     * Crea una pequeña ventana donde se muestra información del programa.
     *
     * El formato es el siguiente:
     *
     * Título Info: Version: Developers: Contact:
     */
    public void programInfo() {        
        JOptionPane.showMessageDialog(null, "School Program\n"
                + "Info: School Program is based on a free licence.\n"
                + "Version: 1.0 "
                + "\nDevelopers: Eugenio Doñaque and Nadal Llabrés\nContact: "
                + "developers@schoolproject.com", "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public String arraysToString() {
        
        String s = "********************STUDENTS********************\n";        
        
        for (int i = 0; i < 500; i++) {
            
            s += students[i].toString() + "\n";
            
        }
        
        s += "********************TEACHERS********************\n";
        
        for (int i = 0; i < teachers.length; i++) {
            
            s += teachers[i].toString() + "\n";
            
        }
        
        s += "********************SUBJECTS********************\n";
        
        for (int i = 0; i < subjects.length; i++) {
            
            s += subjects[i].toString() + "\n";
            
        }
        
        return s;        
        
    }
    
    public String getCurrentTime() {

        //Declaraciones
        String s = "";        
        String dateFormat = "HH:mm:ss";        
        
        Date date = new Date();
        SimpleDateFormat objDateFormat = new SimpleDateFormat(dateFormat);
        
        s += objDateFormat.format(date);
        
        return s;        
    }
    
    public void enableItemsAndButtons() {
        
        //Ítems
        jmAcc2.setEnabled(true);
        jmAcc3.setEnabled(true);
        jmAcc4.setEnabled(true);
        jmAcc5.setEnabled(true);
        jmAcc6.setEnabled(true);
        jmAcc7.setEnabled(true);
        jmAcc8.setEnabled(true);
        
        //Buttons
        jbAcc2.setEnabled(true);
        jbAcc3.setEnabled(true);
        jbAcc4.setEnabled(true);
        jbAcc5.setEnabled(true);
        jbAcc6.setEnabled(true);
        jbAcc7.setEnabled(true);
        jbAcc8.setEnabled(true);

        
    }
}
