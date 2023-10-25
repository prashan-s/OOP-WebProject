CREATE DATABASE OnlineWatchingMoviesandTVSeries;
GO
USE OnlineWatchingMoviesandTVSeries;
CREATE TABLE movie (
	movie_id				INT				NOT NULL PRIMARY KEY IDENTITY(1, 1),
	title					VARCHAR(100)	NOT NULL,
	description				VARCHAR(1000)	NULL,
	year					INT				NOT NULL,
	duration				INT				NULL,
	quality					CHAR(2)			NOT NULL,
	watch_count				INT				NULL,
	movie_img_url			VARCHAR(1000)	NOT NULL,
	movie_stream_url		VARCHAR(1000)	NOT NULL,
	action_category			BIT				NOT NULL DEFAULT(0),
	adventure_category		BIT				NOT NULL DEFAULT(0),
	comedy_category			BIT				NOT NULL DEFAULT(0),
	scify_category			BIT				NOT NULL DEFAULT(0),
	horror_category			BIT				NOT NULL DEFAULT(0),
	romance_category		BIT				NOT NULL DEFAULT(0),
	science_category		BIT				NOT NULL DEFAULT(0),
	crime_category			BIT				NOT NULL DEFAULT(0),
	thriller_category		BIT				NOT NULL DEFAULT(0),
	is_active				BIT				NOT NULL DEFAULT(1),
	created_admin_name		VARCHAR(200)	NOT NULL,
	row_created_datetime	DATETIME		NOT NULL DEFAULT GETDATE()
);



CREATE TABLE tv_series (
	tvs_id					INT				NOT NULL PRIMARY KEY IDENTITY(1, 1),
	title					VARCHAR(100)	NOT NULL,
	tvs_img_url				VARCHAR(1000)	NOT NULL,
	action_category			BIT				NOT NULL DEFAULT(0),
	adventure_category		BIT				NOT NULL DEFAULT(0),
	comedy_category			BIT				NOT NULL DEFAULT(0),
	scify_category			BIT				NOT NULL DEFAULT(0),
	horror_category			BIT				NOT NULL DEFAULT(0),
	romance_category		BIT				NOT NULL DEFAULT(0),
	science_category		BIT				NOT NULL DEFAULT(0),
	crime_category			BIT				NOT NULL DEFAULT(0),
	thriller_category		BIT				NOT NULL DEFAULT(0),
	is_active				BIT				NOT NULL DEFAULT(1),
    row_created_datetime	DATETIME		NOT NULL DEFAULT GETDATE()
);



CREATE TABLE tv_series_details (
	tvs_detail_id			INT				NOT NULL PRIMARY KEY IDENTITY(1,1),
	tvs_id					INT				NOT NULL,
	season					INT				NOT NULL,
    episode					INT				NOT NULL,
    description				VARCHAR(1000)	NULL,
    year					INT				NOT NULL,
    duration				INT				NOT NULL,
    quality					CHAR(2)			NOT NULL,
	watch_count				INT				NULL,
	tvs_stream_url			VARCHAR(1000)	NOT NULL,
	created_admin_name		VARCHAR(200)	NOT NULL,
	is_active				BIT				NOT NULL DEFAULT(1),
    row_created_datetime	DATETIME		NOT NULL DEFAULT GETDATE()
);

CREATE TABLE users (
	user_id					INT					NOT NULL PRIMARY KEY IDENTITY(1, 1),
	name					VARCHAR(200)		NOT NULL,
	email					VARCHAR(200)		NOT NULL, 
	mobile_no				CHAR(10)			NOT NULL,
	dob						DATE				NULL,
	premium_user			BIT					NOT NULL DEFAULT(0),
	password				VARCHAR(200)		NOT NULL,
	created_admin_name		VARCHAR(200)		NULL,
	is_active				BIT					NOT NULL DEFAULT(1),
    row_created_datetime	DATETIME			NOT NULL DEFAULT GETDATE()
);



CREATE TABLE user_rating (
	rate_id					INT				NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	user_id					INT				NOT NULL,
	type					CHAR(1)			NOT NULL,
	tvs_id					INT				NULL,
	movie_Id				INT				NULL,
	rating					INT				NULL,
	row_created_datetime	DATETIME		NOT NULL	DEFAULT GETDATE(),

	CONSTRAINT fk1_user_rating_user_id FOREIGN KEY(user_id) REFERENCES users(user_id),
	CONSTRAINT fk2_user_rating_tvs_id FOREIGN KEY(tvs_id) REFERENCES tv_series(tvs_id),
	CONSTRAINT fk3_user_rating_movie_Id FOREIGN KEY(movie_Id) REFERENCES movie(movie_id)
); 



CREATE TABLE user_favourite (
	fav_id					INT			NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	user_id					INT			NOT NULL,
	type					CHAR(1)		NOT NULL,
	tvs_id					INT			NULL,
	movie_Id				INT			NULL,
	row_created_datetime	DATETIME	NOT NULL	DEFAULT GETDATE(),

	CONSTRAINT fk1_user_favourite_user_id FOREIGN KEY(user_id) REFERENCES users(user_id),
	CONSTRAINT fk2_user_favourite_tvs_id FOREIGN KEY(tvs_id) REFERENCES tv_series(tvs_id),
	CONSTRAINT fk3_user_favourite_movie_Id FOREIGN KEY(movie_Id) REFERENCES movie(movie_id)
);

CREATE TABLE user_watch_list (
	watch_list_id			INT			NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	user_id					INT			NOT NULL,
	type					CHAR(1)		NOT NULL,
	tvs_id					INT			NULL,
	movie_Id				INT			NULL,
	row_created_datetime	DATETIME	NOT NULL	DEFAULT GETDATE(),

	CONSTRAINT fk1_user_watch_list_user_id FOREIGN KEY(user_id) REFERENCES users(user_id),
	CONSTRAINT fk2_user_watch_list_tvs_id FOREIGN KEY(tvs_id) REFERENCES tv_series(tvs_id),
	CONSTRAINT fk3_user_watch_list_movie_Id FOREIGN KEY(movie_Id) REFERENCES movie(movie_id)
); 


CREATE TABLE user_watch_history (
	watch_id				INT			NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	user_id					INT			NOT NULL,
	type					CHAR(1)		NOT NULL,
	tvs_id					INT			NULL,
	movie_Id				INT			NULL,
	row_created_datetime	DATETIME	NOT NULL	DEFAULT GETDATE(),

	CONSTRAINT fk1_user_watch_history_user_id FOREIGN KEY(user_id) REFERENCES users(user_id),
	CONSTRAINT fk2_user_watch_history_tvs_id FOREIGN KEY(tvs_id) REFERENCES tv_series(tvs_id),
	CONSTRAINT fk3_user_watch_history_movie_Id FOREIGN KEY(movie_Id) REFERENCES movie(movie_id)
);


CREATE TABLE subscription_plan(
	plan_id					INT				NOT NULL	PRIMARY KEY IDENTITY(1,1) ,
	description				VARCHAR(100)	NOT NULL,
	duration_in_months		INT				NOT NULL,
	amount					FLOAT			NOT NULL,
	is_active				BIT				NOT NULL	DEFAULT(1),
	row_created_datetime	DATETIME		NOT NULL	DEFAULT GETDATE()
);

CREATE TABLE user_subscription (
	 sub_id				INT			NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	 user_id			INT			NOT NULL,
	 plan_id			INT			NOT NULL,
	 subscribe_date		DATE,
	 next_renewal_date	DATE,
	 is_active			BIT			NOT NULL	DEFAULT(1),
	 row_created_datetime	DATETIME	NOT NULL	DEFAULT GETDATE(),

	 CONSTRAINT fk1_subscription_user_id FOREIGN KEY(user_id) REFERENCES users(user_id),
	 CONSTRAINT fk2_subscription_user_id FOREIGN KEY(plan_id) REFERENCES subscription_plan(plan_id),

);



CREATE TABLE payment (
	 payment_id				INT			NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	 user_id				INT			NOT NULL,
	 sub_id					INT			NOT NULL,
	 amount					FLOAT		NOT NULL,
	 row_created_datetime	DATETIME	NOT NULL	DEFAULT GETDATE(),

	 CONSTRAINT fk1_payment_user_id FOREIGN KEY(user_id) REFERENCES users(user_id),
	 CONSTRAINT fk2_payment_sub_id FOREIGN KEY(sub_Id) REFERENCES user_subscription(sub_id)
);



CREATE TABLE user_payment_method(
	payment_method_id		INT			NOT NULL	PRIMARY KEY	IDENTITY(1,1),
	card_number				VARCHAR(20) NOT NULL,
	card_expiry_date		DATE		NOT NULL,
	cvv						INT			NOT NULL,
	user_id					INT			NOT NULL,
	is_active				BIT			NOT NULL	DEFAULT(1),
	row_created_datetime	DATETIME	NOT NULL	DEFAULT GETDATE(),

CONSTRAINT fk_payment_method_user_id FOREIGN KEY(user_id) REFERENCES users (user_id)
);



ALTER TABLE tv_series_details
DROP CONSTRAINT fk_tv_series_tvs_id;

ALTER TABLE tv_series
ADD CONSTRAINT fk_tv_series_tvs_id
FOREIGN KEY (tvs_id) REFERENCES tv_series_details(tvs_id)
ON DELETE CASCADE ON UPDATE CASCADE