//import org.apache.log4j.Logger;

import org.slf4j.*;

public class TestApp {
	private static final Logger logger =
			LoggerFactory.getLogger("TestApp");

	public static void main(String[] args) {
		logger.debug("This is debug");
		logger.info("This is info");
		logger.warn("This is warn");
		logger.error("This is error");
	}
}
