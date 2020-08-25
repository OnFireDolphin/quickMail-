const express = require('express');
const app = express();

app.use(express.json());

let port = process.env.PORT || 5000;

app.listen(port, () => {
    console.log(`The Server is listening at port: ${port}.`);
});

// Webscraper sends an array of links and I send them to all users

// Client registers with: email and password

// This method checks if the user has ok email/pass

// inserts a user with username, email, password, subjects array, sites array, date, link array
