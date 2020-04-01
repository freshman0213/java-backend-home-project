package com.test.bank.dagger;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.test.bank.MicroServiceApplication;
import com.test.bank.MicroServiceApplication_MembersInjector;
import com.test.bank.initializer.DataSourceInitializer;
import com.test.bank.initializer.DataSourceInitializer_Factory;
import com.test.bank.resource.AdminResource;
import com.test.bank.resource.TransactionResource;
import com.test.bank.service.AdminService;
import com.test.bank.service.AdminService_Factory;
import com.test.bank.service.TransactionService;
import com.test.bank.service.TransactionService_Factory;
import com.test.bank.tool.config.EnvConfigManager;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerBootstrapComponent implements BootstrapComponent {
  private Provider<EnvConfigManager> envConfigManagerProvider;

  private Provider<DataSourceInitializer> dataSourceInitializerProvider;

  private Provider<AdminService> adminServiceProvider;

  private Provider<TransactionService> transactionServiceProvider;

  private DaggerBootstrapComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static BootstrapComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.envConfigManagerProvider =
        DoubleCheck.provider(
            BootstrapModule_EnvConfigManagerFactory.create(builder.bootstrapModule));
    this.dataSourceInitializerProvider =
        DoubleCheck.provider(DataSourceInitializer_Factory.create(envConfigManagerProvider));
    this.adminServiceProvider =
        DoubleCheck.provider(AdminService_Factory.create(dataSourceInitializerProvider));
    this.transactionServiceProvider =
        DoubleCheck.provider(TransactionService_Factory.create(dataSourceInitializerProvider));
  }

  @Override
  public void inject(MicroServiceApplication microServiceApplication) {
    injectMicroServiceApplication(microServiceApplication);
  }

  @Override
  public AdminResource adminResource() {
    return new AdminResource(envConfigManagerProvider.get(), adminServiceProvider.get());
  }

  @Override
  public TransactionResource transactionResource() {
    return new TransactionResource(
        envConfigManagerProvider.get(),
        transactionServiceProvider.get(),
        adminServiceProvider.get());
  }

  @CanIgnoreReturnValue
  private MicroServiceApplication injectMicroServiceApplication(MicroServiceApplication instance) {
    MicroServiceApplication_MembersInjector.injectDataSourceInitializer(
        instance, dataSourceInitializerProvider.get());
    MicroServiceApplication_MembersInjector.injectEnvConfigManager(
        instance, envConfigManagerProvider.get());
    return instance;
  }

  public static final class Builder {
    private BootstrapModule bootstrapModule;

    private Builder() {}

    public BootstrapComponent build() {
      if (bootstrapModule == null) {
        this.bootstrapModule = new BootstrapModule();
      }
      return new DaggerBootstrapComponent(this);
    }

    public Builder bootstrapModule(BootstrapModule bootstrapModule) {
      this.bootstrapModule = Preconditions.checkNotNull(bootstrapModule);
      return this;
    }
  }
}
