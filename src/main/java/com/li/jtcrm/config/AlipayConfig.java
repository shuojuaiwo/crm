package com.li.jtcrm.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AlipayConfig {
    // 应用ID,您的APPID,收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "2021000118684603";

    // 商户私钥，
    public static String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCbigaUGQliW5x+kCDVAQv7jK7L+pdq15pmRbejvjwKYugLOAw6Gcc9RSg33OrVg7g01fRgGJaz7n7iDgIjVDB/H7K1bpSpfwfT7ulP0ZzJFohTakBHY0Q9Znv6cHFrvp6QkcSiK4sheM3ZF3eLIReXSarqcoK95lr516rZfT/VVdcHmULuvl1vQ2BtfYUzMNiGocQUQAwoGn6YuaFVods0dlLMuMHu7sXFlBhwiVSu0GuL8ukNg+rWTFZQyUvBPkggAd36hAXSJk+PgoQUtgNj6JQWd1urKzqQ66cSu4clsBBD53zuUIs3qLO0u4sr5rmV/sACnIZK/72NLE963/rnAgMBAAECggEAdhHHvqJmykBKwpR8J9VcmD6J7hOy34r9DMe9iFH/V88O4H1SYsRwxyT5S7aqmRwdOBZ2JIBl3f6cWNNTcigVjFqumSVxOl1QvuOsPkgbIVa2c8PDOa2z/nwOfuTeZHDWA150CrrNKcJ/WF2FBJtBQjnMwZ3de3Qi+WdqrSBz1Wfd3bYe+/mUCQ7nobeB+k9jh7Hop39pww7xsbNClaO7p8Ll3JXYqzvDi1LgXjyMsPUXRYuaY1/uhz26d46UnBQXh1/iP1Z/Gkc0iwiss/uZXqFnEeIwutV+AESD67YWnhAKaVipRzTyZnceW8adkQN1H/xaGen1/1oUIjVAL9wq4QKBgQDPd2db8gIov7LkEU5eiP1J/29MKluUqY2lIlzuX/LcvV8lICfCdw5D5pqKW53cBzN2Mv//VGIItMQXSU6JYlq33YsLqDOfU9d1mdHE+ZD5QkDFEvqz2rLYLHSS5vAO/VMYI9Ya7KmxLYoWrem+ObR2ZQ8mIoUGekVvEM+1I9nfdwKBgQC/7NcuzqApNRLFAXkFYe5y9NEJEgD9IRE/cw221xW2raTQcc7Bw6G2v8YCw0wLI3bQ+TN2b6H+lNa0ykUFPhSkLpAmu42D4JON6ILFFQUD52FP8jS1X5xYIgT+pmjeToq2l1J6w4PCWJNOa2EoE1XbAE9+Qu6/+NLdegipe8n8EQKBgBcbIkzQOENXjlHuR38p3KPYKgoekZKOC7N/j0AROZgyEx2sZiE3Z0RSs5WDPKKbvrSEW5SRTlXP5CL/zBpq9NWTe//xXMZ67P0xA3bfoLDSGyqXwYo0akS/NsCBrezNc+q1WwwmnYOZIc8C0YyZGqsw+C30HEKrbX5ALhHri0FjAoGAaOVeWpPOD5eVUZ1TcrCqraPGmAmCBtdK4P3WEgeOM5DGUrLRCTAOM56u75Wj+zZ/2wlIqkOrK0RX8OnYPVxH1dApMzIwz1Iv81CQIH0zh4Wvtw0u566A+d5mEnQLPu14fQFJsBUp70+P+z1PFaMzuoV57Q1SBhRN04S+NTuWErECgYAen3O2W19Tvn0oXTCWcwrPlDkkZRVw9bjFwp6wb55QdInVH+3zg1ZXLElUIsgiKFi4DIQBlMGu1NN58lDSoU/JgeoGNoH7Jp6J0hKXAftPmXkZnfQgb1DZnoTxuw47pH2jItc6B3utt4hf286f9hQu2MJTBSYEHOHPXNiG3GQByA==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsV5dyNxjaQVgpM0ankcfMMxEEds8crp+JjKIJV9iFotGew/30aBSHBRpornLbkQtjFNmbHup728/2JKnUhays/Ts3LdobUkK1WBXg8N1rA8uMDbj/MICfV2lICFr3ZuHN/P1DO0TBaDdsaKJpsTWHAnh3rMk17cSPeepQ6N9XgBdeqUtmMq6rPLIEM9vMuUICwSoJmkeK2DnrosoUeQ4CR5PlR8srVDurF7NxwcZ0yZG9GVTj18+QpVHibVFEZzynUTHyPDhQkQja5ChR2J/ScS/lfsgutr5NrgrOmm1wrX2vrwFgcUPhoh5vc4GHRoz0BH/sKyoEb2pUzo6+iWZFQIDAQAB";
    // 服务器异步通知页面路径,需http://格式的完整路径，不能加自定义参数，必须外网可以正常访问
    //public static String notify_url = "http://8.142.96.162:8080/hello";
    public static String notify_url = "http://localhost:8080/hello";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能自定义参数，支付成功后返回的页面
    public static String return_url = "http://localhost:8080/returnCall";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    // 支付宝网关，这是沙箱的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
}
