package com.test.bank;

import com.test.bank.initializer.DataSourceInitializer;
import com.test.bank.tool.config.EnvConfigManager;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MicroServiceApplication_MembersInjector
    implements MembersInjector<MicroServiceApplication> {
  private final Provider<DataSourceInitializer> dataSourceInitializerProvider;

  private final Provider<EnvConfigManager> envConfigManagerProvider;

  public MicroServiceApplication_MembersInjector(
      Provider<DataSourceInitializer> dataSourceInitializerProvider,
      Provider<EnvConfigManager> envConfigManagerProvider) {
    this.dataSourceInitializerProvider = dataSourceInitializerProvider;
    this.envConfigManagerProvider = envConfigManagerProvider;
  }

  public static MembersInjector<MicroServiceApplication> create(
      Provider<DataSourceInitializer> dataSourceInitializerProvider,
      Provider<EnvConfigManager> envConfigManagerProvider) {
    return new MicroServiceApplication_MembersInjector(
        dataSourceInitializerProvider, envConfigManagerProvider);
  }

  @Override
  public void injectMembers(MicroServiceApplication instance) {
    injectDataSourceInitializer(instance, dataSourceInitializerProvider.get());
    injectEnvConfigManager(instance, envConfigManagerProvider.get());
  }

  public static void injectDataSourceInitializer(
      MicroServiceApplication instance, DataSourceInitializer dataSourceInitializer) {
    instance.dataSourceInitializer = dataSourceInitializer;
  }

  public static void injectEnvConfigManager(
      MicroServiceApplication instance, EnvConfigManager envConfigManager) {
    instance.envConfigManager = envConfigManager;
  }
}
