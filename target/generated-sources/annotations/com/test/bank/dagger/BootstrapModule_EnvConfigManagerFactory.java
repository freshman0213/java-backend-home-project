package com.test.bank.dagger;

import com.test.bank.tool.config.EnvConfigManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BootstrapModule_EnvConfigManagerFactory implements Factory<EnvConfigManager> {
  private final BootstrapModule module;

  public BootstrapModule_EnvConfigManagerFactory(BootstrapModule module) {
    this.module = module;
  }

  @Override
  public EnvConfigManager get() {
    return provideInstance(module);
  }

  public static EnvConfigManager provideInstance(BootstrapModule module) {
    return proxyEnvConfigManager(module);
  }

  public static BootstrapModule_EnvConfigManagerFactory create(BootstrapModule module) {
    return new BootstrapModule_EnvConfigManagerFactory(module);
  }

  public static EnvConfigManager proxyEnvConfigManager(BootstrapModule instance) {
    return Preconditions.checkNotNull(
        instance.envConfigManager(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
