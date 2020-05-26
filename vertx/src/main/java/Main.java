import httpclient.HttpClient;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

/**
 * @author ：yansiqi
 * @date ：2020/5/25 15:16
 */
public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        int instances = 2;
        DeploymentOptions options = new DeploymentOptions().setInstances(instances);
        String instanceName = HttpClient.class.getName();
        vertx.deployVerticle(instanceName, options, res -> {
            if (res.succeeded()) {
                System.out.println("\n" + instanceName + " 部署成功, ID是: " + res.result() + "\n");
            } else {
                System.out.println("\n" + instanceName + " 部署失败!" + "\n");
            }
        });
    }
}
