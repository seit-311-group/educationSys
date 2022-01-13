package cn.sysu.educationSys.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

// 获取配置文件的类
@Component
@ConfigurationProperties(prefix = "path")        //用于绑定属性，其中prefix表示所绑定的属性的前缀。
@PropertySource({"classpath:config.properties"})
public class ConfigProperties {

    private String pic;     // 上传图片保存的路径
    private String algorithmSeverIpAndPort;

    public String getAlgorithmSeverIpAndPort() {
        return algorithmSeverIpAndPort;
    }

    public void setAlgorithmSeverIpAndPort(String algorithmSeverIpAndPort) {
        this.algorithmSeverIpAndPort = algorithmSeverIpAndPort;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
