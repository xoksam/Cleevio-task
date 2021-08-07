# DB setup for development
## You need to have `docker` installed!

#### 1. Create a docker container where the DB will run
```shell script
docker run --name eshop-psql -e POSTGRES_PASSWORD=admin -e POSTGRES_DB=eshop-dev -d -p 5436:5432 postgres:11
docker exec -ti eshop-psql psql -U postgres eshop-dev -c "CREATE EXTENSION IF NOT EXISTS unaccent;"
```
#### 2. Start the DB container
``` shell script
docker start eshop-psql
```
* If you want to stop the DB just execute the following command
```
docker stop eshop-psql
```

#### DB info
* Port: `5436`
* Username: `postgres`
* Password: `admin`
* URL: `jdbc:postgresql://localhost:5436/eshop-dev`

#### Useful commands
* Drop entire DB
```postgresql
drop schema public cascade;
create schema public;
```
