package org.wildfly.s2i.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class JaxrsConfiguration extends Application {
}
