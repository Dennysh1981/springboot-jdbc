/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.tecsup.database;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.tecsup.database.dao.CursoDAO;
import pe.edu.tecsup.database.model.Curso;

/**
 *
 * @author Alumno
 */
public class CursoDAOTests {
    @Autowired
    CursoDAO CursoDAO;

    //@Test
    public void verifyList() {

        List<Curso> cursos = CursoDAO.list();
        for (Curso curso : cursos) {
            System.out.println(curso.getId() + " "+ curso.getNombre());
        }
        Assert.assertTrue(cursos.size() > 0);
    }

    //@Test
    public void verifyFind() {
        Curso curso = CursoDAO.get(1l);
        System.out.println(curso.getId() + " "+ curso.getNombre());
        Assert.assertTrue(curso.getId() == 1l);
    }

    @Test
    public void verifySave() {

        Curso programa = new Curso();
        programa.setCodigo("456");
        programa.setNombre("dennys");
       
        CursoDAO.save(programa);
        Assert.assertTrue(programa.getId() != null);
        
        System.out.println(programa.getNombre());
                
             
    }

    //@Test
    public void verifyUpdate() {

        // cambiar el código para validar
        Curso programa = new Curso();
        programa.setId(1l);
        programa.setCodigo("999");
        programa.setNombre("Programa Modificado");

        CursoDAO.update(programa);
        Assert.assertTrue(CursoDAO.get(1l).getCodigo().equals("999"));
    }

    //@Test
    public void verifyDelete() {

        Curso curso = new Curso();
        curso.setId(3l);
        CursoDAO.delete(curso);

        Assert.assertTrue(CursoDAO.get(3l) == null);
    }

}
