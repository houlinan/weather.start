package cn.hgxsp.springCloud.weather.service.impl;

import cn.hgxsp.springCloud.weather.resultVO.ResResult;
import cn.hgxsp.springCloud.weather.resultVO.WeatherResponse;
import cn.hgxsp.springCloud.weather.resultVO.Yesterday;
import cn.hgxsp.springCloud.weather.service.WeatherDataService;
import cn.hgxsp.springCloud.weather.utils.RedisOperator;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.java.Log;
import org.slf4j.Logger;
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
public class WeatherDataServiceImpl implements WeatherDataService {

    @Autowired
    private RestTemplate restTemplate ;

    @Autowired
    private RedisOperator redisOperator ;

    @Value("${getWeatherUrl}")
    private String getWeatherUrl ;

    private static final String GETBYIDTYPE = "citykey=" ;

    private static final String GETBYNAMETYPE = "city=" ;

    @Override
    public ResResult getDataByCityId(String id) {
        return doGetWeather(id , GETBYIDTYPE) ;
    }


    @Override
    public ResResult getDataByCityName(String cityName) {
        return doGetWeather(cityName , GETBYNAMETYPE) ;
    }


    /**
    *DESC:获取天气数据封装方法
    *@author hou.linan
    *@date:  2018/11/1 17:10
    *@param:  [value, keyType]
    *@return:  cn.hgxsp.springCloud.weather.resultVO.WeatherResponse
    */
    private ResResult doGetWeather(String value , String keyType){

        String getDataUrl = getWeatherUrl + keyType +  value ;

        String rediskey = keyType + ":" + value ;

        // 先从缓存中获取数据  如果存在则return
        ResResult resp = null;
        String strBody = null;
        ObjectMapper objectMapper = new ObjectMapper();
        if(! redisOperator.hasKey(rediskey)) {

            //发起请求
            ResponseEntity<String> result = restTemplate.getForEntity(getDataUrl, String.class);

            System.out.println("缓存中没有数据， 这里发起请求，获取数据");

            if (result.getStatusCode() == HttpStatus.OK) strBody = result.getBody();

            redisOperator.set(rediskey ,strBody ,  1800  );
        }else{
            strBody = redisOperator.get(rediskey) ;
        }
        System.out.println("strBody = " + strBody );

        try {
            resp = objectMapper.readValue(strBody, ResResult.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null ;
        }

        return resp;

    }


    public static void main(String[] args) throws  Exception {
     String str = "{\n" +
             "  \"data\": {\n" +
             "    \"yesterday\": {\n" +
             "      \"date\": \"1日星期四\",\n" +
             "      \"high\": \"高温 12℃\",\n" +
             "      \"fx\": \"西北风\",\n" +
             "      \"low\": \"低温 -6℃\",\n" +
             "      \"fl\": \"<![CDATA[<3级]]>\",\n" +
             "      \"type\": \"晴\"\n" +
             "    },\n" +
             "    \"city\": \"鹤岗\",\n" +
             "    \"forecast\": [\n" +
             "      {\n" +
             "        \"date\": \"2日星期五\",\n" +
             "        \"high\": \"高温 13℃\",\n" +
             "        \"fengli\": \"<![CDATA[<3级]]>\",\n" +
             "        \"low\": \"低温 -2℃\",\n" +
             "        \"fengxiang\": \"西南风\",\n" +
             "        \"type\": \"晴\"\n" +
             "      },\n" +
             "      {\n" +
             "        \"date\": \"3日星期六\",\n" +
             "        \"high\": \"高温 11℃\",\n" +
             "        \"fengli\": \"<![CDATA[<3级]]>\",\n" +
             "        \"low\": \"低温 -4℃\",\n" +
             "        \"fengxiang\": \"西南风\",\n" +
             "        \"type\": \"多云\"\n" +
             "      },\n" +
             "      {\n" +
             "        \"date\": \"4日星期天\",\n" +
             "        \"high\": \"高温 2℃\",\n" +
             "        \"fengli\": \"<![CDATA[<3级]]>\",\n" +
             "        \"low\": \"低温 -9℃\",\n" +
             "        \"fengxiang\": \"西北风\",\n" +
             "        \"type\": \"多云\"\n" +
             "      },\n" +
             "      {\n" +
             "        \"date\": \"5日星期一\",\n" +
             "        \"high\": \"高温 2℃\",\n" +
             "        \"fengli\": \"<![CDATA[<3级]]>\",\n" +
             "        \"low\": \"低温 -10℃\",\n" +
             "        \"fengxiang\": \"西北风\",\n" +
             "        \"type\": \"晴\"\n" +
             "      },\n" +
             "      {\n" +
             "        \"date\": \"6日星期二\",\n" +
             "        \"high\": \"高温 4℃\",\n" +
             "        \"fengli\": \"<![CDATA[<3级]]>\",\n" +
             "        \"low\": \"低温 -8℃\",\n" +
             "        \"fengxiang\": \"西南风\",\n" +
             "        \"type\": \"晴\"\n" +
             "      }\n" +
             "    ],\n" +
             "    \"ganmao\": \"昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。\",\n" +
             "    \"wendu\": \"11\"\n" +
             "  },\n" +
             "  \"status\": 1000,\n" +
             "  \"desc\": \"OK\"\n" +
             "}";

//        ObjectMapper objectMapper = new ObjectMapper();
//        WeatherResponse resp = objectMapper.readValue(str, WeatherResponse.class);
////        WeatherResponse weatherResponse = JSONObject.toJavaObject(JSON.parseObject(str), WeatherResponse.class);
//        System.out.println(JSONObject.toJSONString(resp));



        ObjectMapper objectMapper = new ObjectMapper( );
        WeatherResponse resp = null;
        String strBody = null;
        String strBody1 = null;


        try {
            resp = objectMapper.readValue(str, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(resp);
    }


}
