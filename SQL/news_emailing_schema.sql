DROP SCHEMA IF EXISTS news_emailing CASCADE;
CREATE SCHEMA news_emailing;
SET search_path = news_emailing;

CREATE TABLE IF NOT EXISTS Users(
    email VARCHAR(255),
    userName VARCHAR(255) NOT NULL,
    userPassword VARCHAR(255) NOT NULL,
    PRIMARY KEY(email)
);

CREATE TABLE IF NOT EXISTS UserSitesPreferences(
    id SERIAL ,
    email VARCHAR(255),
    newsSite VARCHAR(255),
    PRIMARY KEY(id),
    FOREIGN KEY(email) REFERENCES Users ON DELETE CASCADE
);
CREATE INDEX idx_email_site ON UserSitesPreferences(email);


CREATE TABLE IF NOT EXISTS UserSubjectPreferences(
    id SERIAL,
    email VARCHAR(255),
    newsSubject VARCHAR(255),
    PRIMARY KEY(id),
    FOREIGN KEY(email) REFERENCES Users ON DELETE CASCADE
);
CREATE INDEX idx_email_subject ON UserSubjectPreferences(email);

CREATE TABLE IF NOT EXISTS SubjectLinks(
    link VARCHAR(1000),
    newsSubject VARCHAR(255),
    newsSite VARCHAR(255),
    newsDate DATE,
    PRIMARY KEY(link)
);
CREATE INDEX idx_link ON SubjectLinks(link);