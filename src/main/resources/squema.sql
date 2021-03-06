CREATE TABLE MOVIES 
        (ID INTEGER NOT NULL,
         YEAR INTEGER, 
         TITLE VARCHAR(255),  
         WINNER BOOLEAN,
         PRIMARY KEY ( ID ));

CREATE TABLE MOVIES_STUDIOS  
        (ID_MOVIE INTEGER NOT NULL, 
         STUDIO VARCHAR(255) NOT NULL, 
         PRIMARY KEY ( ID_MOVIE, STUDIO ));

CREATE TABLE MOVIES_PRODUCERS 
        (ID_MOVIE INTEGER NOT NULL, 
         PRODUCER VARCHAR(255) NOT NULL,  
         PRIMARY KEY ( ID_MOVIE, PRODUCER ));
