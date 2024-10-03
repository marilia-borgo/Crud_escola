package model;

import java.util.HashMap;
import java.util.Map;

public class Turma {
    private Map<String, Aluno> alunos;

    // usando um hash map na refatoração
    public Turma() {
        alunos = new HashMap<>();
    }

    public boolean incluirAluno(Aluno aluno) {
        if (alunos.containsKey(aluno.getMatricula())) {
            return false;
        }
        alunos.put(aluno.getMatricula(), aluno);
        return true;
    }

    public boolean alterarAluno(String matricula, String novoNome, String novoCurso, Nota novaNota) {
        Aluno aluno = alunos.get(matricula);
        if (aluno != null) {
            aluno.setNome(novoNome);
            aluno.setCurso(novoCurso);
            aluno.setNota(novaNota);
            return true;
        }
        return false;
    }

    public Aluno consultarPorNome(String nome) {
        for (Aluno aluno : alunos.values()) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }

    public Aluno consultarPorMatricula(String matricula) {
        return alunos.get(matricula);
    }

    public boolean excluirAlunoPorNome(String nome) {
        String matriculaParaRemover = null;
        for (Aluno aluno : alunos.values()) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                matriculaParaRemover = aluno.getMatricula();
                break;
            }
        }
        if (matriculaParaRemover != null) {
            alunos.remove(matriculaParaRemover);
            return true;
        }
        return false;
    }

    public void imprimirListaAlunos() {
        for (Aluno aluno : alunos.values()) {
            System.out.println(aluno);
        }
    }

    public boolean validarMatricula(String matricula) {
        return alunos.containsKey(matricula);
    }
}
