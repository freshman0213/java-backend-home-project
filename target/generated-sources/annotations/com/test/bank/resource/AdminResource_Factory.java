package com.test.bank.resource;

import com.test.bank.service.AdminService;
import com.test.bank.tool.config.EnvConfigManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AdminResource_Factory implements Factory<AdminResource> {
  private final Provider<EnvConfigManager> envConfigManagerProvider;

  private final Provider<AdminService> adminServiceProvider;

  public AdminResource_Factory(
      Provider<EnvConfigManager> envConfigManagerProvider,
      Provider<AdminService> adminServiceProvider) {
    this.envConfigManagerProvider = envConfigManagerProvider;
    this.adminServiceProvider = adminServiceProvider;
  }

  @Override
  public AdminResource get() {
    return provideInstance(envConfigManagerProvider, adminServiceProvider);
  }

  public static AdminResource provideInstance(
      Provider<EnvConfigManager> envConfigManagerProvider,
      Provider<AdminService> adminServiceProvider) {
    return new AdminResource(envConfigManagerProvider.get(), adminServiceProvider.get());
  }

  public static AdminResource_Factory create(
      Provider<EnvConfigManager> envConfigManagerProvider,
      Provider<AdminService> adminServiceProvider) {
    return new AdminResource_Factory(envConfigManagerProvider, adminServiceProvider);
  }

  public static AdminResource newAdminResource(
      EnvConfigManager envConfigManager, AdminService adminService) {
    return new AdminResource(envConfigManager, adminService);
  }
}
