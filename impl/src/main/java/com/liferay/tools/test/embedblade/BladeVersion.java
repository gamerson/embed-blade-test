package com.liferay.tools.test.embedblade;

import com.liferay.blade.cli.BladeCLI;
import com.liferay.blade.cli.command.VersionCommand;

import org.osgi.service.component.annotations.Component;

@Component(
	property = {
    "osgi.command.function=version", 
    "osgi.command.scope=blade"
  },
  service = Object.class
)
public class BladeVersion {

  public void bladeversion() throws Exception {
	  BladeCLI bladeCLI = new BladeCLI();
	  
	  VersionCommand versionCommand = new VersionCommand();
	  versionCommand.setBlade(bladeCLI);
	  
	  versionCommand.execute();
  }

}
