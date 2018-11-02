package cn.hgxsp.springCloud.weather.service;

import cn.hgxsp.springCloud.weather.resultVO.ResResult;
import cn.hgxsp.springCloud.weather.resultVO.WeatherResponse;
import org.springframework.stereotype.Service;

/**
 * DESC：天气数据服务接口
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/1
 * Time : 16:28
 */
public interface WeatherDataService {


    /**
    *DESC: 根据城市ID获取城市数据
    *@author hou.linan
    *@date:  2018/11/1 16:29
    *@param:  [id]
    *@return:  cn.hgxsp.springCloud.weather.resultVO.WeatherResponse
    */
    ResResult getDataByCityId(String id) ;


    /**
    *DESC:根据城市名称获取城市数据
    *@author hou.linan
    *@date:  2018/11/1 16:30
    *@param:  [cityName]
    *@return:  cn.hgxsp.springCloud.weather.resultVO.WeatherResponse
    */
    ResResult getDataByCityName(String cityName) ;

}
