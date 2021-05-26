# reactive
 
A template for reactive server using Spring boot, which connects to a ```mongodb``` hosted using [cloud.mongodb.com](https://cloud.mongodb.com/). The application can do basic CRUD opetations for a very simple ```Employee DTO```.

[![build pipeline](https://circleci.com/gh/ImRohitSingh/reactive.svg?style=svg)](https://circleci.com/gh/ImRohitSingh/reactive)

The application is currently hosted at [Heroku](https://www.heroku.com/).

## Server

> reactiveservertemplate.herokuapp.com

## Endpoints

#### create

```sh
endpoint: /create
method: PUT
request:
    raw:
        {
            "name":<String>,
            "salary": <long>
        }
```

#### get all

```sh
endpoint: /getAll
method: GET
```

#### get by name
```sh
endpoint: /getByName
method: GET
request:
    path-parameter:
        {name-of-the-employee}
```

## Reactive Nature

To observe the reactive nature, do the following steps:

1. Open the following link using Chrome:
> [get all](https://reactiveservertemplate.herokuapp.com/getAll)

2. Using [Postman](https://www.postman.com/downloads/), [create](https://github.com/ImRohitSingh/reactive#create) a new employee.

3. Go back to Chrome where you have opened the first link. You should see the new employe ```without reloading the page```.