package yansiqi.java;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * Hello world!
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        String str="00000000000000000000000008004500022b2bb24000400600007f0000017f000001e62b22bb4d15f24158fcc45450180800fb940000504f5354202f76312f646576696365732f72656720485454502f312e310d0a417574686f72697a6174696f6e3a2065743d32353134373231363030313437266d6574686f643d73686131267265733d70726f64756374732f33383630392676657273696f6e3d323031382d31302d3331267369676e3d6174426e506a31654449744c5478546354754e637344615025324262772533440d0a436f6e74656e742d547970653a206170706c69636174696f6e2f6a736f6e0d0a557365722d4167656e743a20506f73746d616e52756e74696d652f372e32332e300d0a4163636570743a202a2f2a0d0a43616368652d436f6e74726f6c3a206e6f2d63616368650d0a506f73746d616e2d546f6b656e3a2037656166623633612d383533622d343561372d616538332d3961366161366364376234380d0a486f73743a203132372e302e302e313a383839310d0a4163636570742d456e636f64696e673a20677a69702c206465666c6174652c2062720d0a436f6e74656e742d4c656e6774683a203130300d0a436f6e6e656374696f6e3a206b6565702d616c6976650d0a0d0a7b0d0a2020226e616d65223a2279616e73697169222c0d0a20202264657363223a223534313437222c0d0a2020226b6579223a22546156487a6837324c596a3242503272424b2f7350687876746136344156314c72417278462f53754f43303d220d0a7d";
        String regex = "(.{2})";
        String str1= str.replaceAll(regex, "$1 ");
        log.info(str1);



        Scanner sc = new Scanner(System.in);
        HMACSHA1 hmacsha1 = new HMACSHA1();
        String pid;
        String accessKey;
        long time;
        while (true) {
            int tokenType = 0;
            System.out.println("请输入token类型：1.产品级token，2.设备级token。");
            tokenType = sc.nextInt();
            if (tokenType == 1) {
                System.out.println("请输入pid：");
                pid = sc.next();
                System.out.println("请输入accessKey：");
                accessKey = sc.next();
                System.out.println("请输入过期时间点：");
                time = sc.nextLong();
                log.info("pid={},accessKey={},过期时间={}。", pid, accessKey, time);
                System.out.println("计算出的产品级token为：");
                System.out.println(hmacsha1.calcProductToken(pid, accessKey, time));
                System.out.println("可再次计算");
            } else if (tokenType == 2) {
                String authinfo;
                System.out.println("请输入pid：");
                pid = sc.next();
                System.out.println("请输入accessKey：");
                accessKey = sc.next();
                System.out.println("请输入authinfo：");
                authinfo = sc.next();
                System.out.println("请输入过期时间点：");
                time = sc.nextLong();
                log.info("pid={},accessKey={},authinfo={},过期时间={}。", pid, accessKey, authinfo, time);
                System.out.println("计算出的设备级token为：");
                System.out.println(hmacsha1.calcDeviceToken(pid, accessKey, authinfo, time));
                System.out.println("可再次计算");
            } else {
                System.out.println("不正确的token类型类型:" + tokenType + "，请重新输入token类型：1.产品级token，2.设备级token。");
            }
        }
    }
}
