package com.cuvex.base.config;

import com.cuvex.base.config.properties.DataSourceProperties;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Cristian Archila ca@t2mc.net
 *
 * @version 1.0
 */
@Configuration
public class FlywayConfig {

  @Bean
  FlywayMigrationStrategy cleanMigrateStrategy(final DataSourceProperties dataSourceProperties) {
    // @off
    return (Flyway flyway) -> {
      flyway = Flyway.configure()
        .dataSource(dataSourceProperties.getUrl().concat(dataSourceProperties.getFlywayOptions()), dataSourceProperties.getUsername(), dataSourceProperties.getPassword())
        .load();
      flyway.migrate();
    };
    // @on
  }

}
