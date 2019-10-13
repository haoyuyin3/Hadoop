package stubs;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.fs.Path;


public class IndexMapper extends Mapper<Text, Text, Text, Text> {

  @Override
  public void map(Text key, Text value, Context context) throws IOException,
      InterruptedException {

    /*
     * TODO implement
     */
	  FileSplit fileSplit = (FileSplit) context.getInputSplit();  
	    Path path = fileSplit.getPath();  
	      
	    String word = path.getName() + "@" + key.toString();  
	    Text location = new Text(word);  
	      
	    String lc_words = value.toString().toLowerCase();  
	      
	    for (String final_words : lc_words.split("\\W+")) {  
	      if (final_words.length() > 0) {  
	        context.write(new Text(final_words), location);  
	      }  
	    }  
    
  }
}