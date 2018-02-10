package labs.sem03a.seminario2.Seminario2B;

/**
 * Created by guimonto on 07/02/2018.
 */

public class Quotation {

    private String quoteText;
    private String quoteAuthor;

    public String getText(){
        return this.quoteText;
    }

    public void setText(String s){
        this.quoteText = s;
    }

    public String getAuthor(){
        return this.quoteAuthor;
    }

    public void setAuthor(String s){
        this.quoteAuthor = s;
    }

}



