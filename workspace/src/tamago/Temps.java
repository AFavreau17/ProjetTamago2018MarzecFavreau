package tamago;

import java.nio.file.Files;
import java.util.Date;

public class Temps {
	
	private long old_time;
	private long current_time;
	Date date = new Date();

	//Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Temps.txt"), "utf-8"))) {
// writer.write("something");
//}
			
	public void setOld_time() {
		this.old_time = this.date.getTime();
	}
	
	public void setCurrent_time() {
		this.current_time = this.date.getTime();
	}
	
	public int diffDate_s() {
		long l = this.current_time - this.old_time; 
		l = l%1000;
		return (int) l;
	}
}