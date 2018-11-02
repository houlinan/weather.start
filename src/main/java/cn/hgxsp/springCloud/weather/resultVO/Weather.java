package cn.hgxsp.springCloud.weather.resultVO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * DESC：天气实体类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/1
 * Time : 15:41
 */
@Data
public class Weather implements Serializable {


    private static final long serialVersionUID = 1683441999745801938L;
    /**
     * yesterday : {"date":"31日星期三","high":"高温 8℃","fx":"西北风","low":"低温 -6℃","fl":"<![CDATA[<3级]]>","type":"晴"}
     * city : 鹤岗
     * forecast : [{"date":"1日星期四","high":"高温 12℃","fengli":"<![CDATA[<3级]]>","low":"低温 -6℃","fengxiang":"西北风","type":"晴"},{"date":"2日星期五","high":"高温 13℃","fengli":"<![CDATA[<3级]]>","low":"低温 -3℃","fengxiang":"西南风","type":"晴"},{"date":"3日星期六","high":"高温 12℃","fengli":"<![CDATA[<3级]]>","low":"低温 -2℃","fengxiang":"西风","type":"多云"},{"date":"4日星期天","high":"高温 2℃","fengli":"<![CDATA[3-4级]]>","low":"低温 -10℃","fengxiang":"西北风","type":"雨夹雪"},{"date":"5日星期一","high":"高温 2℃","fengli":"<![CDATA[<3级]]>","low":"低温 -10℃","fengxiang":"西北风","type":"晴"}]
     * ganmao : 昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。
     * wendu : 11
     */

    private Yesterday yesterday;
    private String city;
    private String ganmao;
    private String wendu;
    private List<Forecast> forecast;

}
