import java.io.*;

public class Main {
  static public void main(String argv[]) {
    /* Start the parser */
    try {
      parser p = new parser(new Ada95Lexer(new FileReader(argv[0])));
      if(argv.length==2 && argv[1].equals("-debug")){	
	      Object result = p.debug_parse().value;
	}else{
	     Object result = p.parse().value;
	}

    } catch (Exception e) {
      /* do cleanup here -- possibly rethrow e */
      e.printStackTrace();
    }
  }
}
