package org.user.product.service.api;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

public interface ProductService extends Service {

    ServiceCall<NotUsed,String> productUserCallTest();


    @Override
    default Descriptor descriptor(){

       return Service.named("product-service")
                .withCalls(Service.
                                 restCall(Method.GET,"/api/test/user/call",this::productUserCallTest)
                ).withAutoAcl(true);


    }
}







