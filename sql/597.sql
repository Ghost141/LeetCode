CREATE TABLE IF NOT EXISTS friend_request (
  sender_id    INT  NOT NULL,
  send_to_id   INT  NULL,
  request_date DATE NULL
);
CREATE TABLE IF NOT EXISTS request_accepted (
  requester_id INT  NOT NULL,
  accepter_id  INT  NULL,
  accept_date  DATE NULL
);
TRUNCATE TABLE friend_request;
INSERT INTO friend_request (sender_id, send_to_id, request_date) VALUES ('1', '2', '2016/06/01');
INSERT INTO friend_request (sender_id, send_to_id, request_date) VALUES ('1', '3', '2016/06/01');
INSERT INTO friend_request (sender_id, send_to_id, request_date) VALUES ('1', '4', '2016/06/01');
INSERT INTO friend_request (sender_id, send_to_id, request_date) VALUES ('2', '3', '2016/06/02');
INSERT INTO friend_request (sender_id, send_to_id, request_date) VALUES ('3', '4', '2016/06/09');
TRUNCATE TABLE request_accepted;
INSERT INTO request_accepted (requester_id, accepter_id, accept_date) VALUES ('1', '2', '2016/06/03');
INSERT INTO request_accepted (requester_id, accepter_id, accept_date) VALUES ('1', '3', '2016/06/08');
INSERT INTO request_accepted (requester_id, accepter_id, accept_date) VALUES ('2', '3', '2016/06/08');
INSERT INTO request_accepted (requester_id, accepter_id, accept_date) VALUES ('3', '4', '2016/06/09');
INSERT INTO request_accepted (requester_id, accepter_id, accept_date) VALUES ('3', '4', '2016/06/10');


SELECT ROUND(IFNULL((
                      SELECT COUNT(DISTINCT acc.requester_id, acc.accepter_id) AS acc_count
                      FROM request_accepted acc
                    ), 0) / (SELECT COUNT(DISTINCT req.sender_id, req.send_to_id) AS req_count
                             FROM friend_request req), 2) AS accept_rate