/*
package api.service.hackatonv1.ecommerce;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.reactive.ReactiveWebServerFactoryCustomizer;
import org.springframework.boot.autoconfigure.web.reactive.TomcatReactiveWebServerFactoryCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.server.WebServerFactoryCustomizerBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.http.ReactiveHttpInputMessage;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.adapter.ForwardedHeaderTransformer;

import java.util.function.Supplier;

@AutoConfigureOrder(-2147483648)
@AutoConfiguration
@ConditionalOnClass({ReactiveHttpInputMessage.class})
@ConditionalOnWebApplication(
        type = Type.REACTIVE
)
@EnableConfigurationProperties({ServerProperties.class})
@Import({Util.BeanPostProcessorsRegistrar.class, Util2.EmbeddedTomcat.class, Util2.EmbeddedJetty.class, Util2.EmbeddedUndertow.class, Util2.EmbeddedNetty.class})
public class Util {
    public Util() {
    }

    @Bean
    public ReactiveWebServerFactoryCustomizer reactiveWebServerFactoryCustomizer(ServerProperties serverProperties) {
        return new ReactiveWebServerFactoryCustomizer(serverProperties);
    }

    @Bean
    @ConditionalOnClass(
            name = {"org.apache.catalina.startup.Tomcat"}
    )
    public TomcatReactiveWebServerFactoryCustomizer tomcatReactiveWebServerFactoryCustomizer(ServerProperties serverProperties) {
        return new TomcatReactiveWebServerFactoryCustomizer(serverProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(
            value = {"server.forward-headers-strategy"},
            havingValue = "framework"
    )
    public ForwardedHeaderTransformer forwardedHeaderTransformer() {
        return new ForwardedHeaderTransformer();
    }

    public static class BeanPostProcessorsRegistrar implements ImportBeanDefinitionRegistrar, BeanFactoryAware {
        private ConfigurableListableBeanFactory beanFactory;

        public BeanPostProcessorsRegistrar() {
        }

        public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
            if (beanFactory instanceof ConfigurableListableBeanFactory) {
                this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
            }

        }

        public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
            if (this.beanFactory != null) {
                this.registerSyntheticBeanIfMissing(registry, "webServerFactoryCustomizerBeanPostProcessor", WebServerFactoryCustomizerBeanPostProcessor.class, WebServerFactoryCustomizerBeanPostProcessor::new);
            }
        }

        private <T> void registerSyntheticBeanIfMissing(BeanDefinitionRegistry registry, String name, Class<T> beanClass, Supplier<T> instanceSupplier) {
            if (ObjectUtils.isEmpty(this.beanFactory.getBeanNamesForType(beanClass, true, false))) {
                RootBeanDefinition beanDefinition = new RootBeanDefinition(beanClass, instanceSupplier);
                beanDefinition.setSynthetic(true);
                registry.registerBeanDefinition(name, beanDefinition);
            }

        }
    }
}
*/
