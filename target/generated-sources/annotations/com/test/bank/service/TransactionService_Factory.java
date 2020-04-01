package com.test.bank.service;

import com.test.bank.initializer.DataSourceInitializer;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TransactionService_Factory implements Factory<TransactionService> {
  private final Provider<DataSourceInitializer> dataSourceInitializerProvider;

  public TransactionService_Factory(Provider<DataSourceInitializer> dataSourceInitializerProvider) {
    this.dataSourceInitializerProvider = dataSourceInitializerProvider;
  }

  @Override
  public TransactionService get() {
    return provideInstance(dataSourceInitializerProvider);
  }

  public static TransactionService provideInstance(
      Provider<DataSourceInitializer> dataSourceInitializerProvider) {
    return new TransactionService(dataSourceInitializerProvider.get());
  }

  public static TransactionService_Factory create(
      Provider<DataSourceInitializer> dataSourceInitializerProvider) {
    return new TransactionService_Factory(dataSourceInitializerProvider);
  }

  public static TransactionService newTransactionService(
      DataSourceInitializer dataSourceInitializer) {
    return new TransactionService(dataSourceInitializer);
  }
}
