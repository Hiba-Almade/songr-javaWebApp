package com.example.songr;

import com.example.songr.models.Album;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void albumTester() {
		Album album = new Album("test", "artist 1", 6, 33, "test");
		Assertions.assertEquals(album.getTitle(), "test");
	}

}
