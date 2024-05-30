package org.adele.mini.controller;

import java.util.ArrayList;

import org.adele.mini.ManageBeggar;
import org.adele.mini.model.AutoMoneyMachine;
import org.adele.mini.model.Building;
import org.adele.mini.model.EmployBeggar;
import org.adele.mini.model.Nation;
import org.adele.mini.CONSTANT;
import org.adele.mini.GrowBeggarsView;

public class GrowBeggarsMainController extends GrowBeggarsController {

	public GrowBeggarsMainController(ManageBeggar beggar, GrowBeggarsView view) {
		super(beggar, view);
	}

	@Override
	public void run() {
		while(true) {
			int choice = view.choiceGameMenu();
			if(choice == 1) {
				int earnMoney = beggar.getEarnBegMoney();
				boolean useFever = beggar.useBegFever(); // 구걸 피버는 자동으로 사용한다.
				if(useFever) {
					earnMoney = (int)((earnMoney + CONSTANT.BEG_FEVER_ADD) * CONSTANT.BEG_FEVER_MUL);
				}
				view.showBegResult(useFever, earnMoney);
				beggar.addMoney(earnMoney);
				view.showCurrentMoney(beggar.getMoney());
			} else if(choice == 2) {
				if(beggar.useGakseolitaryeong()) {
					int earnMoney = beggar.getEarnGakseolitaryeongMoney();
					beggar.addMoney(earnMoney);
					view.showGakseolitaryeongResult(earnMoney);
				} else {
					view.showNotUseGakseolitaryeong();
				}
			} else if(choice == 3) {
				while(true) {
					long curMoney = beggar.getMoney();
					view.showCurrentMoney(curMoney);
					int hireChoice = view.hireBeggar();
					if(hireChoice == EmployBeggar.WHOLE_EMPLOY_BEGGAR.length + 1) {
						break;
					} else {
						view.showHireBeggarResult(beggar.hireBeggar(EmployBeggar.WHOLE_EMPLOY_BEGGAR[hireChoice - 1]));
					}
				}
			} else if(choice == 4) {
				while(true) {
					long curMoney = beggar.getMoney();
					view.showCurrentMoney(curMoney);
					ArrayList<AutoMoneyMachine> machines = beggar.getMachines();
					ArrayList<String> lines = new ArrayList<>();
					for(int i=0;i<machines.size();i++) {
						lines.add(machines.get(i).getName());
					}
					int buyChoice = view.upgradeBeggar(lines);
					if(buyChoice == 1) {
						if(view.begUpgradeYN(beggar.getBegMinMoney(), beggar.getBegMaxMoney(), beggar.getBegUpgradePrice())) {
							view.showBegUpgradeResult(beggar.upgradeBegMoney());
						} else {
							view.showNotContinueBegUpgrade();
						}
					} else if(buyChoice == 2) {
						if(view.gakseolitaryeongUpgradeYN(beggar.getGakseolitaryeongMinMoney(), beggar.getGakseolitaryeongMaxMoney(), beggar.getGakseolitaryeongUpgradePrice())) {
							view.showGakseolitaryeongUpgradeResult(beggar.upgradeGakseolitaryeong());
						} else {
							view.showNotContinueGakseolitaryeongUpgrade();
						}
					} else if(buyChoice == machines.size() + 3) {
						break;
					} else {
						AutoMoneyMachine machine = machines.get(buyChoice - 3);
						if(view.machineUpgradeYN(machine.getName(), machine.getMul(), machine.getUpgradePrice())) {
							view.showMachineUpgradeResult(beggar.upgradeMachine(machine), machine.getName());
						} else {
							view.showNotContinueMachineUpgrade(machine.getName());
						}
					}
				}
			} else if (choice == 5) {
				while(true) {
					long curMoney = beggar.getMoney();
					view.showCurrentMoney(curMoney);
					int buyItemChoice = view.buyItem(beggar.getFeverCount(), beggar.getGakseolitaryeongCount());
					if(buyItemChoice == 1) {
						view.showBuyBegFeverResult(beggar.buyBegFever());
					} else if(buyItemChoice == 2) {
						view.showBuyGakseolitaryeongResult(beggar.buyGakseolitaryeong());
					} else if(buyItemChoice == 3) {
						break;
					}
				}
			} else if(choice == 6) {
				while(true) {
					long curMoney = beggar.getMoney();
					view.showCurrentMoney(curMoney);
					ArrayList<AutoMoneyMachine> validMachines = new ArrayList<>();
					ArrayList<String> names = new ArrayList<>();
					ArrayList<Integer> prices = new ArrayList<>();
					for(int i=0;i<Building.WHOLE_BUILDING.length;i++) {
						if(beggar.containMachine(Building.WHOLE_BUILDING[i])) {
							continue;
						}
						validMachines.add(Building.WHOLE_BUILDING[i]);
						names.add(Building.WHOLE_BUILDING[i].getName());
						prices.add(Building.WHOLE_BUILDING[i].getBuyPrice());
					}
					int buyBuildingChoice = view.buyBuilding(names, prices);
					if(buyBuildingChoice == validMachines.size() + 1) {
						break;
					} else {
						AutoMoneyMachine machine = validMachines.get(buyBuildingChoice-1);
						view.showBuyMachineResult(beggar.buyMachine(machine), machine.getName());
					}
				}
			} else if(choice == 7) {
				while(true) {
					long curMoney = beggar.getMoney();
					view.showCurrentMoney(curMoney);
					ArrayList<AutoMoneyMachine> validMachines = new ArrayList<>();
					ArrayList<String> names = new ArrayList<>();
					ArrayList<Integer> prices = new ArrayList<>();
					for(int i=0;i<Nation.WHOLE_NATION.length;i++) {
						if(beggar.containMachine(Nation.WHOLE_NATION[i])) {
							continue;
						}
						validMachines.add(Nation.WHOLE_NATION[i]);
						names.add(Nation.WHOLE_NATION[i].getName());
						prices.add(Nation.WHOLE_NATION[i].getBuyPrice());
					}
					int buyNationChoice = view.buyNation(names, prices);
					if(buyNationChoice == validMachines.size() + 1) {
						break;
					} else {
						AutoMoneyMachine machine = validMachines.get(buyNationChoice-1);
						view.showBuyMachineResult(beggar.buyMachine(machine), machine.getName());
					}
				}
			} else if(choice == 8) {
				long curMoney = beggar.getMoney();
				view.showCurrentMoney(curMoney);
				ArrayList<String> employBeggarNames = new ArrayList<>();
				ArrayList<Double> employBeggarMuls = new ArrayList<>();
				ArrayList<Integer> employBeggarUpgradePrices = new ArrayList<>();
				ArrayList<String> buildingNames = new ArrayList<>();
				ArrayList<Double> buildingMuls = new ArrayList<>();
				ArrayList<Integer> buildingUpgradePrices = new ArrayList<>();
				ArrayList<String> nationNames = new ArrayList<>();
				ArrayList<Double> nationMuls = new ArrayList<>();
				ArrayList<Integer> nationUpgradePrices = new ArrayList<>();
				for(AutoMoneyMachine machine : beggar.getMachines()) {
					if(machine instanceof EmployBeggar) {
						employBeggarNames.add(machine.getName());
						employBeggarMuls.add(machine.getMul());
						employBeggarUpgradePrices.add(machine.getUpgradePrice());
					} else if(machine instanceof Building) {
						buildingNames.add(machine.getName());
						buildingMuls.add(machine.getMul());
						buildingUpgradePrices.add(machine.getUpgradePrice());
					} else if(machine instanceof Nation) {
						nationNames.add(machine.getName());
						nationMuls.add(machine.getMul());
						nationUpgradePrices.add(machine.getUpgradePrice());
					}
				}
				view.showBegInfo(
						beggar.getName(),
						beggar.getAge(),
						beggar.getBegMinMoney(),
						beggar.getBegMaxMoney(),
						beggar.getBegUpgradePrice(),
						beggar.getGakseolitaryeongMinMoney(),
						beggar.getGakseolitaryeongMaxMoney(),
						beggar.getGakseolitaryeongUpgradePrice(),
						beggar.getFeverCount(),
						beggar.getGakseolitaryeongCount(),
						employBeggarNames,
						employBeggarMuls,
						employBeggarUpgradePrices,
						buildingNames,
						buildingMuls,
						buildingUpgradePrices,
						nationNames,
						nationMuls,
						nationUpgradePrices
						);
			} else {
				break;
			}
		}
	}
	
}