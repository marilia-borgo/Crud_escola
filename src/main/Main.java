package main;

import model.Aluno;
import model.Nota;
import model.Turma;

public class Main {
    public static void main(String[] args) {
        Turma turma = new Turma();

        double[] notas1 = {8.0, 7.5, 9.0, 6.5};
        double[] pesos1 = {1.0, 1.0, 1.0, 1.0};
        Nota nota1 = new Nota(notas1, pesos1);
        Aluno aluno1 = new Aluno("001", "Maria", "Computação", nota1);
        boolean inserido1 = turma.incluirAluno(aluno1);
        System.out.println("Aluno Maria inserido: " + inserido1);

        double[] notas2 = {9.0, 8.0, 8.5, 7.0};
        double[] pesos2 = {1.0, 1.0, 1.0, 1.0};
        Nota nota2 = new Nota(notas2, pesos2);
        Aluno aluno2 = new Aluno("002", "João", "Engenharia", nota2);
        boolean inserido2 = turma.incluirAluno(aluno2);
        System.out.println("Aluno João inserido: " + inserido2);

        boolean inseridoDuplicado = turma.incluirAluno(aluno1);
        System.out.println("Tentativa de inserir Maria novamente: " + inseridoDuplicado);

        double[] novasNotas = {7.0, 8.0, 7.5, 9.0};
        Nota novaNota = new Nota(novasNotas, pesos2);
        boolean alterado = turma.alterarAluno("001", "Maria da Silva", "Engenharia de Software", novaNota);
        System.out.println("Dados de Maria alterados: " + alterado);

        Aluno consultaPorNome = turma.consultarPorNome("Maria da Silva");
        System.out.println("Consulta por nome Maria da Silva: " + consultaPorNome);

        Aluno consultaPorMatricula = turma.consultarPorMatricula("002");
        System.out.println("Consulta por matrícula 002: " + consultaPorMatricula);

        boolean excluido = turma.excluirAlunoPorNome("João");
        System.out.println("Aluno João excluído: " + excluido);

        System.out.println("Lista de alunos após inserções e exclusões:");
        turma.imprimirListaAlunos();

        boolean existeMatricula = turma.validarMatricula("001");
        System.out.println("Aluno com matrícula 001 já foi inserido: " + existeMatricula);

        boolean existeMatriculaNaoInserido = turma.validarMatricula("003");
        System.out.println("Aluno com matrícula 003 não foi inserido: " + existeMatriculaNaoInserido);
    }
}
