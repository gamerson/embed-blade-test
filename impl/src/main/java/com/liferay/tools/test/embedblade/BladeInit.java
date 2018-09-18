package com.liferay.tools.test.embedblade;

import com.liferay.blade.cli.BladeCLI;
import com.liferay.blade.cli.command.InitArgs;
import com.liferay.blade.cli.command.InitCommand;

import java.io.IOException;
import java.nio.file.Files;

import org.osgi.service.component.annotations.Component;

@Component(
	property = {
    "osgi.command.function=init", 
    "osgi.command.scope=blade"
  },
  service = Object.class
)
public class BladeInit {

  public void init() {
	  InitArgs initArgs;
	try {
		BladeCLI bladeCLI = new BladeCLI();
		  
		  InitCommand initCommand = new InitCommand();
		  initArgs = new InitArgs();
		  initArgs.setBase(Files.createTempDirectory("init").toFile());
		  initCommand.setArgs(initArgs);
		  initCommand.setBlade(bladeCLI);
		  
		  initCommand.execute();
		  System.out.println("Created new workspace in " + initArgs.getBase());
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	  
  }

}
