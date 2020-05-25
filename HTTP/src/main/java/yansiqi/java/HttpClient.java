package yansiqi.java;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;


/**
 * @author ：yansiqi
 * @date ：2020/5/13 15:24
 */

@Slf4j
public class HttpClient {

    private String host = "127.0.0.1";
    private int port = 8891;

    /**
     * 建立clientNums个已连接的测试客户端，保存其channel
     */
    public void init() {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // 设置客户端引导
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup)
                    // 指定所使用的 NIO 传输 Channel
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializerImpl());
            // 连接服务器端口
            ChannelFuture future = bootstrap.connect(host, port).sync();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 加载多个channelHandler
     */
    final class ChannelInitializerImpl extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel channel) {
//            ChannelPipeline pipeline = channel.pipeline();
//            // 加入编码器
//            pipeline.addFirst(EdpEncoder.INSTANCE);
//            // 加入解码器
//            pipeline.addLast(new EdpDecoder());
        }
    }
}
