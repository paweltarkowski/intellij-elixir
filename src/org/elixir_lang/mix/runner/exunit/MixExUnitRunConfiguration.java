package org.elixir_lang.mix.runner.exunit;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import org.elixir_lang.mix.runner.MixRunConfigurationBase;
import org.jetbrains.annotations.NotNull;

final class MixExUnitRunConfiguration extends MixRunConfigurationBase {
  public MixExUnitRunConfiguration(@NotNull String name, @NotNull Project project){
    super(name, project, MixExUnitRunConfigurationFactory.getInstance());
  }

  @NotNull
  @Override
  public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
    return new MixExUnitRunConfigurationEditorForm();
  }

  @NotNull
  @Override
  public RunProfileState getState(@NotNull Executor executor,
                                  @NotNull ExecutionEnvironment environment) throws ExecutionException {
    return new MixExUnitRunningState(environment, this);
  }
}
