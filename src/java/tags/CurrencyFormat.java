/*
 * Copyright (c) 2016 Evan Elkin
 * Campus Box 7947, Elon University, Elon, NC 27244
 *
 * Copyright (c) 2016 Breslin Wiley
 * Campus Box 7947, Elon University, Elon, NC 27244
 */
package tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.text.NumberFormat;
import java.util.*;

import model.*;

/*
  Java class for the Currency Format custom tag.
*/
public class CurrencyFormat extends TagSupport{
    
    private double value;
    
    public void setValue (double value) {
        this.value = value;
    }
    
    @Override
    public int doStartTag() throws JspException {
        try{
            NumberFormat formatter = NumberFormat.getCurrencyInstance();  
            JspWriter out = pageContext.getOut();
            out.print(formatter.format(value));
          
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return SKIP_BODY;
    }
    
}
