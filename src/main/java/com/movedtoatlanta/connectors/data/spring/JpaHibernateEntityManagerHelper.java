package com.movedtoatlanta.connectors.data.spring;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;


/**
 * Class to assist in the entity manager set-up for spring data jpa
 */
public final class JpaHibernateEntityManagerHelper {

    private JpaHibernateEntityManagerHelper() {
    }

    /**
     * @param scanPackages String[]
     * @param ds           DataSource
     * @return {@link org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean}
     */
    public static LocalContainerEntityManagerFactoryBean configureLocalEmf(String[] scanPackages, DataSource ds) {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setPackagesToScan(scanPackages);
        lef.setDataSource(ds);
        lef.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return lef;
    }
}
