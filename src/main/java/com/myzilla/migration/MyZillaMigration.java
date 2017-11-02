package com.myzilla.migration;

import org.flywaydb.core.Flyway;

public class MyZillaMigration extends Flyway{
	public void repairAndMigrate() {
		//this.init();
		this.setValidateOnMigrate(true);
        this.repair();
        this.migrate();
    }
}
