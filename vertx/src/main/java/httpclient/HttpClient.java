package httpclient;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import lombok.Data;

/**
 * 基于vert.x实现的http客户端
 *
 * @author ：yansiqi
 * @date ：2020/5/25 15:20
 */
@Data
public class HttpClient extends AbstractVerticle {
    /**
     * http客户端
     */
    private WebClient client;
    /**
     * http客户端配置
     */
    private WebClientOptions options;

    @Override
    public void start() {
        options = new WebClientOptions();
        options.setUserAgent("My-App/1.2.3").
                setKeepAlive(false);
        client = WebClient.create(vertx, options);
    }
}
