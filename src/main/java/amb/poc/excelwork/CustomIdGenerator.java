package amb.poc.excelwork;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;

import java.lang.annotation.Annotation;
import java.util.Properties;
import java.util.stream.Stream;

public abstract class CustomIdGenerator implements IdentifierGenerator, Configurable {

    private String prefix;

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        IdentifierGenerator.super.configure(type, params, serviceRegistry);
        prefix = params.getProperty("prefix");
    }

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String query = String.format("select %s from %s", session.getEntityPersister(object.getClass().getName(),
                object).getIdentifierPropertyName(), object.getClass().getSimpleName());

        Stream<String> ids = session.createQuery(query, String.class).stream();

        Long max = ids.map(o -> o.replace(prefix + "-", ""))
                .mapToLong(Long::parseLong)
                .max()
                .orElse(0L);
        return prefix + "-" + max + 1;
    }


    @Override
    public Autowire autowire() {
        return null;
    }

    @Override
    public boolean dependencyCheck() {
        return false;
    }

    @Override
    public boolean preConstruction() {
        return false;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
