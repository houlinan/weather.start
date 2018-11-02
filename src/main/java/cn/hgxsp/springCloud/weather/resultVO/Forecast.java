package cn.hgxsp.springCloud.weather.resultVO;

import lombok.Data;

import java.io.Serializable;

/**
 * DESC：未来天气
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/1
 * Time : 15:53
 */
@Data
public class Forecast implements Serializable {


    private static final long serialVersionUID = -3201704678264596074L;
    /**
     * date : 1日星期四
     * high : 高温 12℃
     * fengli : <![CDATA[<3级]]>
     * low : 低温 -6℃
     * fengxiang : 西北风
     * type : 晴
     */

    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;


}
