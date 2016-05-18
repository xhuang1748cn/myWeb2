package cn.srn.web2.idworker;

import cn.srn.web2.PropFileReader;

/**
 * Created by Winter on 2016/4/22.
 */
public class IWConfiger {

    public static long SMS_SEQ_WORKID;          //短信序列号生成器工作ID
    public static long SMS_SEQ_WORKIDBITS;      //短信序列号最大ID -1 * -1 << sms_seq_workIdBits

    static {
        PropFileReader propFileReader = new PropFileReader(IWConfiger.class.getResourceAsStream("/idworker.properties"));
        SMS_SEQ_WORKID = propFileReader.getLongProperty("sms_seq_workId", 1L);
        SMS_SEQ_WORKIDBITS = propFileReader.getLongProperty("sms_seq_workIdBits", 4L);
    }

}
