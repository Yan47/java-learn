package yansiqi.java;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.Base64;

/**
 * 中移物联网计算mqtts的token的方法
 *
 * @author ：yansiqi
 * @date ：2020/1/3 16:20
 */
class HMACSHA1 {
    private static final String MAC_NAME = "HmacSHA1";
    private static final String ENCODING = "UTF-8";

    private String HmacSHA1Encrypt(String encryptText, String encryptKey) throws Exception {
        byte[] key = Base64.getDecoder().decode(encryptKey);
        //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(key, MAC_NAME);
        //生成一个指定 Mac 算法 的 Mac 对象
        Mac mac = Mac.getInstance(MAC_NAME);
        //用给定密钥初始化 Mac 对象
        mac.init(secretKey);
        byte[] text = encryptText.getBytes(ENCODING);
        //完成 Mac 操作
        return Base64.getEncoder().encodeToString(mac.doFinal(text));
    }

    String calcProductToken(String pid, String accessKey, long time) {
        String token = "";
        StringBuilder encryptTxt = new StringBuilder();
        String timeStr = String.valueOf(time);
        // 超时时间
        encryptTxt.append(timeStr);
        encryptTxt.append("\n");
        encryptTxt.append("sha1");
        encryptTxt.append("\n");
        encryptTxt.append("products/" + pid);
        encryptTxt.append("\n");
        encryptTxt.append("2018-10-31");
        try {
            String sign = HmacSHA1Encrypt(encryptTxt.toString(), accessKey);
            String urlSign = URLEncoder.encode(sign, "UTF-8");
            token = "et=" + time + "&method=sha1&res=products/" + pid + "&version=2018-10-31&sign=" + urlSign;
            return token;
        } catch (Exception e) {
            return token;
        }
    }

    String calcDeviceToken(String pid, String accessKey, String authinfo, long time) {
        String token = "";
        try {
            StringBuilder encryptTxt = new StringBuilder();
            String timeStr = String.valueOf(time);
            // 超时时间
            encryptTxt.append(timeStr);
            encryptTxt.append("\n");
            encryptTxt.append("sha1");
            encryptTxt.append("\n");
            encryptTxt.append("products/" + pid + "/devices/" + authinfo);
            encryptTxt.append("\n");
            encryptTxt.append("2018-10-31");

            String sign = HmacSHA1Encrypt(encryptTxt.toString(), accessKey);
            String urlSign = URLEncoder.encode(sign, "UTF-8");
            token = "et=" + time + "&method=sha1&res=products/" + pid + "/devices/" + authinfo + "&version=2018-10-31&sign=" + urlSign;
            return token;
        } catch (Exception e) {
            return token;
        }
    }
}
