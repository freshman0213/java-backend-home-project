package com.test.bank.initializer;

import com.test.bank.tool.config.EnvConfigManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DataSourceInitializer_Factory implements Factory<DataSourceInitializer> {
  private final Provider<EnvConfigManager> envConfigManagerProvider;

  public DataSourceInitializer_Factory(Provider<EnvConfigManager> envConfigManagerProvider) {
    this.envConfigManagerProvider = envConfigManagerProvider;
  }

  @Override
  public DataSourceInitializer get() {
    return provideInstance(envConfigManagerProvider);
  }

  public static DataSourceInitializer provideInstance(
      Provider<EnvConfigManager> envConfigManagerProvider) {
    return new DataSourceInitializer(envConfigManagerProvider.get());
  }

  public static DataSourceInitializer_Factory create(
      Provider<EnvConfigManager> envConfigManagerProvider) {
    return new DataSourceInitializer_Factory(envConfigManagerProvider);
  }

  public static DataSourceInitializer newDataSourceInitializer(EnvConfigManager envConfigManager) {
    return new DataSourceInitializer(envConfigManager);
  }
}
