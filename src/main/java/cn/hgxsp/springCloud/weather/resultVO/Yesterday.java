package cn.hgxsp.springCloud.weather.resultVO;

import lombok.Data;

import java.io.Serializable;

/**
 * DESC：昨日天气
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/1
 * Time : 15:52
 */
@Data
public class Yesterday implements Serializable {


    private static final long serialVersionUID = 6352174342699644753L;
    /**
     * date : 31日星期三
     * high : 高温 8℃
     * fx : 西北风
     * low : 低温 -6℃
     * fl : <![CDATA[<3级]]>
     * type : 晴
     */

    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;


}
