-- Create tables

CREATE TABLE IF NOT EXISTS worker (
    worker_id INT PRIMARY KEY,
    supervisorId INT,
    name VARCHAR(255),
    phoneNumber VARCHAR(50),
    shortBio VARCHAR(255),
    deployed BOOLEAN,
    tele_Id VARCHAR(50),
    curPropertyId INT
);

CREATE TABLE IF NOT EXISTS admin (
    adminId INT PRIMARY KEY,
    name VARCHAR(255),
    isRoot BOOLEAN
);

CREATE TABLE IF NOT EXISTS cleaningtask (
    taskId INT PRIMARY KEY,
    propertyId INT,
    workerId INT,
    feedbackId INT,
    shift VARCHAR(50),
    status ENUM('Scheduled', 'InProgress', 'Cancelled', 'Completed'),
    date DATE,
    Acknowledged BOOLEAN
);

CREATE TABLE IF NOT EXISTS client (
    clientId INT PRIMARY KEY,
    name VARCHAR(255),
    phoneNumber VARCHAR(50),
    email VARCHAR(100),
    workerId INT
);

CREATE TABLE IF NOT EXISTS feedback (
    feedbackId INT PRIMARY KEY,
    cleaningTaskId INT,
    rating INT,
    comment TEXT
);

CREATE TABLE IF NOT EXISTS jobstats (
    monthYear VARCHAR(7) PRIMARY KEY,  -- Format MM-YYYY
    totalHours INT,
    totalCleaningTasks INT,
    totalClients INT,
    totalProperties INT,
    totalWorkers INT,
    totalPackages INT
);

CREATE TABLE IF NOT EXISTS leaveapplication (
    leaveApplicationId INT PRIMARY KEY,
    workerId INT,
    adminId INT,
    startDate DATE,
    endDate DATE,
    leaveType ENUM('MC', 'AL', 'HL', 'EL'),
    status ENUM('Pending', 'Approved', 'Rejected'),
    submissionDateTime DATETIME
);

CREATE TABLE IF NOT EXISTS leavestats (
    monthYear VARCHAR(7),  -- Format YYYY-MM
    alCount INT,
    mcCount INT,
    hlCount INT,
    elCount INT,
    workerId INT
);

CREATE TABLE IF NOT EXISTS cleaning_package (
    packageId INT PRIMARY KEY,
    packageType VARCHAR(50),
    price DECIMAL(10, 2),
    hours INT,
    hourly_rate DECIMAL(10, 2),
    property_details VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS property (
    propertyId INT PRIMARY KEY,
    clientId INT,
    packageId INT,
    address VARCHAR(255),
    latitude DOUBLE,
    longitude DOUBLE
);

CREATE TABLE IF NOT EXISTS workerhours (
    workerHoursId INT PRIMARY KEY,
    workerId INT,
    monthYear VARCHAR(7),  -- Format YYYY-MM
    totalHoursWorked INT,
    overtimeHours INT
);