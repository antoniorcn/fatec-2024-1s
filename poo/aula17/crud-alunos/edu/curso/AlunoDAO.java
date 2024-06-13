package edu.curso;

import java.util.List;
import java.util.ArrayList;

public interface AlunoDAO { 
    public void adicionar(Aluno a) throws AlunoException;
    public List<Aluno> pesquisarTodos() throws AlunoException;
    public List<Aluno> pesquisarPorNome(String nome) throws AlunoException;
    public void remover(long id) throws AlunoException;
    public void atualizar(long id, Aluno a) throws AlunoException;
}