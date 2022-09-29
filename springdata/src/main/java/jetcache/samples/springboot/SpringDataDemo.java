/**
 * Created on 2018/8/11.
 */
package jetcache.samples.springboot;

import com.alicp.jetcache.anno.config.EnableMethodCache;
import jetcache.samples.springboot.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * @author <a href="mailto:areyouok@gmail.com">huangli</a>
 */
@SpringBootApplication
@EnableMethodCache(basePackages = {"jetcache","com.msa"})
public class SpringDataDemo {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringDataDemo.class);
        MyService myService = context.getBean(MyService.class);
        myService.createCacheDemo();
        myService.cachedDemo();
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            myService.createCacheDemo();
            //System.out.println(" ========================= ");
            myService.cachedDemo();
        }

    }
}
