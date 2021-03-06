CREATE TABLE IF NOT EXISTS FEEDBACK_ARCHIVED (

    ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    FEEDBACK_ID BIGINT NOT NULL

);

CREATE TABLE IF NOT EXISTS FEEDBACK
(
    ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    LESSON_ID BIGINT NOT NULL,
    USER_ID BIGINT NOT NULL,
    FEEDBACK_ARCHIVED_ID BIGINT,
    TITLE VARCHAR(100),
    DESCRIPTION VARCHAR(255),
    FOREIGN KEY (USER_ID) REFERENCES USER (ID),
    FOREIGN KEY (LESSON_ID) REFERENCES LESSON (ID),
    FOREIGN KEY (FEEDBACK_ARCHIVED_ID) REFERENCES FEEDBACK_ARCHIVED (ID)
);
