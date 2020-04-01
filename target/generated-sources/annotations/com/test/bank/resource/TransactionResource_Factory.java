package com.test.bank.resource;

import com.test.bank.service.AdminService;
import com.test.bank.service.TransactionService;
import com.test.bank.tool.config.EnvConfigManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TransactionResource_Factory implements Factory<TransactionResource> {
  private final Provider<EnvConfigManager> envConfigManagerProvider;

  private final Provider<TransactionService> transactionServiceProvider;

  private final Provider<AdminService> adminServiceProvider;

  public TransactionResource_Factory(
      Provider<EnvConfigManager> envConfigManagerProvider,
      Provider<TransactionService> transactionServiceProvider,
      Provider<AdminService> adminServiceProvider) {
    this.envConfigManagerProvider = envConfigManagerProvider;
    this.transactionServiceProvider = transactionServiceProvider;
    this.adminServiceProvider = adminServiceProvider;
  }

  @Override
  public TransactionResource get() {
    return provideInstance(
        envConfigManagerProvider, transactionServiceProvider, adminServiceProvider);
  }

  public static TransactionResource provideInstance(
      Provider<EnvConfigManager> envConfigManagerProvider,
      Provider<TransactionService> transactionServiceProvider,
      Provider<AdminService> adminServiceProvider) {
    return new TransactionResource(
        envConfigManagerProvider.get(),
        transactionServiceProvider.get(),
        adminServiceProvider.get());
  }

  public static TransactionResource_Factory create(
      Provider<EnvConfigManager> envConfigManagerProvider,
      Provider<TransactionService> transactionServiceProvider,
      Provider<AdminService> adminServiceProvider) {
    return new TransactionResource_Factory(
        envConfigManagerProvider, transactionServiceProvider, adminServiceProvider);
  }

  public static TransactionResource newTransactionResource(
      EnvConfigManager envConfigManager,
      TransactionService transactionService,
      AdminService adminService) {
    return new TransactionResource(envConfigManager, transactionService, adminService);
  }
}
