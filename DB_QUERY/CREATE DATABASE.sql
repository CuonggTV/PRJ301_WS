CREATE DATABASE PRJ301_WS
GO

USE PRJ301_WS
GO

CREATE TABLE [Customer] (
  [id] int IDENTITY(1, 1),
  [username] varchar(50),
  [password] varchar(50),
  [name] nvarchar(50),
  [email] varchar(50),
  [dob] date,
  [phoneNumber] char(10),
  [isBlocked] bit,
  PRIMARY KEY ([id])
);

CREATE TABLE [Species] (
  [id] int IDENTITY(1, 1),
  [name] nvarchar(50),
  PRIMARY KEY ([id])
);

CREATE TABLE [Sevice] (
  [id] int IDENTITY(1, 1),
  [speciesId] int,
  [name] nvarchar(100),
  [details] nvarchar(1000),
  [weightMinimum] float,
  [weightMaximun] float,
  [isDeleted] bit,
  PRIMARY KEY ([id]),
  CONSTRAINT [FK_Sevice.speciesId]
    FOREIGN KEY ([speciesId])
      REFERENCES [Species]([id])
);

CREATE TABLE [Room] (
  [id] int IDENTITY(1, 1),
  [name] nvarchar(50),
  PRIMARY KEY ([id])
);

CREATE TABLE [Pet] (
  [id] int IDENTITY(1, 1),
  [ownerId] int,
  [speciesId] int,
  [name] nvarchar(50),
  [weight] float,
  [details] nvarchar(1000),
  [picture] varchar(1000),
  PRIMARY KEY ([id]),
  CONSTRAINT [FK_Pet.speciesId]
    FOREIGN KEY ([speciesId])
      REFERENCES [Species]([id]),
  CONSTRAINT [FK_Pet.ownerId]
    FOREIGN KEY ([ownerId])
      REFERENCES [Customer]([id])
);

CREATE TABLE [Booking] (
  [id] int IDENTITY(1, 1),
  [petId] int,
  [serviceId] int,
  [roomId] int,
  [timeCreate] datetime,
  [timeCheckIn] datetime,
  [timeCheckOut] datetime,
  [status] varchar(10),
  PRIMARY KEY ([id]),
  CONSTRAINT [FK_Booking.serviceId]
    FOREIGN KEY ([serviceId])
      REFERENCES [Sevice]([id]),
  CONSTRAINT [FK_Booking.roomId]
    FOREIGN KEY ([roomId])
      REFERENCES [Room]([id]),
  CONSTRAINT [FK_Booking.petId]
    FOREIGN KEY ([petId])
      REFERENCES [Pet]([id])
);

CREATE TABLE [Feedback] (
  [id] int IDENTITY(1, 1),
  [customerId] int,
  [bookingId] int,
  [details] nvarchar(1000),
  [timeCreate] datetime,
  PRIMARY KEY ([id]),
  CONSTRAINT [FK_Feedback.customerId]
    FOREIGN KEY ([customerId])
      REFERENCES [Customer]([id]),
  CONSTRAINT [FK_Feedback.bookingId]
    FOREIGN KEY ([bookingId])
      REFERENCES [Booking]([id])
);

