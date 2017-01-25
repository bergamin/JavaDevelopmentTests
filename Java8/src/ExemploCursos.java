
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guilherme
 */
class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}

public class ExemploCursos {
    public static void main(String[] args){
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));
        
        cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
        
        cursos.stream()
                .map(c -> c.getNome());
//                .filter(c -> c.getAlunos() > 50)
//                .forEach(c -> System.out.println(c.getNome()));
//                .mapToInt(c -> c.getAlunos())
//                .sum();
    }
}