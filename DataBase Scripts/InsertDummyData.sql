-- Inserting values into the 'movie' table
INSERT INTO movie (title, description, year, duration, quality, watch_count, movie_img_url, movie_stream_url, action_category, adventure_category, comedy_category, scify_category, horror_category, romance_category, science_category, crime_category, thriller_category, is_active, created_admin_name)
VALUES
('Inception', 'A mind-bending thriller', 2010, 148, 'HD', 100000, 'image_url1', 'stream_url1', 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 'admin1'),
('Avatar', 'A sci-fi adventure', 2009, 162, 'HD', 95000, 'image_url2', 'stream_url2', 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 'admin2'),
('The Shawshank Redemption', 'Drama and redemption', 1994, 142, 'HD', 105000, 'image_url3', 'stream_url3', 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 'admin1'),
('Jurassic Park', 'Dinosaurs on the loose', 1993, 127, 'HD', 88000, 'image_url4', 'stream_url4', 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 'admin3'),
('The Dark Knight', 'Gotham vigilante', 2008, 152, 'HD', 112000, 'image_url5', 'stream_url5', 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 'admin2'),
('Forrest Gump', 'Life is like a box of chocolates', 1994, 142, 'HD', 98000, 'image_url6', 'stream_url6', 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 'admin1'),
('The Matrix', 'Reality vs. Simulation', 1999, 136, 'HD', 105000, 'image_url7', 'stream_url7', 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 'admin3'),
('The Exorcist', 'Horror in its purest form', 1973, 122, 'HD', 75000, 'image_url8', 'stream_url8', 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 'admin2'),
('Titanic', 'A love story on the high seas', 1997, 195, 'HD', 123000, 'image_url9', 'stream_url9', 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 'admin1'),
('Pulp Fiction', 'A crime masterpiece', 1994, 154, 'HD', 95000, 'image_url10', 'stream_url10', 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 'admin3');

-- Inserting values into the 'tv_series' table
INSERT INTO tv_series (title, tvs_img_url, action_category, adventure_category, comedy_category, scify_category, horror_category, romance_category, science_category, crime_category, thriller_category, is_active)
VALUES
('Stranger Things', 'image_url1', 1, 0, 1, 1, 1, 0, 0, 1, 1, 1),
('Breaking Bad', 'image_url2', 1, 0, 0, 0, 1, 0, 1, 1, 1, 1),
('The Mandalorian', 'image_url3', 1, 1, 0, 1, 0, 0, 0, 0, 1, 1),
('Friends', 'image_url4', 0, 0, 1, 0, 0, 1, 0, 0, 0, 1),
('The Office', 'image_url5', 0, 0, 1, 0, 0, 1, 0, 0, 0, 1),
('Black Mirror', 'image_url6', 0, 0, 0, 1, 1, 0, 0, 0, 1, 1),
('The Witcher', 'image_url7', 1, 1, 0, 1, 1, 0, 0, 1, 1, 1),
('The Simpsons', 'image_url8', 0, 0, 1, 0, 0, 1, 0, 0, 0, 1),
('Westworld', 'image_url9', 1, 1, 0, 1, 0, 0, 0, 1, 1, 1),
('Sherlock', 'image_url10', 1, 0, 0, 1, 0, 1, 0, 1, 0, 1);

-- Inserting values into the 'tv_series_details' table
INSERT INTO tv_series_details (tvs_id, season, episode, description, year, duration, quality, watch_count, tvs_stream_url, created_admin_name)
VALUES
(1, 1, 1, 'The Vanishing of Will Byers', 2016, 50, 'HD', 50000, 'stream_url1', 'admin1'),
(2, 1, 1, 'Pilot', 2008, 60, 'HD', 45000, 'stream_url2', 'admin2'),
(3, 1, 1, 'Chapter 1: The Mandalorian', 2019, 40, 'HD', 60000, 'stream_url3', 'admin3'),
(4, 1, 1, 'The One Where Monica Gets a Roommate', 1994, 22, 'HD', 70000, 'stream_url4', 'admin1'),
(5, 1, 1, 'Pilot', 2005, 23, 'HD', 55000, 'stream_url5', 'admin2'),
(6, 1, 1, 'The National Anthem', 2011, 60, 'HD', 48000, 'stream_url6', 'admin3'),
(7, 1, 1, 'The End’s Beginning', 2011, 60, 'HD', 48000, 'stream_url7', 'admin3'),
(8, 1, 1, 'Simpsons Roasting on an Open Fire', 1989, 22, 'HD', 48000, 'stream_url8', 'admin2'),
(9, 1, 1, 'The Original', 2016, 60, 'HD', 60000, 'stream_url9', 'admin3'),
(10, 1, 1, 'A Study in Pink', 2010, 88, 'HD', 55000, 'stream_url10', 'admin1');

-- Inserting values into the 'users' table
INSERT INTO users (name, email, mobile_no, dob, premium_user, password, created_admin_name)
VALUES
('John Doe', 'john.doe@example.com', '1234567890', '1990-01-01', 1, 'hashed_password', 'admin1'),
('Jane Smith', 'jane.smith@example.com', '9876543210', '1985-05-15', 0, 'hashed_password', 'admin2'),
('Bob Johnson', 'bob.johnson@example.com', '4567890123', '1995-08-20', 1, 'hashed_password', 'admin3'),
('Alice Williams', 'alice.williams@example.com', '7890123456', '1988-12-10', 1, 'hashed_password', 'admin1'),
('Charlie Brown', 'charlie.brown@example.com', '3456789012', '1993-07-05', 0, 'hashed_password', 'admin2'),
('Eva Green', 'eva.green@example.com', '5678901234', '1980-09-18', 1, 'hashed_password', 'admin3'),
('David Clark', 'david.clark@example.com', '2345678901', '1992-03-25', 0, 'hashed_password', 'admin1'),
('Grace Taylor', 'grace.taylor@example.com', '8901234567', '1987-11-30', 1, 'hashed_password', 'admin2'),
('Henry Miller', 'henry.miller@example.com', '6789012345', '1998-04-12', 0, 'hashed_password', 'admin3'),
('Sophie Turner', 'sophie.turner@example.com', '0123456789', '1996-06-22', 1, 'hashed_password', 'admin1');

-- Inserting values into the 'user_rating' table
INSERT INTO user_rating (user_id, type, tvs_id, movie_Id, rating)
VALUES
(1, 'T', 1, NULL, 5),
(2, 'M', NULL, 2, 4),
(3, 'T', 2, NULL, 5),
(4, 'M', NULL, 3, 3),
(5, 'T', 4, NULL, 4),
(6, 'M', NULL, 2, 5),
(7, 'T', 5, NULL, 3),
(8, 'M', NULL, 4, 4),
(9, 'T', 6, NULL, 4),
(10, 'M', NULL, 5, 5);

-- Inserting values into the 'user_favourite' table
INSERT INTO user_favourite (user_id, type, tvs_id, movie_Id)
VALUES
(1, 'M', NULL, 1),
(2, 'T', 2, NULL),
(3, 'M', NULL, 3),
(4, 'T', 4, NULL),
(5, 'M', NULL, 5),
(6, 'T', 6, NULL),
(7, 'M', NULL, 7),
(8, 'T', 8, NULL),
(9, 'M', NULL, 9),
(10, 'T', 10, NULL);

-- Inserting values into the 'user_watch_history' table
INSERT INTO user_watch_history (user_id, type, tvs_id, movie_Id)
VALUES
(1, 'M', 1, NULL),
(2, 'T', NULL, 1),
(3, 'M', 2, NULL),
(4, 'T', NULL, 3),
(5, 'M', 4, NULL),
(6, 'T', NULL, 2),
(7, 'M', 5, NULL),
(8, 'T', NULL, 4),
(9, 'M', 6, NULL),
(10, 'T', NULL, 5);

-- Inserting values into the 'user_subscription' table
INSERT INTO user_subscription (user_id, plan_id, subscribe_date, next_renewal_date)
VALUES
    (1, 1, '2023-10-26', '2023-11-26'),
    (2, 2, '2023-10-25', '2023-11-25'),
    (3, 3, '2023-10-24', '2023-11-24'),
    (4, 4, '2023-10-23', '2023-11-23'),
    (5, 5, '2023-10-22', '2023-11-22'),
    (6, 6, '2023-10-21', '2023-11-21'),
    (7, 7, '2023-10-20', '2023-11-20'),
    (8, 8, '2023-10-19', '2023-11-19'),
    (9, 9, '2023-10-18', '2023-11-18'),
    (10, 10, '2023-10-17', '2023-11-17');


-- Inserting values into the 'payment' table
INSERT INTO payment (user_id, sub_id, amount)
VALUES
(1, 1, 9.99),
(2, 2, 7.99),
(3, 3, 11.99),
(4, 4, 8.99),
(5, 5, 12.99),
(6, 6, 9.99),
(7, 7, 14.99),
(8, 8, 10.99),
(9, 9, 13.99),
(10, 10, 15.99);

--Insert values into the 'subscription_plan' table
INSERT INTO subscription_plan (description, duration_in_months, amount)
VALUES
    ('Basic Plan', 1, 9.99),
    ('Standard Plan', 3, 29.99),
    ('Premium Plan', 6, 49.99),
    ('Family Plan', 6, 59.99),
    ('Ultimate Plan', 12, 99.99);
