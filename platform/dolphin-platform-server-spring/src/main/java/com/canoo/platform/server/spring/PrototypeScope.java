package com.canoo.platform.server.spring;

import org.apiguardian.api.API;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.apiguardian.api.API.Status.MAINTAINED;

/**
 * A Spring {@link Scope} annotation for the prototype scope.
 *
 * @author Hendrik Ebbers
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Documented
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@API(since = "0.x", status = MAINTAINED)
public @interface PrototypeScope {

    /**
     * Alias for {@link Scope#proxyMode}.
     */
    @AliasFor(annotation = Scope.class)
    ScopedProxyMode proxyMode() default ScopedProxyMode.DEFAULT;
}
