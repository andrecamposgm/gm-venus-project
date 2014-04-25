package com.greenmile.gmven.version;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VersionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIfBuildIsOK() {
		assertNotNull(new Version().getBuild());
	}

	@Test
	public void testIfVersionIsOK() {
		assertNotNull(new Version().getVersion());
	}

}
