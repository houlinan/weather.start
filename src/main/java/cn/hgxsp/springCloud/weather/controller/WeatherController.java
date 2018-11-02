package cn.hgxsp.springCloud.weather.controller;

import cn.hgxsp.springCloud.weather.resultVO.ResResult;
import cn.hgxsp.springCloud.weather.resultVO.WeatherResponse;
import cn.hgxsp.springCloud.weather.service.WeatherDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DESC：天气数据Controller层
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/1
 * Time : 17:05
 */
@RestController
@RequestMapping("/getData")
@Slf4j
public class WeatherController {

    @Autowired
    WeatherDataService weatherDataService ;

    @GetMapping("/getDataById")
    public ResResult getDataById(String id ){
        if(StringUtils.isEmpty(id)) return ResResult.ERROR("传入的ID为空");
        ResResult result = weatherDataService.getDataByCityId(id);
        if(ObjectUtils.isEmpty(result)) return ResResult.ERROR("没有获取到该城市数据");
        return result ;
    }

    @GetMapping("/getDataByName")
    public ResResult getDataByName(String cityName ){
        if(StringUtils.isEmpty(cityName)) return ResResult.ERROR("传入的ID为空");
        ResResult result = weatherDataService.getDataByCityName(cityName);
        if(ObjectUtils.isEmpty(result)) return ResResult.ERROR("没有获取到该城市数据");
        return result ;
    }


}
