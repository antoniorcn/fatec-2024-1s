package edu.curso;

import java.time.LocalDate;

public class Aluno { 
    private long id;
    private String ra;
    private String nome;
    private LocalDate nascimento;

    public long getId() { 
        return id;
    }
    public void setId(long value) { 
        this.id = value;
    }

    public String getRa() { 
        return ra;
    }
    public void setRa(String value) { 
        this.ra = value;
    }

    public String getNome() { 
        return nome;
    }
    public void setNome(String value) { 
        this.nome = value;
    }

    public LocalDate getNascimento() { 
        return nascimento;
    }
    public void setNascimento(LocalDate value) { 
        this.nascimento = value;
    }
}