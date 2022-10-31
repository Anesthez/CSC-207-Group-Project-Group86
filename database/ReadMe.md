## Some Documentation Relates to Changes

### Place Holder Guide

Placeholders for empty cells:

> placeholder int: -1
> placeholder String: "none"

### user.csv

> userid, user-type, password, name  

No changes!

### post.csv

> userid,postid,time,content,num-liked  

No changes!

### post_liked.csv

> userid,list-postid  

Change "list of postid" to "list-postid" so that it is shorter.

### friends.csv

> userid,list-userid  

Change from *n* variables/col titled userid for *n* is the number of friends, to a list of friends' user ids.

### comments.csv

> postid,userid,time,content  

No changes!

### chat.csv

> userid-1,userid-2,time,message,author 
 
Changed variables:  
**userid-1**: the person who initiated the chat.  
**userid-2**: the person who received the chat.  
**author**: a new variable, denotes the author for the message in current row/obs.  
Note that *i* in **author** and *i* is **userid-1** or **userid-2** from the same row/obs.
