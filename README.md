# 207-Group-Project: [UofT Meta](https://uoftmeta.ca)

## Discription:

The program allows users to post blogs and leave likes and comment under others’ posts. The users are also able to add friends and chat with each other. The user can also draw pictures for their post.

## Clean Architecture

Our programs adhere to Clean Architecture. 

The program is divided into 4 layers: Frameworks & Drivers, Interface Adapters, Application Business Rules, Enterprise Business Rule

Frameworks & Drivers layer contains database and UI.

The Interface Adapters layer contains the controllers, the presenter and the gateways.

The Application Business Rules layer contains the use cases.

The Enterprise Business Rule layer contains the entities and factories.

The user input is passed to the controller from the view, the controller then calls the use case through the request model and passes the input to the use case. The use case then calls the gateway to access the database and returns the result to the presenter. The use case then passes the result to the presenter and gateway through the response model, and the presenter returns the result to the view and gateway writes the result into the database.

## Design Pattern
Simple factory: The program has a class that has one creation method with a large conditional that based on method parameters chooses which product class to instantiate and then return. We implemented several factories that take in request models and produce entities.

Facade: The program has a class that has a single method that hides the complexity of a system and provides a simple interface to the client. We implemented use cases by separating different functions into different classes and then integrating them in the use case facade.

Dependency injection: The program has a class that has a dependency on another class and the dependency is passed in through the constructor. The use case has dependency on its corresponding entity. Such dependency is enabled by passing the entity directly to the use case’s constructor

Command: The program has a class that has a method that takes in user inputs as the requested values; then the controller of the program will change the request into different objects like post, user or comment and pass the objects to the use cases to operate.

Template method: The program has a class that has a method that defines the skeleton of an algorithm and defers some steps to subclasses. We have output boundary ResponseModel and input boundary RequestModel which are inherited by multiple response models and request models. The subclasses override get() method in the parent class.

Proxy: The program has a class that has a method that acts as an interface to something else. The program has response and request models for entities like user, post and comment. The models act as placeholders for the entities and prevents immediate access to these entities. 


## Entity.User Scenarios:

*Outdated, for more info, please reference proj blueprint.*

Zac wants to share his stories about the class with others in the form of a post.

Zac wants to add his friend to the same lecture online.

Zac wants to chat with his friend online.

Zac wants to leave a like and comment under his friend’s post.

Zac wants to see the hottest post on the topic he searches for.

Zac wants to see what the hottest topic is currently.

Zac wants to draw a picture and post it online.

## Contributors:

StarryDust-02: Tianyu Li

KevinTQJ: Kevin Wu

Anesthez: Yufei Chen

LemengDai: Lemeng Dai

eric-qli: Eric Li

loveillusion: Yijun(Kevin) Zhao

ChenJiang03: Chen Jiang

Excelsior31: Jiahao Gu
