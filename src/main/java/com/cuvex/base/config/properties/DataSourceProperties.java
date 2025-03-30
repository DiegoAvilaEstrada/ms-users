package com.cuvex.base.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Generated;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProperties {

  private String url;

  private String username;

  private String password;

  @Value("${configuration.flyway.options}")
  private String flywayOptions;



  /**
   * {@inheritDoc}
   */
  @Override
  @Generated
  public String toString() {
    // @off
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("url", url)
      .append("username", username)
      .append("password", password)
      .append("flywayOptions", flywayOptions)
      .toString();
    // @on
  }

}
