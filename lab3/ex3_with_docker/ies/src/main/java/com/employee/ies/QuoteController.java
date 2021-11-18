package com.employee.ies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteController {
    @Autowired
    private QuoteService service;

    @Autowired
    private ProductQuote service2;

    
    @PostMapping("/addQuote")
    public Quote newQuotes( @RequestBody newQuote m) {
        return service.saveQuote(new Quote (m.getQuote(),service2.getMovieById(m.getShowId())));
    }


    @GetMapping("/quote")
    public Quote findAllQuotes() {
        List<Quote> a = service.getQuotes();
        Quote ret;
        if (a.size() >0 ){
             Random r = new Random();
		int low = 0;
		int high = a.size()-1;
		int result = r.nextInt(a.size());
         ret = a.get(result);
        }
        else{
            ret = new Quote();
        }
        return ret;
    }

    @GetMapping("/quotes")
    public Quote findQuoteById(@RequestParam(value = "show")  int id) {
        List<Quote> a = service.getQuotes();
        List<Quote> rets= new ArrayList<>();
        for (Quote qu: a){
            if (qu.getOrder().getId() == id ){
                rets.add(qu);
            }
        }
        Random r = new Random();
		int low = 0;
		int high = rets.size()-1;
		int result = r.nextInt(rets.size());
        Quote ret = rets.get(result);
        return ret;
    }



    @PutMapping("/updateQuote")
    public Quote updateQuote(@RequestBody Quote product) {
        return service.updateQuote(product);
    }

    
    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie m) {
        return service2.saveMovie(m);
    }

   

    @GetMapping("/shows")
    public List<Movie> findAllMovies() {
        return service2.getMovies();
    }

   

    

    @PutMapping("/update")
    public Movie updateProduct(@RequestBody Movie product) {
        return service2.updateMovie(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable int id) {
        return service2.deleteMovie(id);
    }
}
