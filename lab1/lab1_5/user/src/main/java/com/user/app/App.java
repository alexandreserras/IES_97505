package com.user.app;

import java.util.ArrayList;

import  main.java.com.api.app.*;

public class App 
{
    public static void  main(String[] args ) {
        ArrayList<String> cidade = new ArrayList<String>();
        String def="Aveiro";
        if (args.length != 0 ){
            for (String a: args){
                cidade.add(a);
            }
        }
        else{
            cidade.add("Aveiro");
        }
        System.out.println(cidade);
        
    
        IpmaClient a = new IpmaClient();
        a.callApi(cidade);
        System.out.println("SAIIIIIIII");
        
        
    }
}
