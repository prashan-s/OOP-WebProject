CREATE DATABASE OnlineWatchingMoviesandTVSeries;
GO
USE OnlineWatchingMoviesandTVSeries;
GO

CREATE TABLE movie (
	movie_id				INT				NOT NULL PRIMARY KEY IDENTITY(1, 1),
	title					VARCHAR(100)	NULL,
	description				VARCHAR(1000)	NULL,
	year					INT				NULL,
	duration				INT				NULL,
	quality					CHAR(2)			NULL,
	watch_count				INT				NULL,
	movie_img_url			VARCHAR(1000)	NULL,
	movie_stream_url		VARCHAR(1000)	NULL,
	action_category			BIT				NULL DEFAULT(0),
	adventure_category		BIT				NULL DEFAULT(0),
	comedy_category			BIT				NULL DEFAULT(0),
	scify_category			BIT				NULL DEFAULT(0),
	horror_category			BIT				NULL DEFAULT(0),
	romance_category		BIT				NULL DEFAULT(0),
	science_category		BIT				NULL DEFAULT(0),
	crime_category			BIT				NULL DEFAULT(0),
	thriller_category		BIT				NULL DEFAULT(0),
	is_active				BIT				NULL DEFAULT(1),
	created_admin_name		VARCHAR(200)	NULL,
	row_created_datetime	DATETIME		NULL DEFAULT GETDATE()
);
GO


CREATE TABLE tv_series (
	tvs_id					INT				NOT NULL PRIMARY KEY IDENTITY(1, 1),
	title					VARCHAR(100)	NULL,
	tvs_img_url				VARCHAR(1000)	NULL,
	action_category			BIT				NULL DEFAULT(0),
	adventure_category		BIT				NULL DEFAULT(0),
	comedy_category			BIT				NULL DEFAULT(0),
	scify_category			BIT				NULL DEFAULT(0),
	horror_category			BIT				NULL DEFAULT(0),
	romance_category		BIT				NULL DEFAULT(0),
	science_category		BIT				NULL DEFAULT(0),
	crime_category			BIT				NULL DEFAULT(0),
	thriller_category		BIT				NULL DEFAULT(0),
	is_active				BIT				NULL DEFAULT(1),
    row_created_datetime	DATETIME		NULL DEFAULT GETDATE()
);
GO


CREATE TABLE tv_series_details (
	tvs_detail_id			INT				NOT NULL PRIMARY KEY IDENTITY(1,1),
	tvs_id					INT				NULL,
	season					INT				NULL,
    episode					INT				NULL,
    description				VARCHAR(1000)	NULL,
    year					INT				NULL,
    duration				INT				NULL,
    quality					CHAR(2)			NULL,
	watch_count				INT				NULL,
	tvs_stream_url			VARCHAR(1000)	NULL,
	created_admin_name		VARCHAR(200)	NULL,
	is_active				BIT				NULL DEFAULT(1),
    row_created_datetime	DATETIME		NULL DEFAULT GETDATE()
);
GO
CREATE TABLE users (
	user_id					INT					NOT NULL PRIMARY KEY IDENTITY(1, 1),
	name					VARCHAR(200)		NULL,
	email					VARCHAR(200)		NULL, 
	mobile_no				CHAR(10)			NULL,
	dob						DATE				NULL,
	premium_user			BIT					NULL DEFAULT(0),
	password				VARCHAR(200)		NULL,
	created_admin_name		VARCHAR(200)		NULL,
	is_active				BIT					NULL DEFAULT(1),
    row_created_datetime	DATETIME			NULL DEFAULT GETDATE()
);
GO


CREATE TABLE user_rating (
	rate_id					INT				NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	user_id					INT				NULL,
	type					CHAR(1)			NULL,
	tvs_id					INT				NULL,
	movie_Id				INT				NULL,
	rating					INT				NULL,
	row_created_datetime	DATETIME		NULL	DEFAULT GETDATE(),

); 

GO

CREATE TABLE user_favourite (
	fav_id					INT			NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	user_id					INT			NULL,
	type					CHAR(1)		NULL,
	tvs_id					INT			NULL,
	movie_Id				INT			NULL,
	row_created_datetime	DATETIME	NULL	DEFAULT GETDATE(),

);
GO
CREATE TABLE user_watch_list (
	watch_list_id			INT			NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	user_id					INT			NULL,
	type					CHAR(1)		NULL,
	tvs_id					INT			NULL,
	movie_Id				INT			NULL,
	row_created_datetime	DATETIME	NULL	DEFAULT GETDATE(),

); 
GO

CREATE TABLE user_watch_history (
	watch_id				INT			NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	user_id					INT			NULL,
	type					CHAR(1)		NULL,
	tvs_id					INT			NULL,
	movie_Id				INT			NULL,
	row_created_datetime	DATETIME	NULL	DEFAULT GETDATE(),

);
GO

CREATE TABLE subscription_plan(
	plan_id					INT				NOT NULL	PRIMARY KEY IDENTITY(1,1) ,
	description				VARCHAR(100)	NULL,
	duration_in_months		INT				NULL,
	amount					FLOAT			NULL,
	is_active				BIT				NULL	DEFAULT(1),
	row_created_datetime	DATETIME		NULL	DEFAULT GETDATE()
);
GO

CREATE TABLE user_subscription (
	 sub_id				INT			NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	 user_id			INT			NULL,
	 plan_id			INT			NULL,
	 subscribe_date		DATE		NULL	DEFAULT GETDATE(),
	 next_renewal_date	DATE		NULL,
	 is_active			BIT			NULL	DEFAULT(1),
	 row_created_datetime	DATETIME	NULL	DEFAULT GETDATE(),


);
GO

CREATE TABLE payment (
	 payment_id				INT			NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	 user_id				INT			NULL,
	 sub_id					INT			NULL,
	 amount					FLOAT		NULL,
	 row_created_datetime	DATETIME	NULL	DEFAULT GETDATE(),

);
GO


CREATE TABLE user_payment_method(
	payment_method_id		INT			NOT NULL	PRIMARY KEY	IDENTITY(1,1),
	card_number				VARCHAR(20) NULL,
	card_expiry_date		DATE		NULL,
	cvv						INT			NULL,
	user_id					INT			NULL,
	is_active				BIT			NULL	DEFAULT(1),
	row_created_datetime	DATETIME	NULL	DEFAULT GETDATE()

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

