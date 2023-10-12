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
	tvs_detail_id			INT				NOT NULL PRIMARY KEY IDENTITY(1, 1),
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
    row_created_datetime	DATETIME		NOT NULL DEFAULT GETDATE(),

	CONSTRAINT	fk_tv_series_tvs_id	FOREIGN KEY(tvs_id) REFERENCES tv_series(tvs_id)
)



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



CREATE TABLE user_subscription (
	 sub_id				INT			NOT NULL	PRIMARY KEY IDENTITY(1, 1),
	 user_id			INT			NOT NULL,
	 recurrence			CHAR(1)		NOT NULL,
	 subscribe_date		DATE,
	 next_renewal_date	DATE,
	 is_active			BIT			NOT NULL	DEFAULT(1),
	 row_created_datetime	DATETIME	NOT NULL	DEFAULT GETDATE(),

	 CONSTRAINT fk_subscription_user_id FOREIGN KEY(user_id) REFERENCES users(user_id)
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



CREATE TABLE [dbo].[user_payment_method](
	[payment_method_id] [int] IDENTITY(1,1) NOT NULL,
	[card_number] [varchar](20) NOT NULL,
	[card_expiry_date] [date] NOT NULL,
	[cvv] [int] NOT NULL,
	[user_id] [int] NOT NULL,
	[is_active] [bit] NOT NULL,
	[row_created_datetime] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[payment_method_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[user_payment_method] ADD  DEFAULT ((1)) FOR [is_active]
GO

ALTER TABLE [dbo].[user_payment_method] ADD  DEFAULT (getdate()) FOR [row_created_datetime]
GO

ALTER TABLE [dbo].[user_payment_method]  WITH CHECK ADD  CONSTRAINT [fk1_payment_method_user_id] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([user_id])
GO

ALTER TABLE [dbo].[user_payment_method] CHECK CONSTRAINT [fk1_payment_method_user_id]
GO



CREATE TABLE [dbo].[subscription_plan](
	[plan_id] [int] IDENTITY(1,1) NOT NULL,
	[term] [varchar](100) NOT NULL,
	[duration] [int] NOT NULL,
	[amount] [float] NOT NULL,
	[is_active] [bit] NOT NULL,
	[row_created_datetime] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[plan_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[subscription_plan] ADD  DEFAULT ((1)) FOR [is_active]
GO

ALTER TABLE [dbo].[subscription_plan] ADD  DEFAULT (getdate()) FOR [row_created_datetime]
GO


