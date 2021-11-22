package org.user.usermgmt.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

import org.user.usermgmt.api.UsermgmtService;

public class UsermgmtModule extends AbstractModule implements ServiceGuiceSupport {
    @Override
    protected void configure() {
        bindService(UsermgmtService.class, UsermgmtServiceImpl.class);
    }
}
