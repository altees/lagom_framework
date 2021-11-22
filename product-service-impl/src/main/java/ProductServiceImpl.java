import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import lombok.extern.slf4j.Slf4j;
import org.user.product.service.api.ProductService;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class ProductServiceImpl implements ProductService {


    @Override
    public ServiceCall<NotUsed, String> productUserCallTest() {

        ServiceCall<NotUsed, String>call = request->{
                    return CompletableFuture.supplyAsync(()->{
                return "product-service-test";
            });
        };
        return call;
    }
}
