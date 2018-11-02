package cn.hgxsp.springCloud.weather.service.impl;

import cn.hgxsp.springCloud.weather.resultVO.Weather;
import cn.hgxsp.springCloud.weather.resultVO.WeatherResponse;
import cn.hgxsp.springCloud.weather.service.WeatherDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * DESC：
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/1
 * Time : 16:43
 */
@Service
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService {

    @Autowired
    private RestTemplate restTemplate ;

    @Value("${getWeatherUrl}")
    private String getWeatherUrl ;

    private static final String GETBYIDTYPE = "citykey=" ;

    private static final String GETBYNAMETYPE = "city=" ;

    @Override
    public WeatherResponse getDataByCityId(String id) {
        return doGetWeather(id , GETBYIDTYPE) ;
    }


    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        return doGetWeather(cityName , GETBYNAMETYPE) ;
    }


    /**
    *DESC:获取天气数据封装方法
    *@author hou.linan
    *@date:  2018/11/1 17:10
    *@param:  [value, keyType]
    *@return:  cn.hgxsp.springCloud.weather.resultVO.WeatherResponse
    */
    private WeatherResponse doGetWeather(String value , String keyType){

        String getDataUrl = getWeatherUrl + keyType +  value ;
//
//        ResponseEntity<WeatherResponse> result = restTemplate.getForEntity(getDataUrl, WeatherResponse.class);
//
//        if(result.getStatusCode() != HttpStatus.OK)  return null ;
//
//        return result.getBody() ;


        //发起请求
        ResponseEntity<String> result = restTemplate.getForEntity(getDataUrl, String.class);


        ObjectMapper objectMapper = new ObjectMapper( );
        WeatherResponse resp = null;
        String strBody = null;
        String strBody1 = null;

        if(result.getStatusCode() == HttpStatus.OK)  strBody = result.getBody();

        try {
            resp = objectMapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resp;

    }


}
