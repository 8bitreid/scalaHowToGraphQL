## HowToGraph - GraphQL with Sangria Tutorial codebase

A code for GraphQL-Sangria Tutorial. Visit [HowtoGraphql.com](http://howtographql.com) to learn more.  

### Running the example

```bash
sbt ~reStart
```

SBT will automatically compile and restart the server whenever the source code changes.

After the server is started you can run queries interactively using [GraphiQL](https://github.com/graphql/graphiql) by opening [http://localhost:8080](http://localhost:8080) in a browser.

Use different PORT if you've changed it int he configuration.

### Database Configuration

This example uses an in-memory [H2](http://www.h2database.com/html/main.html) SQL database. The schema and example data will be re-created every time server starts.

If you would like to change the database configuration or use a different database, then please update `src/main/resources/application.conf`.

```graphql
query {
	users(ids: 1) {
    name,
    links{
      url,
      description
    }
	}
}

mutation addMe {
  createUser(
    name: "Mario",
    authProvider:{
      email:{
        email:"mario@example.com",
        password:"p4ssw0rd"
      }
    }){
    id
    name
  }
}
query{
  users(ids: 3){
    name
  }
}

mutation addLink {
  createLink(
    url: "howtographql.com",
    description: "Great tutorial page",
    postedById: 1
  ){
    url
    description
    postedBy{
      name
    }
  }

}
query{
  users(ids: 1){
    links{
      url,
      description
    }
  }
}

mutation loginAndAddLink {
  login(
    email:"fred@flinstones.com",
    password:"wilmalove"
  ){
    name
  }

  createLink(
    url: "howtographql.com",
    description: "Great tutorial page",
    postedById: 2
  ){
    url
    description
    postedBy{
      name
    }
  }
}
```

