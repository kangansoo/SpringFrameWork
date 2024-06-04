package springFw.ex02.dp01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LoggerFile implements LoggerInterface {

	@Override
	public void writeLog(String log) throws Exception {
		try {
			Path path = Paths.get("./log.txt");
			if (!Files.exists(path)) Files.createFile(path);
			
			byte[] data = (log + System.lineSeparator()).getBytes();
			
			Files.write(path, data, StandardOpenOption.APPEND);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
