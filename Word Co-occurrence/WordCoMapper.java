package stubs;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCoMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
    /*
     * TODO implement
     */
	  String input_line = value.toString();
	  StringBuffer last_w = new StringBuffer();
	  
	  boolean first_letter = true;
	  
	  for (String final_words : input_line.split("\\W+"))
	  {
		  if (final_words.length() > 0)
		  {
			  if (first_letter)
			  {
				  last_w.append(final_words.toLowerCase());
				  first_letter = false;
				  continue;
			  }
			  
			  last_w.append(',');
			  last_w.append(final_words.toLowerCase());
			  
			  context.write(new Text(last_w.toString()), new IntWritable(1));
			  
			  last_w.delete(0, last_w.length());
			  last_w.append(final_words.toLowerCase());
		  }
	  }
    
  }
}
