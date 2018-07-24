package org.myleap.mlive.utils;

/**
 * Created by jwd on 2017/3/21.
 */
public class Constants {
//    public static final String HOST = "http://mplus.uicp.cn/mplusVod/";
    public static final String HOST = "http://www.myleap.cn:9090/myleapAdmin/index.php/v1/";
//    public static final String HOME = HOST + "home";
    public static final class NetStates {
        public static final int STATE_WIFI = 0;// 有WIFI
        public static final int STATE_4G_WITHOUT_WIFI = 1;// 有4G无WIFI
        public static final int STATE_NET_UNABLE = 2; // 断网
    }

}
