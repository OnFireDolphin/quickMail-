const express = require('express');
const app = express();
const mongoose = require('mongoose');

app.use(express.json());

let port = process.env.PORT || 5000;

app.listen(port, () => {
    console.log(`The Server is listening at port: ${port}.`);
});

app.get('/test', (req, res) => {
    res.send('Alex is Awesome !!');
});

// Webscraper sends an array of links and I send them to all users

// Client registers with: email and password
// inserts a user with username, email, password, subjects array, sites array, date, link array

app.post('/createUser', (req, res) => {
    try {
    } catch {}
});

// This method checks if the user has ok email/pass
