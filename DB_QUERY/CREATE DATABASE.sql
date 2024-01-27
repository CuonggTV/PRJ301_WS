CREATE DATABASE PRJ301_WS
GO

USE PRJ301_WS
GO

CREATE TABLE [Feedback] (
  [id] INT IDENTITY(1, 1),
  [bookingId] int,
  [details] nvarchar(1000),
  [timeCreate] datetime,
  PRIMARY KEY ([id])
);

CREATE TABLE [Species] (
  [id] int IDENTITY(1, 1),
  [name] nvarchar(50),
  PRIMARY KEY ([id])
);

CREATE TABLE [Service] (
  [id] int IDENTITY(1, 1),
  [name] nvarchar(100),
  [details] nvarchar(1000),
  [weightMinimum] float,
  [weightMaximun] float,
  [price] float,
  [isDisable] bit,
  PRIMARY KEY ([id])
);

CREATE TABLE [RoomType] (
  [id] INT IDENTITY(1, 1),
  [name] nvarchar(50),
  [price] float,
  PRIMARY KEY ([id])
);

CREATE TABLE [Room] (
  [id] INT IDENTITY(1, 1),
  [roomTypeId] int,
  [name] nvarchar(50),
  [height] float,
  [width] float,
  PRIMARY KEY ([id]),
  CONSTRAINT [FK_Room.roomTypeId]
    FOREIGN KEY ([roomTypeId])
      REFERENCES [RoomType]([id])
);

CREATE TABLE [Species] (
  [id] INT IDENTITY(1, 1),
  [name] nvarchar(50),
  PRIMARY KEY ([id])
);

CREATE TABLE [Customer] (
  [id] INT IDENTITY(1, 1),
  [name] nvarchar(50),
  [email] varchar(50),
  [phoneNumber] char(10),
  PRIMARY KEY ([id])
);

CREATE TABLE [Account] (
  [id] INT IDENTITY(1, 1),
  [customerId] int,
  [username] varchar(50),
  [password] varchar(50),
  [isBlocked] bit,
  PRIMARY KEY ([id]),
  CONSTRAINT [FK_Account.customerId]
    FOREIGN KEY ([customerId])
      REFERENCES [Customer]([id])
);

CREATE TABLE [Pet] (
  [id] INT IDENTITY(1, 1),
  [ownerId] int,
  [speciesId] int,
  [name] nvarchar(50),
  [weight] float,
  [height] float,
  [width] float,
  [details] nvarchar(1000),
  [picture] varchar(1000),
  PRIMARY KEY ([id]),
  CONSTRAINT [FK_Pet.speciesId]
    FOREIGN KEY ([speciesId])
      REFERENCES [Species]([id]),
  CONSTRAINT [FK_Pet.ownerId]
    FOREIGN KEY ([ownerId])
      REFERENCES [Account]([id])
);

CREATE TABLE [Booking] (
  [id] INT IDENTITY(1, 1),
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
      REFERENCES [Service]([id]),
  CONSTRAINT [FK_Booking.roomId]
    FOREIGN KEY ([roomId])
      REFERENCES [Room]([id]),
  CONSTRAINT [FK_Booking.petId]
    FOREIGN KEY ([petId])
      REFERENCES [Pet]([id])
);

CREATE TABLE [Reply] (
  [feedbackId] INT IDENTITY(1, 1),
  [details] nvarchar(1000),
  [timeCreate] datetime
);


