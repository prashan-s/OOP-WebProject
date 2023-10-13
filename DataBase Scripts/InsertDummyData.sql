INSERT INTO movie (title, description, year, duration, quality, watch_count, movie_img_url, movie_stream_url, action_category, adventure_category, comedy_category, scify_category, horror_category, romance_category, science_category, crime_category, thriller_category, created_admin_name)
VALUES
    ('Movie 1', 'Description 1', 2020, 120, 'HD', 1000, 'image1.jpg', 'stream1.mp4', 1, 0, 1, 0, 1, 0, 0, 0, 1, 'Admin1'),
    ('Movie 2', 'Description 2', 2019, 110, 'HD', 800, 'image2.jpg', 'stream2.mp4', 1, 1, 0, 0, 0, 1, 0, 1, 0, 'Admin2'),
    ('Movie 3', 'Description 3', 2018, 105, 'SD', 1200, 'image3.jpg', 'stream3.mp4', 0, 0, 1, 1, 0, 0, 0, 0, 1, 'Admin3'),
    ('Movie 4', 'Description 4', 2017, 95, 'HD', 900, 'image4.jpg', 'stream4.mp4', 1, 0, 0, 0, 1, 0, 1, 0, 0, 'Admin4'),
    ('Movie 5', 'Description 5', 2016, 130, 'HD', 700, 'image5.jpg', 'stream5.mp4', 0, 1, 0, 1, 0, 0, 0, 0, 1, 'Admin5');
INSERT INTO tv_series (title, tvs_img_url, action_category, adventure_category, comedy_category, scify_category, horror_category, romance_category, science_category, crime_category, thriller_category)
VALUES
    ('TV Series 1', 'image1.jpg', 1, 0, 1, 0, 1, 0, 0, 0, 1),
    ('TV Series 2', 'image2.jpg', 1, 1, 0, 0, 0, 1, 0, 1, 0),
    ('TV Series 3', 'image3.jpg', 0, 0, 1, 1, 0, 0, 0, 0, 1),
    ('TV Series 4', 'image4.jpg', 1, 0, 0, 0, 1, 0, 1, 0, 0),
    ('TV Series 5', 'image5.jpg', 0, 1, 0, 1, 0, 0, 0, 1, 0);
INSERT INTO tv_series_details (tvs_id, season, episode, description, year, duration, quality, watch_count, tvs_stream_url, created_admin_name)
VALUES
    (1, 1, 1, 'Episode 1', 2020, 45, 'HD', 500, 'stream1_1_1.mp4', 'Admin1'),
    (1, 1, 2, 'Episode 2', 2020, 45, 'HD', 480, 'stream1_1_2.mp4', 'Admin1'),
    (2, 1, 1, 'Episode 1', 2019, 50, 'HD', 520, 'stream2_1_1.mp4', 'Admin2'),
    (2, 1, 2, 'Episode 2', 2019, 50, 'HD', 510, 'stream2_1_2.mp4', 'Admin2'),
    (3, 1, 1, 'Episode 1', 2018, 40, 'SD', 550, 'stream3_1_1.mp4', 'Admin3');
INSERT INTO users (name, email, mobile_no, dob, premium_user, password, created_admin_name)
VALUES
    ('User 1', 'user1@example.com', '1234567890', '1990-01-15', 1, 'password1', 'Admin1'),
    ('User 2', 'user2@example.com', '9876543210', '1985-05-20', 0, 'password2', 'Admin2'),
    ('User 3', 'user3@example.com', '5551112222', '1995-08-10', 1, 'password3', 'Admin3'),
    ('User 4', 'user4@example.com', '7778889999', '1988-12-05', 0, 'password4', 'Admin4'),
    ('User 5', 'user5@example.com', '9990001111', '1992-04-30', 1, 'password5', 'Admin5');
INSERT INTO user_rating (user_id, type, tvs_id, movie_Id, rating)
VALUES
    (1, 'T', 1, NULL, 4),
    (2, 'M', NULL, 3, 5),
    (3, 'T', 2, NULL, 4),
    (4, 'M', NULL, 1, 3),
    (5, 'T', 4, NULL, 5);
INSERT INTO user_favourite (user_id, type, tvs_id, movie_Id)
VALUES
    (1, 'T', 2, NULL),
    (2, 'M', NULL, 4),
    (3, 'T', 5, NULL),
    (4, 'M', NULL, 2),
    (5, 'T', 1, NULL);
INSERT INTO user_watch_list (user_id, type, tvs_id, movie_Id)
VALUES
    (1, 'M', NULL, 5),
    (2, 'T', 3, NULL),
    (3, 'M', NULL, 4),
    (4, 'T', 1, NULL),
    (5, 'M', NULL, 2);
INSERT INTO user_watch_history (user_id, type, tvs_id, movie_Id)
VALUES
    (1, 'M', NULL, 3),
    (2, 'T', 2, NULL),
    (3, 'M', NULL, 5),
    (4, 'T', 4, NULL),
    (5, 'M', NULL, 1);
INSERT INTO subscription_plan (description, duration_in_months, amount)
VALUES
    ('Basic Plan', 1, 9.99),
    ('Standard Plan', 3, 29.99),
    ('Premium Plan', 6, 49.99),
    ('Family Plan', 6, 59.99),
    ('Ultimate Plan', 12, 99.99);
INSERT INTO user_subscription (user_id, plan_id, subscribe_date, next_renewal_date)
VALUES
    (1, 1, '2023-01-15', '2023-02-15'),
    (2, 2, '2023-03-20', '2023-06-20'),
    (3, 3, '2023-04-10', '2023-10-10'),
    (4, 4, '2023-02-05', '2023-08-05'),
    (5, 5, '2023-06-30', '2024-06-30');
INSERT INTO payment (user_id, sub_id, amount)
VALUES
    (1, 1, 9.99),
    (2, 2, 29.99),
    (3, 3, 49.99),
    (4, 4, 59.99),
    (5, 5, 99.99);
INSERT INTO user_payment_method (card_number, card_expiry_date, cvv, user_id)
VALUES
    ('1234567890123456', '2025-12-31', 123, 1),
    ('9876543210987654', '2024-11-30', 456, 2),
    ('5555555555555555', '2026-08-31', 789, 3),
    ('4444333322221111', '2027-07-31', 567, 4),
    ('9999888877776666', '2025-05-31', 234, 5);
select * from user_payment_method