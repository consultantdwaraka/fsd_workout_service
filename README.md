# fsd_workout_service
# micro service to serve fsd_workout_ui
# How to spin docker container
This service is running on docker container which should communicate with MONGO container, follow the below steps to integrate Spring boot container with MONGO container.
1. Create docker network
	- command: ``` docker network create fsd_workout_network ```
2. Run mongo container
	command: ```docker run -d --name fsdmongocontainer --network=fsd_workout_network -v ~/mongo-data:/data/db mongo```
3. Build FSD_WORKOUT_SERVICE docker build
	- command: ```./mvnw install dockerfile:build```
4. Run FSD_WORKOUT_SERVICE docker image
	- command:```docker run -p 8080:8080 --name fsdworkoutcontainer --network=fsd_workout_network fsd_workout_service```
## Test
