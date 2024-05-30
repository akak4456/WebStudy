package org.adele.mini.controller;

import org.adele.mini.ManageBeggar;
import org.adele.mini.GrowBeggarsView;

public abstract class GrowBeggarsController {
	protected ManageBeggar beggar;
	protected GrowBeggarsView view;
	public GrowBeggarsController(ManageBeggar beggar, GrowBeggarsView view) {
		this.beggar = beggar;
		this.view = view;
	}
	
	abstract public void run();

}
