package com.MyWeatherRadar;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.*;
//import java.util.logging.Logger;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    private static final int CITY_ID_AVEIRO = 1010500;
    /*
    loggers provide a better alternative to System.out.println
    https://rules.sonarsource.com/java/tag/bad-practice/RSPEC-106
     */
    //private static Logger logger = LogManager.getLogger(WeatherStarter.class.getName());
    private   static Logger logger = LogManager.getLogger(WeatherStarter.class.getName());
    
    private static Call<CityForecast> cidadeByName;

    public static void  main(String[] args ) {
        ArrayList<String> cidade = new ArrayList<>();
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
        /*
        get a retrofit instance, loaded with the GSon lib to convert JSON into objects
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IpmaService service = retrofit.create(IpmaService.class);
        Call<IpmaCityForecast>  cidadeByName = service.getCidadeByName();
        try {
            Response<IpmaCityForecast> data = cidadeByName.execute();
            List<CityForecast> res= data.body().getData();
            
         //tenho a lista completa
        for (String local: cidade){
            boolean control=false;
                for (CityForecast a: res){
                    if (local.equals(a.getLocal())){
                        control=true;
                        Call<IpmaCityForecast> callSync = service.getForecastForACity(a.getGlobalIdLocal());
                        Response<IpmaCityForecast> apiResponse = callSync.execute();
                        IpmaCityForecast forecast = apiResponse.body();
                        logger.info( "Temperatura máxima em "+a.getLocal()+  " é de : " + forecast.getData().
                        listIterator().next().getTMax());
                    }
                }
            if( ! control){
                control=true;
                logger.info(" não existe na base de dados " );
            }

            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
    }
       

    }
}