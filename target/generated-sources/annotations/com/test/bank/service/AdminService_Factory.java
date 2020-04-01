package com.test.bank.service;

import com.test.bank.initializer.DataSourceInitializer;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AdminService_Factory implements Factory<AdminService> {
  private final Provider<DataSourceInitializer> dataSourceInitializerProvider;

  public AdminService_Factory(Provider<DataSourceInitializer> dataSourceInitializerProvider) {
    this.dataSourceInitializerProvider = dataSourceInitializerProvider;
  }

  @Override
  public AdminService get() {
    return provideInstance(dataSourceInitializerProvider);
  }

  public static AdminService provideInstance(
      Provider<DataSourceInitializer> dataSourceInitializerProvider) {
    return new AdminService(dataSourceInitializerProvider.get());
  }

  public static AdminService_Factory create(
      Provider<DataSourceInitializer> dataSourceInitializerProvider) {
    return new AdminService_Factory(dataSourceInitializerProvider);
  }

  public static AdminService newAdminService(DataSourceInitializer dataSourceInitializer) {
    return new AdminService(dataSourceInitializer);
  }
}
