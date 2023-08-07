/*
package api.service.hackatonv1.ecommerce;

import io.swagger.v3.oas.models.servers.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.embedded.jetty.JettyReactiveWebServerFactory;
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.embedded.netty.NettyRouteProvider;
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatReactiveWebServerFactory;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowReactiveWebServerFactory;
import org.springframework.boot.web.reactive.server.ReactiveWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.JettyResourceFactory;
import org.springframework.http.client.reactive.ReactorResourceFactory;
import reactor.netty.http.server.HttpServer;

import java.util.Collection;
import java.util.stream.Collectors;

abstract class Util2 {
    Util2() {
    }

    @Configuration(
            proxyBeanMethods = false
    )
    @ConditionalOnMissingBean({ReactiveWebServerFactory.class})
    @ConditionalOnClass({ServerProperties.Undertow.class})
    static class EmbeddedUndertow {
        EmbeddedUndertow() {
        }

        @Bean
        UndertowReactiveWebServerFactory undertowReactiveWebServerFactory(ObjectProvider<UndertowBuilderCustomizer> builderCustomizers) {
            UndertowReactiveWebServerFactory factory = new UndertowReactiveWebServerFactory();
            factory.getBuilderCustomizers().addAll((Collection) builderCustomizers.orderedStream().collect(Collectors.toList()));
            return factory;
        }
    }

    @Configuration(
            proxyBeanMethods = false
    )
    @ConditionalOnMissingBean({ReactiveWebServerFactory.class})
    @ConditionalOnClass({Server.class, ServletHolder.class})
    static class EmbeddedJetty {
        EmbeddedJetty() {
        }

        @Bean
        @ConditionalOnMissingBean
        JettyResourceFactory jettyServerResourceFactory() {
            return new JettyResourceFactory();
        }

        @Bean
        JettyReactiveWebServerFactory jettyReactiveWebServerFactory(JettyResourceFactory resourceFactory, ObjectProvider<JettyServerCustomizer> serverCustomizers) {
            JettyReactiveWebServerFactory serverFactory = new JettyReactiveWebServerFactory();
            serverFactory.getServerCustomizers().addAll((Collection) serverCustomizers.orderedStream().collect(Collectors.toList()));
            serverFactory.setResourceFactory(resourceFactory);
            return serverFactory;
        }
    }

    @Configuration(
            proxyBeanMethods = false
    )
    @ConditionalOnMissingBean({ReactiveWebServerFactory.class})
    @ConditionalOnClass({ServerProperties.Tomcat.class})
    static class EmbeddedTomcat {
        EmbeddedTomcat() {
        }

        @Bean
        TomcatReactiveWebServerFactory tomcatReactiveWebServerFactory(ObjectProvider<TomcatConnectorCustomizer> connectorCustomizers, ObjectProvider<TomcatContextCustomizer> contextCustomizers, ObjectProvider<TomcatProtocolHandlerCustomizer<?>> protocolHandlerCustomizers) {
            TomcatReactiveWebServerFactory factory = new TomcatReactiveWebServerFactory();
            factory.getTomcatConnectorCustomizers().addAll((Collection) connectorCustomizers.orderedStream().collect(Collectors.toList()));
            factory.getTomcatContextCustomizers().addAll((Collection) contextCustomizers.orderedStream().collect(Collectors.toList()));
            factory.getTomcatProtocolHandlerCustomizers().addAll((Collection) protocolHandlerCustomizers.orderedStream().collect(Collectors.toList()));
            return factory;
        }
    }

    @Configuration(
            proxyBeanMethods = false
    )
    @ConditionalOnMissingBean({ReactiveWebServerFactory.class})
    @ConditionalOnClass({HttpServer.class})
    static class EmbeddedNetty {
        EmbeddedNetty() {
        }

        @Bean
        @ConditionalOnMissingBean
        ReactorResourceFactory reactorServerResourceFactory() {
            return new ReactorResourceFactory();
        }

        @Bean
        NettyReactiveWebServerFactory nettyReactiveWebServerFactory(ReactorResourceFactory resourceFactory, ObjectProvider<NettyRouteProvider> routes, ObjectProvider<NettyServerCustomizer> serverCustomizers) {
            NettyReactiveWebServerFactory serverFactory = new NettyReactiveWebServerFactory();
            serverFactory.setResourceFactory(resourceFactory);
            routes.orderedStream().forEach((xva$0) -> {
                serverFactory.addRouteProviders(new NettyRouteProvider[]{xva$0});
            });
            serverFactory.getServerCustomizers().addAll((Collection) serverCustomizers.orderedStream().collect(Collectors.toList()));
            return serverFactory;
        }
    }
}
*/
