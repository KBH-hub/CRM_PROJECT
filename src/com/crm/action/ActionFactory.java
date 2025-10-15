package com.crm.action;

import com.crm.action.smsService.GetTemplateAction;
import com.crm.action.smsService.ReserveListModalAction;
import com.crm.action.smsService.ReserveSmsUIAction;
import com.crm.action.smsService.SmsUIAction;

public class ActionFactory {
	private ActionFactory() {
	}// 외부에서 접근 금지 위해 생성자 메서드 private

	public static Action getAction(String cmd) {
		Action a = null;
		// 구현부
		switch (cmd) {
		case "smsUI":
			a = new SmsUIAction();
			break;
		case "reserveSmsUI":
			a = new ReserveSmsUIAction();
			break;
		case "getTemplate":
			a = new GetTemplateAction();
			break;
		case "reserveListModal":
			a = new ReserveListModalAction();
			break;
		}

		
		
		return a;// 4
	}

}
