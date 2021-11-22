package org.user.usermgmt.impl;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import org.user.usermgmt.api.UsermgmtService;

import java.util.concurrent.CompletableFuture;


public class UsermgmtServiceImpl implements UsermgmtService {

    @Override
    public ServiceCall<NotUsed, String> test() {

        ServiceCall<NotUsed, String> notUsedStringServiceCall = notUsed -> {
            return CompletableFuture.supplyAsync(() -> {
                return "user api test..";
            });
        };
        return notUsedStringServiceCall;
    }
}
