// src/test/java/CUTest.java

import static org.junit.jupiter.api.Assertions.*;

import org.example.CU;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CUTest {

    private CU cu;

    @BeforeEach
    public void setUp() {
        cu = new CU("Matemática", 5);
        cu.insertMarkCU(1, 15.0);
        cu.insertMarkCU(2, 12.5);
        cu.insertMarkCU(3, 8.0);
        cu.insertMarkCU(4, 18.5);
        cu.insertMarkCU(5, 10.0);
    }

    // Teste parametrizado para verificar se a nota do aluno está correta
    @ParameterizedTest
    @CsvSource({
            "1, 15.0",
            "2, 12.5",
            "3, 8.0",
            "4, 18.5",
            "5, 10.0",
            "6, -1" // Aluno inexistente
    })
    public void testSearchStudent(int numStudent, double expectedMark) {
        assertEquals(expectedMark, cu.searchStudent(numStudent), "A nota deve ser: " + expectedMark);
    }

    // Teste para a média das notas na UC
    @Test
    public void testAverageCU() {
        assertEquals(12.8, cu.averageCU(), 0.1, "A média da UC deve ser aproximadamente 12.8");
    }

    // Teste parametrizado para verificar se o aluno foi aprovado
    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, true",
            "3, false",
            "4, true",
            "5, true"
    })
    public void testIsApproved(int numStudent, boolean isApproved) {
        assertEquals(isApproved, cu.isApproved(numStudent), "A aprovação esperada para o aluno " + numStudent + " é: " + isApproved);
    }

    // Teste para inserção de nota em uma UC com limite de alunos
    @Test
    public void testInsertMarkCUMaxStudents() {
        assertFalse(cu.insertMarkCU(6, 14.0), "Não deve permitir inserir aluno além do limite");
    }
}
