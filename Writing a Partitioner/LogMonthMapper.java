package stubs;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.List;
import java.util.Arrays;

public class LogMonthMapper extends Mapper<LongWritable, Text, Text, Text> {

  /**
   * Example input line:
   * 96.7.4.14 - - [24/Apr/2011:04:20:11 -0400] "GET /cat.jpg HTTP/1.1" 200 12433
   *
   */
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
	  /* TODO: implement */
	  List<String> twelve_months = Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
	  String[] location = value.toString().split(" ");
	  if (location.length > 3)
	  {
		  String IP_address = location[0];
		  
		  String[] ind_location = location[3].split("/");
		  
		  if (ind_location.length > 1)
		  {
			  String month = ind_location[1];
			  
			  if (twelve_months.contains(month))
			  {
				  context.write(new Text(IP_address), new Text(month));
			  }
		  }
	  }
	  
  }
}
