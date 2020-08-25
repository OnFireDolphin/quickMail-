const express = require('express');
const app = express();

app.use(express.json());

let port = process.env.PORT || 5000;

app.listen(port, () => {
    console.log(`The Server is listening at port: ${port}.`);
});
