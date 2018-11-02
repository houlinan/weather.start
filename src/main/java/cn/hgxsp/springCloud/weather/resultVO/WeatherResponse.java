package cn.hgxsp.springCloud.weather.resultVO;

import lombok.Data;

import java.io.Serializable;

/**
 * DESC：响应返回对象
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/1
 * Time : 16:25
 */
@Data
public class WeatherResponse implements Serializable {


    private static final long serialVersionUID = 7479640857136293204L;
    /**
     * data :
     * status : 1000
     * desc : OK
     */

    private Weather data;
    private int status;
    private String desc;

    public WeatherResponse(){

    }

    public WeatherResponse(Weather data, int status, String desc) {
        this.data = data;
        this.status = status;
        this.desc = desc;
    }

    public static WeatherResponse ERROR(String msg ){
        return new WeatherResponse(null ,500 , msg) ;
    }

}
