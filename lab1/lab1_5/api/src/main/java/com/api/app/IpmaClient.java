package main.java.com.api.app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
public class IpmaClient {
    private static final int CITY_ID_AVEIRO = 1010500;
  
    private   static Logger logger = LogManager.getLogger();
    
    private static Call<CityForecast> cidadeByName;



    public static void callApi(ArrayList<String> cidade){
        System.out.println("ENTREI");
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
                        System.out.println( "Temperatura máxima em "+a.getLocal()+  " é de : " + forecast.getData().
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
