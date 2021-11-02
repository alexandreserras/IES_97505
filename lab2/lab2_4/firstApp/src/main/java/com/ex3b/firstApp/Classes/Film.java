package com.ex3b.firstApp.Classes;

import java.util.ArrayList;
public class Film {

	private final long id;
	private ArrayList<String> quotes;
    private String nome;
    private String tipo;

	public Film(long id,String nome,String tipo) {
		this.id = id;
        this.nome=nome;
        this.tipo=tipo;
		quotes= new ArrayList<>();
	}

    public void addQuote(String a){
        this.quotes.add(a);
    }
	public long getId() {
		return id;
	}

    public ArrayList<String> getQuotes() {
        return quotes;
    }

    public void setQuotes(ArrayList<String> quotes) {
        this.quotes = quotes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}