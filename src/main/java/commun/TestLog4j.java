package commun;

/**
 * cette classe est une démo pour comprendre le fonctionnement de Log4j
 * Lien : https://mkyong.com/logging/log4j-log4j-properties-examples/
 * https://springframework.guru/log4j-2-configuration-using-properties-file/
 * 
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;

public class TestLog4j {

	private static Logger logger = LogManager.getLogger(TestLog4j.class);

	public static void main(String[] args) {  
		/*
		System.out.println("-- Ceci est notre Logger ---");
		logger.trace("This is a trace message");
		logger.info("This is information message");
		logger.error("This is error message");
		logger.warn("This is warning message");
		logger.fatal("This is fatal message");
		*/
	}
}


