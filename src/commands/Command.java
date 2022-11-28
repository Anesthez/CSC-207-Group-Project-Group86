package commands;

import java.io.IOException;

public abstract class Command {
    String[] inputLines;
    int userid;



    public Command(String[] inputLines, int userid){
        this.inputLines = inputLines;
        this.userid = userid;
    }



    public abstract void exact() throws IOException;
}
