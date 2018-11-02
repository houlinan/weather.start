package cn.hgxsp.springCloud.weather.resultVO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * DESC：
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/2
 * Time : 12:25
 */
@Data
public class ResResult implements Serializable {


    private static final long serialVersionUID = -3342852380902996417L;

    public ResResult(){}

    public ResResult(DataBean data, int status, String desc){
        this.data = data;
        this.status = status;
        this.desc = desc;
    }

    public static ResResult ERROR(String msg ){
        return new ResResult(null ,500 , msg) ;
    }
    /**
     * data : {"yesterday":{"date":"1日星期四","high":"高温 12℃","fx":"西北风","low":"低温 -6℃","fl":"<![CDATA[<3级]]>","type":"晴"},"city":"鹤岗","forecast":[{"date":"2日星期五","high":"高温 13℃","fengli":"<![CDATA[<3级]]>","low":"低温 -2℃","fengxiang":"西南风","type":"晴"},{"date":"3日星期六","high":"高温 11℃","fengli":"<![CDATA[<3级]]>","low":"低温 -4℃","fengxiang":"西南风","type":"多云"},{"date":"4日星期天","high":"高温 2℃","fengli":"<![CDATA[<3级]]>","low":"低温 -9℃","fengxiang":"西北风","type":"多云"},{"date":"5日星期一","high":"高温 2℃","fengli":"<![CDATA[<3级]]>","low":"低温 -10℃","fengxiang":"西北风","type":"晴"},{"date":"6日星期二","high":"高温 4℃","fengli":"<![CDATA[<3级]]>","low":"低温 -8℃","fengxiang":"西南风","type":"晴"}],"ganmao":"昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。","wendu":"11"}
     * status : 1000
     * desc : OK
     */

    private DataBean data;
    private int status;
    private String desc;


    public static class DataBean {
        /**
         * yesterday : {"date":"1日星期四","high":"高温 12℃","fx":"西北风","low":"低温 -6℃","fl":"<![CDATA[<3级]]>","type":"晴"}
         * city : 鹤岗
         * forecast : [{"date":"2日星期五","high":"高温 13℃","fengli":"<![CDATA[<3级]]>","low":"低温 -2℃","fengxiang":"西南风","type":"晴"},{"date":"3日星期六","high":"高温 11℃","fengli":"<![CDATA[<3级]]>","low":"低温 -4℃","fengxiang":"西南风","type":"多云"},{"date":"4日星期天","high":"高温 2℃","fengli":"<![CDATA[<3级]]>","low":"低温 -9℃","fengxiang":"西北风","type":"多云"},{"date":"5日星期一","high":"高温 2℃","fengli":"<![CDATA[<3级]]>","low":"低温 -10℃","fengxiang":"西北风","type":"晴"},{"date":"6日星期二","high":"高温 4℃","fengli":"<![CDATA[<3级]]>","low":"低温 -8℃","fengxiang":"西南风","type":"晴"}]
         * ganmao : 昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。
         * wendu : 11
         */

        private YesterdayBean yesterday;
        private String city;
        private String aqi ;
        private String ganmao;
        private String wendu;
        private List<ForecastBean> forecast;


        public static class YesterdayBean {
            /**
             * date : 1日星期四
             * high : 高温 12℃
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

        public static class ForecastBean {
            /**
             * date : 2日星期五
             * high : 高温 13℃
             * fengli : <![CDATA[<3级]]>
             * low : 低温 -2℃
             * fengxiang : 西南风
             * type : 晴
             */

            private String date;
            private String high;
            private String fengli;
            private String low;
            private String fengxiang;
            private String type;


        }
    }
}
