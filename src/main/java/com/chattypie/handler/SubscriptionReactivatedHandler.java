package com.chattypie.handler;

import static com.appdirect.sdk.appmarket.api.APIResult.success;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.appdirect.sdk.appmarket.AppmarketEventHandler;
import com.appdirect.sdk.appmarket.api.APIResult;
import com.appdirect.sdk.appmarket.api.SubscriptionReactivated;
import com.chattypie.service.chattypie.chatroom.ChatroomService;

@Slf4j
@RequiredArgsConstructor
public class SubscriptionReactivatedHandler implements AppmarketEventHandler<SubscriptionReactivated> {

	private final ChatroomService chatroomService;

	@Override
	public APIResult handle(SubscriptionReactivated event) {
		chatroomService.reactivate(event.getAccountInfo().getAccountIdentifier());
		return success("Account reactivated successfully");
	}
}