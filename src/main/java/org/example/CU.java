package org.example;// src/main/java/CU.java

import java.util.ArrayList;
import java.util.List;

public class CU {
    private String nameCU;
    private List<Mark> marks;
    private int totalStudents;

    public CU(String nameCU, int totalStudents) {
        this.nameCU = nameCU;
        this.totalStudents = totalStudents;
        this.marks = new ArrayList<>();
    }

    // Método para inserir uma nota na UC
    public boolean insertMarkCU(int numStudent, double mark) {
        if (marks.size() >= totalStudents) {
            return false; // limite de alunos atingido
        }
        marks.add(new Mark(numStudent, mark));
        return true;
    }

    // Método para buscar a nota de um aluno
    public double searchStudent(int numStudent) {
        for (Mark m : marks) {
            if (m.getNumStudent() == numStudent) {
                return m.getMark();
            }
        }
        return -1; // Aluno não encontrado
    }

    // Método para calcular a média das notas da UC
    public double averageCU() {
        if (marks.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (Mark m : marks) {
            sum += m.getMark();
        }
        return sum / marks.size();
    }

    // Método para verificar se o aluno foi aprovado
    public boolean isApproved(int numStudent) {
        double mark = searchStudent(numStudent);
        return mark >= 9.5;
    }
}
