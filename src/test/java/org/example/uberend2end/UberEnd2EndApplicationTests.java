package org.example.uberend2end;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(properties = "grpc.server.port=0") // Use a random port for the gRPC server during tests
@ActiveProfiles("test") // Optional: Activate a 'test' profile if you have specific test configurations
class UberEnd2EndApplicationTests {

	@Test
	void contextLoads() {
	}
}
