package commands;

/**
 * <p>
 *     A class for TopicCommand.
 * </p>
 * <p>
 *     This class is used to let user to command topic and implement topic functions in command. It contains several
 *     cases: when user wants to view all the topics, they command /show to view all the topics.
 * </p>
 * <p>
 *     This class is part of the Command layer.
 * </p>
 *
 * @Author: Chen Jiang
 * @Modifiedby: Chen Jiang
 */
public class TopicCommand {
    String[] inputlines;
    int userid;
    /**
     * <p>
     *     The constructor of TopicCommand.
     * </p>
     * <p>
     *     This constructor takes in String[] inputlines and int userid and set them to the class.
     * </p>
     * @param inputlines the inputlines of the topic
     * @param userid the userid of the topic
     */
    public TopicCommand(String[] inputlines, int userid)
    {
        this.inputlines = inputlines;
        this.userid = userid;
    }

    /**
     * <p>
     *     The execute method is a method that is used to execute the command.
     * </p>
     * <p>
     *     This method takes in String[] inputlines and int userid and set them to the class.
     * </p>
     */
    public void exact(){
        if (inputlines[1].equals("show"))
        {
            System.out.println("unknown command");
        }
    }
}
