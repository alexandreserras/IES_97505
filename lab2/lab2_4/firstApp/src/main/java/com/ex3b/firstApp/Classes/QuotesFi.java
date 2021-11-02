package com.ex3b.firstApp.Classes;

public class QuotesFi {
    private String quote;
    private String nome;
    public QuotesFi(String nome,String quote) {
        this.nome=nome;
        this.quote = quote;
    }

   

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
