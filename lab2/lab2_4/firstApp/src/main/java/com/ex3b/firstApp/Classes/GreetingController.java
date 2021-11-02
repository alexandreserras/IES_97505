package com.ex3b.firstApp.Classes;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Random;

/*
	Ate agora usei Madagascar, Toy Story, Rei Leão como filmes
	Como shows tenho : malucos do riso e Marvel
*/

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	

	@GetMapping("/api/quotes")
	public QuotesFi randomQuote(@RequestParam(value = "show", defaultValue = "1") String name) {
			try{
			int a = Integer.parseInt(name);
			

			ArrayList<Film> filmes = this.addFilmess();
			for (Film f: filmes){
				if (a == f.getId()){
					ArrayList<String> array = f.getQuotes();
			
					Random r = new Random();
					int low = 0;
					int high = array.size()-1;
					int result = r.nextInt(array.size());
					String ret = array.get(result);
						return new QuotesFi(f.getNome(),ret);
					}
			}
		}
		catch(Exception e){
			return new QuotesFi("none", "Página não encontrada");
		}
			return null;
			
		
	}
	@GetMapping("/api/shows")
	public ArrayList<ShortFilm> allShows(){
		ArrayList<Film> filmes = this.addFilmess();
		
		ArrayList<ShortFilm> ret = new ArrayList<>();
		
		for (Film a : filmes){
			System.out.println(a.getId());
			if (a.getTipo().equals("show")){
				System.out.println("oks");
				ret.add(new ShortFilm (a.getId(),a.getNome()));
			}
		}
		
	
		if (ret.size()==0){
			ret.add(new ShortFilm(-1,"Nenhum show disponivel"));
		}
		System.out.println("ANTES DO RET");
		
		return ret;
	}

	@GetMapping("/api/quote")
	public Quotes randomQuote() {
		ArrayList<String> array = this.retQuotes();
		
		Random r = new Random();
		int low = 0;
		int high = array.size()-1;
		int result = r.nextInt(array.size());
		String ret = array.get(result);
		return new Quotes(ret);
	}
	
	public ArrayList<String> retQuotes(){
		ArrayList<String> array = new ArrayList<>();
		array.add("Eu tenho dez anos. Minha vida está quase na metade e eu nem sei se eu sou preto com listras brancas ou branco com listras pretas!");
		array.add("O rei , Alex , o leão");
		array.add("Tenho duas notícias, uma boa e uma ruim. A boa é que vamos aterrissar, a ruim é que vamos cair!");
		array.add("Isto não é voar. Isto é cair, com estilo!");
		array.add("Ao infinito e além!");
		array.add("Quando vou te ver outra vez? Hoje à noite … quando eu sonhar");
		array.add("Para conseguir o que quer, você deve olhar além do que você vê.");
		array.add("A jornada de mil quilômetros começa com o primeiro passo.");
		array.add("Meu pai me mostrou todo o reino. Eu vou mandar nisso tudo! ");
		array.add("Ai Costa! A vida, Costa…");
		array.add("Vai lá, vai! Até a barraca abana.");
		array.add("Quer um produto químico, natural, ou assim-assim?");
		array.add("Ainda somos amigos, certo?");
		array.add("É este o meu segredo, Capitão. Estou sempre com raiva");
		array.add("Nós temos o Hulk");
		return array;
	}
	private ArrayList<Film> addFilmess(){
		ArrayList<Film> array = new ArrayList<>();
		Film mad = new Film(1,"Madagascar","film");
		mad.addQuote("Eu tenho dez anos. Minha vida está quase na metade e eu nem sei se eu sou preto com listras brancas ou branco com listras pretas!");
		mad.addQuote("O rei , Alex , o leão");
		mad.addQuote("Tenho duas notícias, uma boa e uma ruim. A boa é que vamos aterrissar, a ruim é que vamos cair!");
		array.add(mad);
		Film toy = new Film(2,"Toy Story","film");
		toy.addQuote("Isto não é voar. Isto é cair, com estilo!");
		toy.addQuote("Ao infinito e além!");
		toy.addQuote("Quando vou te ver outra vez? Hoje à noite … quando eu sonhar");
		array.add(toy);
		Film rei = new Film(3,"Rei Leão","film");
		rei.addQuote("Para conseguir o que quer, você deve olhar além do que você vê.");
		rei.addQuote("A jornada de mil quilômetros começa com o primeiro passo.");
		rei.addQuote("Meu pai me mostrou todo o reino. Eu vou mandar nisso tudo! ");
		array.add(rei);
		Film mal = new Film(4,"Malucos do riso","show");
		mal.addQuote("Ai Costa! A vida, Costa…");
		mal.addQuote("Vai lá, vai! Até a barraca abana.");
		mal.addQuote("Quer um produto químico, natural, ou assim-assim?");
		Film marvel= new Film(5,"Marvel","show");
		marvel.addQuote("Ainda somos amigos, certo?");
		marvel.addQuote("É este o meu segredo, Capitão. Estou sempre com raiva");
		marvel.addQuote("Nós temos o Hulk");
		array.add(mal);
		array.add(marvel);
		return array;
	}

}