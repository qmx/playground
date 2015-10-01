package me.qmx.uf.component.service;

import me.qmx.uf.component.model.MyModel;
import org.jboss.errai.bus.server.annotations.Remote;

@Remote
public interface MyService {

    MyModel execute( final String param );

}
