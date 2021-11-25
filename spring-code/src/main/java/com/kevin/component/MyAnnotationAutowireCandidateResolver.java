package com.kevin.component;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.AutowireCandidateResolver;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.lang.Nullable;

/**
 * Code is far away from bug with the animal protecting
 *
 * @author kevin lau (双鹰)
 */
public class MyAnnotationAutowireCandidateResolver extends ContextAnnotationAutowireCandidateResolver {
    private final AutowireCandidateResolver delegate;

    public MyAnnotationAutowireCandidateResolver(AutowireCandidateResolver delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object getSuggestedValue(@NotNull DependencyDescriptor descriptor) {
        if(descriptor.getDependencyType().isAssignableFrom(String.class)) {
            return "kevin";
        }
        return super.getSuggestedValue(descriptor);
    }

    @Override
    public boolean isAutowireCandidate(@NotNull BeanDefinitionHolder bdHolder, @NotNull DependencyDescriptor descriptor) {
        if (delegate != null) {
            return delegate.isAutowireCandidate(bdHolder, descriptor);
        }
        return super.isAutowireCandidate(bdHolder, descriptor);
    }

    @Override
    public boolean isRequired(@NotNull DependencyDescriptor descriptor) {
        if (delegate != null) {
            return delegate.isRequired(descriptor);
        }
        return super.isRequired(descriptor);
    }

    @Override
    public boolean hasQualifier(@NotNull DependencyDescriptor descriptor) {
        if (delegate != null) {
            return delegate.hasQualifier(descriptor);
        }
        return super.hasQualifier(descriptor);
    }

    @Override
    @Nullable
    public Object getLazyResolutionProxyIfNecessary(@NotNull DependencyDescriptor descriptor, String beanName) {
        if (delegate != null) {
            return delegate.getLazyResolutionProxyIfNecessary(descriptor, beanName);
        }
        return super.getLazyResolutionProxyIfNecessary(descriptor, beanName);
    }

    @Override
    public @NotNull
    AutowireCandidateResolver cloneIfNecessary() {
        if (delegate != null) {
            return delegate.cloneIfNecessary();
        }
        return super.cloneIfNecessary();
    }
}
