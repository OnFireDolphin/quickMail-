const mongoose = require('mongoose');

// inserts a user with username, email, password, subjects array, sites array, date, link array
const UserSchema = new mongoose.Schema({
    email: {
        type: String,
        required: true,
    },
    username: {
        type: String,
        required: true,
    },
    password: {
        type: String,
        required: true,
    },
    subjects: {
        type: [],
        required: true,
        default: [],
    },
    sites: {
        type: [],
        required: true,
        default: [],
    },
    links: {
        type: [],
        required: true,
        default: [],
    },
    date: {
        type: Number,
        required: false,
    },
});
