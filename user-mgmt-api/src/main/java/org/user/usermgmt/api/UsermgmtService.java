package org.user.usermgmt.api;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

public interface UsermgmtService extends Service {

    ServiceCall<NotUsed, String> test();


    @Override
    default Descriptor descriptor() {
        return named("usermgmt")
                .withCalls(
                        restCall(Method.GET,"/api/test", this::test)
                )
                .withAutoAcl(true);
    }
}
