package com.ubluetech.externalapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class ExternalapiApplicationTests {
	private static final String API_VERSION = "1.0";
	
	@Autowired
	private WebTestClient webTestClient;

	@BeforeEach
	void setUp() {
		webTestClient = WebTestClient.bindToServer()
									// .baseUrl("http://api-secure.test.hotelbeds.com/hotel-content-api/")
									.build();
	}

	@Test
	void testGetAllHotelbeds() {
		webTestClient.get()
					.uri("/hotels?fields=all&language=ENG&from=1&to=100&useSecondaryLanguage=false")
					.accept(MediaType.APPLICATION_JSON)
					.attribute("Api-key", "44a91ec4395b6807f685493a295dd4eb")
					.attribute("X-Signature", "")
					.exchange()
					.expectStatus().isOk();
	}

}
