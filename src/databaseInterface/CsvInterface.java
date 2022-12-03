package databaseInterface;

/**
 * <p>The csvInterface class is a class that will be used to read and write csv files.</p>
 * <p>The class will be used to read and write csv files for the user, post, comment, and chat objects.</p>
 *
 * @Author: Yijun(Kevin) Zhao
 * @Modifiedby: Yufei Chen, Chen Jiang
 */

public class CsvInterface implements PostCsvGateway
        ,PostLikedCsvGateway
        ,UserCsvGateway
        ,TopicCsvGateway
        ,FriendsCsvGateway
        ,ChatCsvGateway
        ,CommentCsvGateway
        ,BlockCsvGateway{}
