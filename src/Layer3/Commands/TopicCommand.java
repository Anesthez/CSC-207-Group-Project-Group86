package Layer3.Commands;

import Layer1.Entity.Topic;
import Layer4.Interface.csvInterface;

import java.io.IOException;
import java.util.Map;

public class TopicCommand {
    String[] inputlines;
    int userid;
    public TopicCommand(String[] inputlines, int userid)
    {
        this.inputlines = inputlines;
        this.userid = userid;
    }

    public void exact() throws IOException {
        csvInterface csvInterface = new csvInterface();
        Map<Integer, Topic> topicMap = csvInterface.topicsReader("database/topic.csv");
        if (inputlines[1].equals("show"))
        {
            for (Integer i : topicMap.keySet())
            {
                System.out.println(topicMap.get(i).getID()+". "+topicMap.get(i).getName());
            }
        }
        else {
            System.out.println("unknown command");
        }
    }
}
