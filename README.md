# projectManagementBot

## Discord Bot to help you keep track of tasks and projects

It also allows:
- Assigning tasks to user
- Have an overview of the job repartition
- Have an overview of the tasks completion state (`completed` / `pending`)
-

Database Schema (database collections architechture):
- guilds
- users
- projects
- tasks

Technologies used:
- Spring
- MongoDB
- JDA-5.0.0-alpha.17 (JAVA Discord API)
- Maven

TODO:
- [x] Containerize the bot and its database
- [ ] Generate logs messages
- [x] Implement ping command
- [ ] Implement command to create a new project (and reverse)
- [ ] Implement command to create a new task (and reverse)
- [ ] Implement command to assign a task to a user (and reverse)
- [ ] Implement command to change the state of a task (and reverse)
- [ ] Implement command to get an overview of the tasks completion state (and reverse)
- [ ] Implement command to get an overview of the job repartition (and reverse)
- [ ] Create a testing environment
- [ ] Write tests
- [ ] Create a CI/CD pipeline
- [ ] Create a web API to manage the tasks

