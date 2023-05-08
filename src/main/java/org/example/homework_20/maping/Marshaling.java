package org.example.homework_20.maping;



import org.example.homework_20.model.Student;

import javax.xml.bind.*;
import java.io.File;
import java.io.IOException;

public class Marshaling {
    public Student unmarshall() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Student.class);
        return (Student) context.createUnmarshaller()
                .unmarshal(new File("C:\\Users\\HP\\IdeaProjects\\HomeworksJavaAcademic\\src\\main\\resources\\students.xml"));
    }

    public static void main(String[] args) throws JAXBException, IOException {
        Marshaling marshaling = new Marshaling();
        System.out.println(marshaling.unmarshall());

    }
}
