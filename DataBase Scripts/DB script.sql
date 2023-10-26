CREATE DATABASE OnlineWatchingMoviesandTVSeriesTest;
GO
USE OnlineWatchingMoviesandTVSeriesTest;
GO

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
GO


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
GO


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
GO
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
GO


CREATE TABLE user_rating (
	rate_id					INT				NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	user_id					INT				NOT NULL,
	type					CHAR(1)			NOT NULL,
	tvs_id					INT				NULL,
	movie_Id				INT				NULL,
	rating					INT				NULL,
	row_created_datetime	DATETIME		NOT NULL	DEFAULT GETDATE(),

); 

GO

CREATE TABLE user_favourite (
	fav_id					INT			NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	user_id					INT			NOT NULL,
	type					CHAR(1)		NOT NULL,
	tvs_id					INT			NULL,
	movie_Id				INT			NULL,
	row_created_datetime	DATETIME	NOT NULL	DEFAULT GETDATE(),

);
GO
CREATE TABLE user_watch_list (
	watch_list_id			INT			NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	user_id					INT			NOT NULL,
	type					CHAR(1)		NOT NULL,
	tvs_id					INT			NULL,
	movie_Id				INT			NULL,
	row_created_datetime	DATETIME	NOT NULL	DEFAULT GETDATE(),

); 
GO

CREATE TABLE user_watch_history (
	watch_id				INT			NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	user_id					INT			NOT NULL,
	type					CHAR(1)		NOT NULL,
	tvs_id					INT			NULL,
	movie_Id				INT			NULL,
	row_created_datetime	DATETIME	NOT NULL	DEFAULT GETDATE(),

);
GO

CREATE TABLE subscription_plan(
	plan_id					INT				NOT NULL	PRIMARY KEY IDENTITY(1,1) ,
	description				VARCHAR(100)	NOT NULL,
	duration_in_months		INT				NOT NULL,
	amount					FLOAT			NOT NULL,
	is_active				BIT				NOT NULL	DEFAULT(1),
	row_created_datetime	DATETIME		NOT NULL	DEFAULT GETDATE()
);
GO

CREATE TABLE user_subscription (
	 sub_id				INT			NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	 user_id			INT			NOT NULL,
	 plan_id			INT			NOT NULL,
	 subscribe_date		DATE		NOT NULL	DEFAULT GETDATE(),
	 next_renewal_date	DATE,
	 is_active			BIT			NOT NULL	DEFAULT(1),
	 row_created_datetime	DATETIME	NOT NULL	DEFAULT GETDATE(),


);
GO

CREATE TABLE payment (
	 payment_id				INT			NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	 user_id				INT			NOT NULL,
	 sub_id					INT			NOT NULL,
	 amount					FLOAT		NOT NULL,
	 row_created_datetime	DATETIME	NOT NULL	DEFAULT GETDATE(),

);
GO


CREATE TABLE user_payment_method(
	payment_method_id		INT			NOT NULL	PRIMARY KEY	IDENTITY(1,1),
	card_number				VARCHAR(20) NOT NULL,
	card_expiry_date		DATE		NOT NULL,
	cvv						INT			NOT NULL,
	user_id					INT			NOT NULL,
	is_active				BIT			NOT NULL	DEFAULT(1),
	row_created_datetime	DATETIME	NOT NULL	DEFAULT GETDATE()

);

--RUN TRIGGER AFTER CREATE TABLES
-- Create a trigger to update next_renewal_date in user_subscription table
-- when a new record is inserted.

CREATE TRIGGER UpdateNextRenewalDate
ON user_subscription
AFTER INSERT
AS
BEGIN
    -- Update the next_renewal_date using the duration_in_months from subscription_plan.
    UPDATE us
    SET us.next_renewal_date = DATEADD(MONTH, sp.duration_in_months, i.subscribe_date)
    FROM user_subscription AS us
    INNER JOIN inserted AS i ON us.sub_id = i.sub_id
    INNER JOIN subscription_plan AS sp ON us.plan_id = sp.plan_id;
END;

