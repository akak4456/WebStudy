package org.adele.mini;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.adele.mini.model.EmployBeggar;

public class GrowBeggarsView {
	private Scanner sc;
	private Map<String, Map<String, String>> lang;
	public static final String LANG_KO = "ko";
	public static final String LANG_EN = "en";
	private String curLang = LANG_KO;
	public GrowBeggarsView(Scanner sc) {
		this.sc = sc;
		lang = new HashMap<>();
		initLang(LANG_KO);
		initLang(LANG_EN);
	}
	
	private void initLang(String langCode) {
		Map<String, String> innerLangData = new HashMap<>();
		if(langCode.equals(LANG_KO)) {
			innerLangData.put("common_choice", "당신의 선택은? > ");
			
			innerLangData.put("hello_1", "거지키우기 게임에 오신 여러분 환영합니다!\n");
			innerLangData.put("hello_2", "거지를 키워 최대한 부자로 만드세요!\n");
			
			innerLangData.put("choiceMenu_1", "메인 메뉴\n");
			innerLangData.put("choiceMenu_2", "1. 게임시작\n");
			innerLangData.put("choiceMenu_3", "2. 게임 초기화\n");
			innerLangData.put("choiceMenu_4", "4. 게임종료\n");
			
			innerLangData.put("inputName_1", "당신은 게임을 처음 했군요!\n");
			innerLangData.put("inputName_2", "거지에 대한 정보가 필요합니다.\n");
			innerLangData.put("inputName_3", "거지의 이름을 입력해주세요 > ");
			
			innerLangData.put("inputAge_1", "거지의 나이를 입력해주세요 > ");
			
			innerLangData.put("choiceGameMenu_1", "당신은 이제 거지를 키우고자 합니다.\n");
			innerLangData.put("choiceGameMenu_2", "어떤 행위를 하시겠습니까?\n");
			innerLangData.put("choiceGameMenu_3", "1. 구걸하기\n");
			innerLangData.put("choiceGameMenu_4", "2. 각설이타령하기\n");
			innerLangData.put("choiceGameMenu_5", "3. 거지 고용하기\n");
			innerLangData.put("choiceGameMenu_6", "4. 업그레이드 하기\n");
			innerLangData.put("choiceGameMenu_7", "5. 아이템 사기\n");
			innerLangData.put("choiceGameMenu_8", "6. 건물 사기\n");
			innerLangData.put("choiceGameMenu_9", "7. 나라 사기\n");
			innerLangData.put("choiceGameMenu_10", "8. 현재 상태 보기\n");
			innerLangData.put("choiceGameMenu_11", "9. 게임종료\n");
			innerLangData.put("choiceGameMenu_12", "어떤 행위를 하시겠습니까?\n");
			
			innerLangData.put("showBegResult_1", "당신은 구걸을 하였습니다.\n");
			innerLangData.put("showBegResult_2", "구걸 피버가 적용되었습니다.\n");
			innerLangData.put("showBegResult_3", "당신은 %s원 만큼 벌었습니다.\n");
			
			innerLangData.put("showCurrentMoney_1", "당신은 현재 %s원 있습니다.\n");
			
			innerLangData.put("showGakseolitaryeongResult_1", "당신은 각설이 타령을 하였습니다.\n");
			innerLangData.put("showGakseolitaryeongResult_2", "당신은 %s원 만큼 벌었습니다.\n");
			
			innerLangData.put("showNotUseGakseolitaryeong_1", "당신은 각설이 타령을 할 수 없습니다.\n");
			innerLangData.put("showNotUseGakseolitaryeong_2", "각설이 타령을 보유하고 있는지 확인해주세요.\n");
			
			innerLangData.put("hireBeggar_1", "당신은 거지를 고용할 수 있습니다.\n");
			innerLangData.put("hireBeggar_2", "어떤 거지를 고용하시겠습니까?\n");
			innerLangData.put("hireBeggar_3", "%s. %s 배율: %s 가격: %s\n");
			innerLangData.put("hireBeggar_4", "%s. 그만 고용하기\n");
			
			innerLangData.put("showHireBeggarResult_1", "거지를 고용하였습니다.\n");
			innerLangData.put("showHireBeggarResult_2", "이 거지를 고용하기에는 돈이 부족합니다.\n");
			
			innerLangData.put("upgradeBeggar_1", "당신은 거지와 관련해서 업그레이드를 할 수 있습니다.\n");
			innerLangData.put("upgradeBeggar_2", "어떤 것을 업그레이드 하시겠습니까?\n");
			innerLangData.put("upgradeBeggar_3", "1. 구걸로 벌어들이는 돈 업그레이드\n");
			innerLangData.put("upgradeBeggar_4", "2. 각설이타령으로 벌어들이는 돈 업그레이드\n");
			innerLangData.put("upgradeBeggar_5", "%s. %s 업그레이드\n");
			innerLangData.put("upgradeBeggar_6", "%s. 업그레이드 종료하기\n");
			
			innerLangData.put("begUpgradeYN_1", "당신은 현재 구걸하기를 통해\n");
			innerLangData.put("begUpgradeYN_2", "최소 %s원\n");
			innerLangData.put("begUpgradeYN_3", "최대 %s원\n");
			innerLangData.put("begUpgradeYN_4", "만큼 벌고 있으며 업그레이드 비용은 %s원 입니다.\n");
			innerLangData.put("begUpgradeYN_5", "업그레이드 하시겠습니까?(Y/N) > ");
			
			innerLangData.put("showBegUpgradeResult_1", "구걸하기를 업그레이드 하였습니다.\n");
			innerLangData.put("showBegUpgradeResult_2", "업그레이드를 진행할 돈이 부족합니다.\n");
			
			innerLangData.put("showNotContinueBegUpgrade_1", "구걸하기 업그레이드를 진행하지 않았습니다.\n");
			
			innerLangData.put("gakseolitaryeongUpgradeYN_1", "당신은 현재 각설이타령을 통해\n");
			innerLangData.put("gakseolitaryeongUpgradeYN_2", "최소 %s원\n");
			innerLangData.put("gakseolitaryeongUpgradeYN_3", "최대 %s원\n");
			innerLangData.put("gakseolitaryeongUpgradeYN_4", "만큼 벌고 있으며 업그레이드 비용은 %s원 입니다.\n");
			innerLangData.put("gakseolitaryeongUpgradeYN_5", "업그레이드 하시겠습니까?(Y/N) > ");
			
			innerLangData.put("showGakseolitaryeongUpgradeResult_1", "각설이타령을 업그레이드 하였습니다.\n");
			innerLangData.put("showGakseolitaryeongUpgradeResult_2", "업그레이드를 진행할 돈이 부족합니다.\n");
			
			innerLangData.put("machineUpgradeYN_1", "당신은 현재 %s을(를) 통해\n");
			innerLangData.put("machineUpgradeYN_2", "1초마다 %s원을 자동으로 벌고 있습니다.\n");
			innerLangData.put("machineUpgradeYN_3", "업그레이드 비용은 %s원입니다.\n");
			innerLangData.put("machineUpgradeYN_4", "업그레이드 하시겠습니까?(Y/N) > ");
			
			innerLangData.put("showMachineUpgradeResult_1", "%s을(를) 업그레이드 하였습니다.\n");
			innerLangData.put("showMachineUpgradeResult_2", "업그레이드를 진행할 돈이 부족합니다.\n");
			
			innerLangData.put("showNotContinueGakseolitaryeongUpgrade_1", "각설이타령 업그레이드를 진행하지 않았습니다.\n");
			
			innerLangData.put("showNotContinueMachineUpgrade_1", "%s 업그레이드를 진행하지 않았습니다.\n");
			
			innerLangData.put("buyItem_1", "1. 구걸 피버 %s개 구입(현재 %s개 보유) 가격: %s원\n");
			innerLangData.put("buyItem_2", "2. 각설이타령 %s개 구입(현재 %s개 보유) 가격: %s원\n");
			innerLangData.put("buyItem_3", "3. 아이템 구입 종료\n");
			
			innerLangData.put("showBuyBegFeverResult_1", "구걸 피버를 %s개 샀습니다.\n");
			innerLangData.put("showBuyBegFeverResult_2", "구걸 피버를 살 돈이 없습니다.\n");
			
			innerLangData.put("showBuyGakseolitaryeongResult_1", "각설이 타령을 %s개 샀습니다.\n");
			innerLangData.put("showBuyGakseolitaryeongResult_2", "각설이 타령을 살 돈이 없습니다.\n");
			
			innerLangData.put("buyBuilding_1", "당신은 빌딩을 살 수 있습니다.\n");
			innerLangData.put("buyBuilding_2", "어떤 빌딩을 사시겠습니까?\n");
			innerLangData.put("buyBuilding_3", "%s. %s 가격: %s원\n");
			innerLangData.put("buyBuilding_4", "%s. 빌딩 사기 종료하기\n");
			
			innerLangData.put("showBuyMachineResult_1", "%s을(를) 구입하였습니다.\n");
			innerLangData.put("showBuyMachineResult_2", "%s을(를) 구입하는 데 드는 돈이 없습니다.\n");
			
			innerLangData.put("buyNation_1", "당신은 나라를 살 수 있습니다.\n");
			innerLangData.put("buyNation_2", "어떤 나라를 사시겠습니까?\n");
			innerLangData.put("buyNation_3", "%s. %s 가격: %s원\n");
			innerLangData.put("buyNation_4", "%s. 나라 사기 종료하기\n");
			
			innerLangData.put("showBegInfo_1", "당신의 이름은 %s이며 나이는 %s살 입니다.\n");
			innerLangData.put("showBegInfo_2", "당신은 구걸을 통해 최소 %s원 최대 %s원 벌고 있습니다.\n");
			innerLangData.put("showBegInfo_3", "현재 구걸 업그레이드 비용은 %s원 입니다.\n");
			innerLangData.put("showBegInfo_4", "당신은 각설이타령을 통해 최소 %s원 최대 %s원 벌고 있습니다.\n");
			innerLangData.put("showBegInfo_5", "현재 각설이타령 업그레이드 비용은 %s원 입니다.\n");
			innerLangData.put("showBegInfo_6", "당신이 가지고 있는 아이템은 다음과 같습니다.\n");
			innerLangData.put("showBegInfo_7", "구걸 피버: %s개\n");
			innerLangData.put("showBegInfo_8", "각설이타령: %s개\n");
			innerLangData.put("showBegInfo_9", "당신이 고용한 거지는 다음과 같습니다.\n");
			innerLangData.put("showBegInfo_10", "고용한 거지가 없습니다.\n");
			innerLangData.put("showBegInfo_11", "%s\n");
			innerLangData.put("showBegInfo_12", "--- 1초마다 벌어들이는 돈: %s\n");
			innerLangData.put("showBegInfo_13", "--- 현재 업그레이드 비용: %s\n");
			innerLangData.put("showBegInfo_14", "당신이 구입한 빌딩은 다음과 같습니다.\n");
			innerLangData.put("showBegInfo_15", "구입한 빌딩이 없습니다.\n");
			innerLangData.put("showBegInfo_16", "당신이 구입한 나라는 다음과 같습니다.\n");
			innerLangData.put("showBegInfo_17", "구입한 나라가 없습니다.\n");
			
			innerLangData.put("showReset_1", "게임을 초기화 합니다.\n");
			
			innerLangData.put("sayGoodbye_1", "게임을 즐겨주셔서 감사합니다!\n");
			
			innerLangData.put("showWrongInput_1", "잘못된 입력입니다. 다시 입력해주세요 > ");
			
			innerLangData.put("showNotRangeInput_1", "%s ~ %s 사이의 수를 입력해야 합니다. 다시 입력해주세요 > ");
			
			innerLangData.put("showChangeLang_1", "설정할 언어를 선택해주세요.\n");
			
			innerLangData.put("changeLang_1", "언어를 변경하였습니다!\n");
		} else if(langCode.equals(LANG_EN)) {
			innerLangData.put("common_choice", "Your choice? > ");
			
			innerLangData.put("hello_1", "Welcome to the Beggar Raising Game!\n");
			innerLangData.put("hello_2", "Raise a beggar and make him as rich as possible!\n");
			
			innerLangData.put("choiceMenu_1", "Main Menu\n");
			innerLangData.put("choiceMenu_2", "1. Start the game\n");
			innerLangData.put("choiceMenu_3", "2. Reset the game\n");
			innerLangData.put("choiceMenu_4", "4. Game ends\n");
			
			innerLangData.put("inputName_1", "You're new to the game!\n");
			innerLangData.put("inputName_2", "I need information about beggars.\n");
			innerLangData.put("inputName_3", "Please enter the name of the beggar > ");
			
			innerLangData.put("inputAge_1", "Please enter the age of the beggar > ");
			
			innerLangData.put("choiceGameMenu_1", "Now you want to raise a beggar.\n");
			innerLangData.put("choiceGameMenu_2", "What action would you like to take?\n");
			innerLangData.put("choiceGameMenu_3", "1. Begging\n");
			innerLangData.put("choiceGameMenu_4", "2. Gakseolitaryeong\n");
			innerLangData.put("choiceGameMenu_5", "3. Hire a beggar\n");
			innerLangData.put("choiceGameMenu_6", "4. Upgrade\n");
			innerLangData.put("choiceGameMenu_7", "5. Buying items\n");
			innerLangData.put("choiceGameMenu_8", "6. Building fraud\n");
			innerLangData.put("choiceGameMenu_9", "7. Buying country\n");
			innerLangData.put("choiceGameMenu_10", "8. View current status\n");
			innerLangData.put("choiceGameMenu_11", "9. Game over\n");
			innerLangData.put("choiceGameMenu_12", "What action would you like to take?\n");
			
			innerLangData.put("showBegResult_1", "You begged.\n");
			innerLangData.put("showBegResult_2", "Begging fever has been applied.\n");
			innerLangData.put("showBegResult_3", "You earned %s won.\n");
			
			innerLangData.put("showCurrentMoney_1", "You currently have %s.\n");
			
			innerLangData.put("showGakseolitaryeongResult_1", "You have come to a gakseolitaryeong.\n");
			innerLangData.put("showGakseolitaryeongResult_2", "You earned %s won.\n");
			
			innerLangData.put("showNotUseGakseolitaryeong_1", "You cannot do gakseolitaryeong.\n");
			innerLangData.put("showNotUseGakseolitaryeong_2", "Please check whether you have gakseolitaryeong.\n");
			
			innerLangData.put("hireBeggar_1", "You can hire a beggar.\n");
			innerLangData.put("hireBeggar_2", "Which beggar would you hire?\n");
			innerLangData.put("hireBeggar_3", "%s. %s Multiplier: %s Price: %s\n");
			innerLangData.put("hireBeggar_4", "%s. stop hiring\n");
			
			innerLangData.put("showHireBeggarResult_1", "A beggar was hired.\n");
			innerLangData.put("showHireBeggarResult_2", "You don't have enough money to hire this beggar.\n");
			
			innerLangData.put("upgradeBeggar_1", "You can get upgrades related to beggars.\n");
			innerLangData.put("upgradeBeggar_2", "Which would you like to upgrade?\n");
			innerLangData.put("upgradeBeggar_3", "1. Upgrade money earned through begging\n");
			innerLangData.put("upgradeBeggar_4", "2. Upgrading the money earned through gakseolitaryeong\n");
			innerLangData.put("upgradeBeggar_5", "%s. %s upgrade\n");
			innerLangData.put("upgradeBeggar_6", "%s. End upgrade\n");
			
			innerLangData.put("begUpgradeYN_1", "You are currently begging\n");
			innerLangData.put("begUpgradeYN_2", "At least %s won\n");
			innerLangData.put("begUpgradeYN_3", "Up to %s won\n");
			innerLangData.put("begUpgradeYN_4", "You earn as much as you earn, and the upgrade cost is %s won.\n");
			innerLangData.put("begUpgradeYN_5", "Do you want to upgrade? (Y/N) > ");
			
			innerLangData.put("showBegUpgradeResult_1", "Begging has been upgraded.\n");
			innerLangData.put("showBegUpgradeResult_2", "You don't have enough money to upgrade.\n");
			
			innerLangData.put("showNotContinueBegUpgrade_1", "You didn't go through with the begging upgrade.\n");
			
			innerLangData.put("gakseolitaryeongUpgradeYN_1", "You are currently through gakseoritaryeong.\n");
			innerLangData.put("gakseolitaryeongUpgradeYN_2", "At least %s won\n");
			innerLangData.put("gakseolitaryeongUpgradeYN_3", "Up to %s won\n");
			innerLangData.put("gakseolitaryeongUpgradeYN_4", "You earn as much as you earn, and the upgrade cost is %s won.\n");
			innerLangData.put("gakseolitaryeongUpgradeYN_5", "Do you want to upgrade? (Y/N) > ");
			
			innerLangData.put("showGakseolitaryeongUpgradeResult_1", "You have upgraded gakseolitaryeong.\n");
			innerLangData.put("showGakseolitaryeongUpgradeResult_2", "You don't have enough money to upgrade.\n");
			
			innerLangData.put("machineUpgradeYN_1", "You are currently using %s\n");
			innerLangData.put("machineUpgradeYN_2", "You automatically earn %s won every second.\n");
			innerLangData.put("machineUpgradeYN_3", "The upgrade cost is %s won.\n");
			innerLangData.put("machineUpgradeYN_4", "Do you want to upgrade? (Y/N) > ");
			
			innerLangData.put("showMachineUpgradeResult_1", "%s has been upgraded.\n");
			innerLangData.put("showMachineUpgradeResult_2", "You don't have enough money to upgrade.\n");
			
			innerLangData.put("showNotContinueGakseolitaryeongUpgrade_1", "The upgrade has not been performed.\n");
			
			innerLangData.put("showNotContinueMachineUpgrade_1", "The %s upgrade did not proceed.\n");
			
			innerLangData.put("buyItem_1", "1. Purchase %s Begging Fever (currently owns %s) Price: %s won\n");
			innerLangData.put("buyItem_2", "2. Purchase %s pieces of gakseolitaryeong (currently owns %s pieces) Price: %s won\n");
			innerLangData.put("buyItem_3", "3. End of item purchase\n");
			
			innerLangData.put("showBuyBegFeverResult_1", "You bought %s Begging Fever.\n");
			innerLangData.put("showBuyBegFeverResult_2", "You don't have money to buy begging fever.\n");
			
			innerLangData.put("showBuyGakseolitaryeongResult_1", "You bought %s gakseolitaryeong.\n");
			innerLangData.put("showBuyGakseolitaryeongResult_2", "You don't have money to buy gakseolitaryeong.\n");
			
			innerLangData.put("buyBuilding_1", "You can buy a building.\n");
			innerLangData.put("buyBuilding_2", "Which building would you like to buy?\n");
			innerLangData.put("buyBuilding_3", "%s. %s price: %s won\n");
			innerLangData.put("buyBuilding_4", "%s. Ending Buy Building\n");
			
			innerLangData.put("showBuyMachineResult_1", "You purchased %s.\n");
			innerLangData.put("showBuyMachineResult_2", "There is no money to purchase %s.\n");
			
			innerLangData.put("buyNation_1", "You can buy a country.\n");
			innerLangData.put("buyNation_2", "Which country would you like to live in?\n");
			innerLangData.put("buyNation_3", "%s. %s price: %s won\n");
			innerLangData.put("buyNation_4", "%s. End Buy country\n");
			
			innerLangData.put("showBegInfo_1", "Your name is %s and your age is %s.\n");
			innerLangData.put("showBegInfo_2", "You earn at least %s won and up to %s won through begging.\n");
			innerLangData.put("showBegInfo_3", "The current begging upgrade cost is %s won.\n");
			innerLangData.put("showBegInfo_4", "You earn a minimum of %s won and a maximum of %s won through gakseolitaryeong.\n");
			innerLangData.put("showBegInfo_5", "The current upgrade cost for Gakseolitaryeong is %s won.\n");
			innerLangData.put("showBegInfo_6", "The items you have are.\n");
			innerLangData.put("showBegInfo_7", "Begging Fever: %s\n");
			innerLangData.put("showBegInfo_8", "Gakseolitaryeong: %s\n");
			innerLangData.put("showBegInfo_9", "Here are the beggars you hired.\n");
			innerLangData.put("showBegInfo_10", "There are no hired beggars.\n");
			innerLangData.put("showBegInfo_11", "%s\n");
			innerLangData.put("showBegInfo_12", "--- Money earned per second: %s\n");
			innerLangData.put("showBegInfo_13", "--- Current upgrade cost: %s\n");
			innerLangData.put("showBegInfo_14", "The building you purchased is\n");
			innerLangData.put("showBegInfo_15", "No buildings have been purchased.\n");
			innerLangData.put("showBegInfo_16", "The country you purchased from is\n");
			innerLangData.put("showBegInfo_17", "There are no countries in which it was purchased.\n");
			
			innerLangData.put("showReset_1", "Reset the game.\n");
			
			innerLangData.put("sayGoodbye_1", "Thank you for enjoying the game!\n");
			
			innerLangData.put("showWrongInput_1", "Invalid input. Please enter again > ");
			
			innerLangData.put("showNotRangeInput_1", "You must enter a number between %s and %s. Please enter again > ");
			
			innerLangData.put("showChangeLang_1", "Please select the language you want to set.\n");
			
			innerLangData.put("changeLang_1", "Language has been changed!\n");
		}
		lang.put(langCode, innerLangData);
	}
	public void hello() {
		System.out.println(".,,,,,,,,...,,.,,,,..,.....,,,,,,,,.....,..:!: .,,,,,,,,..........");
		System.out.println("..,~-,,...,,,.::~-,....,.... ~~-,,...,...;@@@@@~.---,,...,,,......");
		System.out.println("..*@@@@#$;  .-@@@@@#! ......,@@@@##!   .!@@!~=@$.#@@@@#=:  .......");
		System.out.println("..;$$#@@@$:#*.!@@##@**@*....-=$#@@@#!$!.@@~..-@@.=$$#@@@*#$.......");
		System.out.println(",...   !@*:@$  @@~ ,-*@*.,,,.    :@=*@*-@@.,,:@# ..  .#@!@$.,,,,,,");
		System.out.println(",,,,,, #!=$@$ ,@@,.. *@*.,,,,==**=@**@=.@@*:!#@;.,,,,,@#:@$.,,,,,,");
		System.out.println("..... ,@!@@@$ ~@@@#;.*@*... ~@@@@@@;!@= ~@@@@@*......;@=~@$. .....");
		System.out.println("   ...*@!-!@$ !@@@@@@$#* .. .--~:@@-*@= -:*==!:~ ....$@:~@$.      ");
		System.out.println("... ..$@~ !@= =@* ,!#$#*....... :@@ *@*.@@@@@@@* ...-@#,:@$.......");
		System.out.println("...  ,$#, -:- ;$~    ~!~ .......#@; :!:.==$@@=!~ .. ;@! ,:~.......");
		System.out.println(".....  . ..  .   ....   ....... .:..       ##,  .... . ..  .......");
		System.out.println("................................. ...... . ,, ....................");
		System.out.println();
		displayMsg("hello_1");
		displayMsg("hello_2");
		System.out.println();
	}

	public int choiceMenu() {
		displayMsg("choiceMenu_1");
		displayMsg("choiceMenu_2");
		displayMsg("choiceMenu_3");
		System.out.println("3. 언어 설정(language setting)");
		displayMsg("choiceMenu_4");
		displayMsg("common_choice");
		return getNumberInput(1, 4);
	}
	
	public String inputName() {
		displayMsg("inputName_1");
		displayMsg("inputName_2");
		displayMsg("inputName_3");
		return getStringInput();
	}
	
	public int inputAge() {
		displayMsg("inputAge_1");
		return getNumberInput();
	}
	
	public int choiceGameMenu() {
		printDivider();
		displayMsg("choiceGameMenu_1");
		displayMsg("choiceGameMenu_2");
		displayMsg("choiceGameMenu_3");
		displayMsg("choiceGameMenu_4");
		displayMsg("choiceGameMenu_5");
		displayMsg("choiceGameMenu_6");
		displayMsg("choiceGameMenu_7");
		displayMsg("choiceGameMenu_8");
		displayMsg("choiceGameMenu_9");
		displayMsg("choiceGameMenu_10");
		displayMsg("choiceGameMenu_11");
		displayMsg("choiceGameMenu_12");
		displayMsg("common_choice");
		return getNumberInput(1, 9);
	}
	
	public void showBegResult(boolean useFever, int earnMoney) {
		displayMsg("showBegResult_1");
		if(useFever) {
			displayMsg("showBegResult_2");
		}
		displayMsg("showBegResult_3", formatMoney(earnMoney));
	}
	
	public void showCurrentMoney(long money) {
		displayMsg("showCurrentMoney_1", formatMoney(money));
	}
	
	public void showGakseolitaryeongResult(int earnMoney) {
		displayMsg("showGakseolitaryeongResult_1");
		displayMsg("showGakseolitaryeongResult_2", formatMoney(earnMoney));
	}
	
	public void showNotUseGakseolitaryeong() {
		displayMsg("showNotUseGakseolitaryeong_1");
		displayMsg("showNotUseGakseolitaryeong_2");
	}
	
	public int hireBeggar() {
		displayMsg("hireBeggar_1");
		displayMsg("hireBeggar_2");
		for(int i=0;i<EmployBeggar.WHOLE_EMPLOY_BEGGAR.length;i++) {
			EmployBeggar employ = EmployBeggar.WHOLE_EMPLOY_BEGGAR[i];
			int price = employ.getBuyPrice();
			displayMsg("hireBeggar_3", (i+1), employ.getName(), employ.getMul(), formatMoney(price));
		}
		displayMsg("hireBeggar_4", (EmployBeggar.WHOLE_EMPLOY_BEGGAR.length + 1));
		displayMsg("common_choice");
		return getNumberInput(1, EmployBeggar.WHOLE_EMPLOY_BEGGAR.length + 1);
	}
	
	public void showHireBeggarResult(boolean isHired) {
		if(isHired) {
			displayMsg("showHireBeggarResult_1");
		} else {
			displayMsg("showHireBeggarResult_2");
		}
	}
	
	public int upgradeBeggar(ArrayList<String> names) {
		displayMsg("upgradeBeggar_1");
		displayMsg("upgradeBeggar_2");
		displayMsg("upgradeBeggar_3");
		displayMsg("upgradeBeggar_4");
		for(int i=0;i<names.size();i++) {
			displayMsg("upgradeBeggar_5", (i+3), names.get(i));
		}
		displayMsg("upgradeBeggar_6",(names.size()+3));
		displayMsg("common_choice");
		return getNumberInput(1, names.size() + 3);
	}
	
	public boolean begUpgradeYN(int minMoney, int maxMoney, int price) {
		displayMsg("begUpgradeYN_1");
		displayMsg("begUpgradeYN_2", formatMoney(minMoney));
		displayMsg("begUpgradeYN_3", formatMoney(maxMoney));
		displayMsg("begUpgradeYN_4", formatMoney(price));
		displayMsg("begUpgradeYN_5");
		return getStringInput().charAt(0) == 'Y';
	}
	
	public void showBegUpgradeResult(boolean result) {
		if(result) {
			displayMsg("showBegUpgradeResult_1");
		} else {
			displayMsg("showBegUpgradeResult_2");
		}
	}
	
	public void showNotContinueBegUpgrade() {
		displayMsg("showNotContinueBegUpgrade_1");
	}
	
	public boolean gakseolitaryeongUpgradeYN(int minMoney, int maxMoney, int price) {
		displayMsg("gakseolitaryeongUpgradeYN_1");
		displayMsg("gakseolitaryeongUpgradeYN_2", formatMoney(minMoney));
		displayMsg("gakseolitaryeongUpgradeYN_3", formatMoney(maxMoney));
		displayMsg("gakseolitaryeongUpgradeYN_4", formatMoney(price));
		displayMsg("gakseolitaryeongUpgradeYN_5");
		return getStringInput().charAt(0) == 'Y';
	}
	
	public void showGakseolitaryeongUpgradeResult(boolean result) {
		if(result) {
			displayMsg("showGakseolitaryeongUpgradeResult_1");
		} else {
			displayMsg("showGakseolitaryeongUpgradeResult_2");
		}
	}
	
	public void showNotContinueGakseolitaryeongUpgrade() {
		displayMsg("showNotContinueGakseolitaryeongUpgrade_1");
	}
	
	public boolean machineUpgradeYN(String name, double mul, int upgradePrice) {
		displayMsg("machineUpgradeYN_1", name);
		displayMsg("machineUpgradeYN_2", mul);
		displayMsg("machineUpgradeYN_3", formatMoney(upgradePrice));
		displayMsg("machineUpgradeYN_4");
		return getStringInput().charAt(0) == 'Y';
	}
	
	public void showMachineUpgradeResult(boolean result, String name) {
		if(result) {
			displayMsg("showMachineUpgradeResult_1", name);
		} else {
			displayMsg("showMachineUpgradeResult_2");
		}
	}
	
	public void showNotContinueMachineUpgrade(String name) {
		displayMsg("showNotContinueMachineUpgrade_1", name);
	}
	
	public int buyItem(int curBegFeverCount, int curGakseolitaryeongCount) {
		displayMsg("buyItem_1", CONSTANT.BEG_FEVER_ITEM_BUNDLE_SIZE, curBegFeverCount, formatMoney(CONSTANT.BEG_FEVER_PRICE));
		displayMsg("buyItem_2", CONSTANT.GAKSEOLITARYEONG_ITEM_BUNDLE_SIZE, curGakseolitaryeongCount, formatMoney(CONSTANT.GAKSEOLITARYEONG_PRICE));
		displayMsg("buyItem_3");
		displayMsg("common_choice");
		return getNumberInput(1, 3);
	}
	
	public void showBuyBegFeverResult(boolean result) {
		if(result) {
			displayMsg("showBuyBegFeverResult_1",  CONSTANT.BEG_FEVER_ITEM_BUNDLE_SIZE);
		} else {
			displayMsg("showBuyBegFeverResult_2");
		}
	}
	
	public void showBuyGakseolitaryeongResult(boolean result) {
		if(result) {
			displayMsg("showBuyGakseolitaryeongResult_1", CONSTANT.GAKSEOLITARYEONG_ITEM_BUNDLE_SIZE);
		} else {
			displayMsg("showBuyGakseolitaryeongResult_2");
		}
	}
	
	public int buyBuilding(ArrayList<String> names, ArrayList<Integer> prices) {
		displayMsg("buyBuilding_1");
		displayMsg("buyBuilding_2");
		for(int i=0;i<names.size();i++) {
			displayMsg("buyBuilding_3", (i+1), names.get(i), formatMoney(prices.get(i)));
		}
		displayMsg("buyBuilding_4", (names.size() + 1));
		displayMsg("common_choice");
		return getNumberInput(1, names.size() + 1);
	}
	
	public void showBuyMachineResult(boolean result, String name) {
		if(result) {
			displayMsg("showBuyMachineResult_1", name);
		} else {
			displayMsg("showBuyMachineResult_2", name);
		}
	}
	
	public int buyNation(ArrayList<String> names, ArrayList<Integer> prices) {
		displayMsg("buyNation_1");
		displayMsg("buyNation_2");
		for(int i=0;i<names.size();i++) {
			displayMsg("buyNation_3", i+1, names.get(i), formatMoney(prices.get(i)));
		}
		displayMsg("buyNation_4", names.size() + 1);
		displayMsg("common_choice");
		return getNumberInput(1, names.size() + 1);
	}
	
	public void showBegInfo(
			String beggarName,
			int beggarAge,
			int begMinMoney,
			int begMaxMoney,
			int begUpgradePrice,
			int gakseolitaryeongMinMoney,
			int gakseolitaryeongMaxMoney,
			int gakseolitaryeongUpgradePrice,
			int begFeverCount,
			int gakseolitaryeongCount,
			ArrayList<String> employBeggarNames,
			ArrayList<Double> employBeggarMuls,
			ArrayList<Integer> employBeggarUpgradePrices,
			ArrayList<String> buildingNames,
			ArrayList<Double> buildingMuls,
			ArrayList<Integer> buildingUpgradePrices,
			ArrayList<String> nationNames,
			ArrayList<Double> nationMuls,
			ArrayList<Integer> nationUpgradePrices
			) {
		displayMsg("showBegInfo_1", beggarName, beggarAge);
		displayMsg("showBegInfo_2", formatMoney(begMinMoney), formatMoney(begMaxMoney));
		displayMsg("showBegInfo_3", formatMoney(begUpgradePrice));
		displayMsg("showBegInfo_4", formatMoney(gakseolitaryeongMinMoney), formatMoney(gakseolitaryeongMaxMoney));
		displayMsg("showBegInfo_5", formatMoney(gakseolitaryeongUpgradePrice));
		displayMsg("showBegInfo_6");
		displayMsg("showBegInfo_7", begFeverCount);
		displayMsg("showBegInfo_8", gakseolitaryeongCount);

		displayMsg("showBegInfo_9");
		if(employBeggarNames.isEmpty()) {
			displayMsg("showBegInfo_10");
		} else {
			for(int i=0;i<employBeggarNames.size();i++) {
				displayMsg("showBegInfo_11", employBeggarNames.get(i));
				displayMsg("showBegInfo_12", employBeggarMuls.get(i));
				displayMsg("showBegInfo_13", formatMoney(employBeggarUpgradePrices.get(i)));
			}
		}

		displayMsg("showBegInfo_14");
		if(buildingNames.isEmpty()) {
			displayMsg("showBegInfo_15");
		} else {
			for(int i=0;i<buildingNames.size();i++) {
				displayMsg("showBegInfo_11", buildingNames.get(i));
				displayMsg("showBegInfo_12", buildingMuls.get(i));
				displayMsg("showBegInfo_13", formatMoney(buildingUpgradePrices.get(i)));
			}
		}

		displayMsg("showBegInfo_16");
		if(nationNames.isEmpty()) {
			displayMsg("showBegInfo_17");
		} else {
			for(int i=0;i<nationNames.size();i++) {
				displayMsg("showBegInfo_11", nationNames.get(i));
				displayMsg("showBegInfo_12", nationMuls.get(i));
				displayMsg("showBegInfo_13", formatMoney(nationUpgradePrices.get(i)));
			}
		}
	}
	
	public void showReset() {
		displayMsg("showReset_1");
	}
	
	public void sayGoodbye() {
		printDivider();
		displayMsg("sayGoodbye_1");
	}
	
	public int showChangeLang() {
		displayMsg("showChangeLang_1");
		System.out.println("1. 한국어");
		System.out.println("2. English");
		displayMsg("common_choice");
		return getNumberInput(1,2);
	}
	
	public void changeLang(String code) {
		curLang = code;
		displayMsg("changeLang_1");
	}
	
	private void printDivider() {
		System.out.println("==================================================");
	}
	
	private String formatMoney(long m) {
		String mString = m + "";
		ArrayList<String> tokens = new ArrayList<>();
		int endIdx = mString.length();
		int startIdx = endIdx - 3;
		while (startIdx >= 0) {
			tokens.add(mString.substring(startIdx, endIdx));
			endIdx = startIdx;
			startIdx -= 3;
		}
		tokens.add(mString.substring(0, endIdx));
		StringBuilder sb = new StringBuilder();
		for (int i = tokens.size() - 1; i >= 0; i--) {
			sb.append(tokens.get(i));
			if (i > 0 && !tokens.get(i).isBlank()) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	private int getNumberInput() {
		Integer ret = null;
		while (ret == null) {
			try {
				ret = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				showWrongInput();
				ret = null;
			}
		}
		return ret;
	}

	private int getNumberInput(int minInput, int maxInput) {
		Integer ret = null;
		while (ret == null) {
			try {
				ret = Integer.parseInt(sc.nextLine());
				if (ret < minInput || ret > maxInput) {
					showNotRangeInput(minInput, maxInput);
					ret = null;
				}
			} catch (NumberFormatException e) {
				showWrongInput();
				ret = null;
			}
		}
		return ret;
	}
	
	private String getStringInput() {
		String ret = null;
		while(ret == null) {
			ret = sc.nextLine();
			if(ret != null && ret.isBlank()) {
				showWrongInput();
				ret = null;
			}
		}
		return ret;
	}
	
	private void showWrongInput() {
		displayMsg("showWrongInput_1");
	}

	private void showNotRangeInput(int minInput, int maxInput) {
		displayMsg("showNotRangeInput_1", minInput, maxInput);
	}
	
	private void displayMsg(String key, Object... args) {
		Map<String, String> innerLangData = lang.get(curLang);
		if(innerLangData == null) {
			innerLangData = lang.get(LANG_KO);
		}
		String msg = innerLangData.get(key);
		if(msg == null) {
			msg = lang.get(LANG_KO).get(key);
		}
		if(msg == null) {
			System.err.println("key " + key +" is not exist");
		} else {
			System.out.printf(msg , args);
		}
	}
}
