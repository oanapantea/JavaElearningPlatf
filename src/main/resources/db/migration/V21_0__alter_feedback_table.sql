ALTER TABLE FEEDBACK
DROP FOREIGN KEY feedback_ibfk_3;

DROP TABLE FEEDBACK_ARCHIVED;

ALTER TABLE FEEDBACK
DROP COLUMN FEEDBACK_ARCHIVED_ID;

ALTER TABLE FEEDBACK
ADD ARCHIVED bool;