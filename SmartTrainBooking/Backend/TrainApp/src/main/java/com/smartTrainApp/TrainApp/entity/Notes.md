When user books:

System does:

Check user exists

Check train exists

Check route exists

Check train stops at source & destination

Check seat availability

Insert booking record

That’s why each entity is separated.

-------------------------------------------
This design supports:

Search trains between stations

Track stops

Manage seats

Role-based security

Future payment integration

Cancellation feature

--------------------------------------
 USERS → BOOKINGS

Arrow shows:

1 near Users
M near Bookings

Meaning:

One User can make many Bookings.

But one Booking belongs to only one User.

Database side:

bookings.user_id is FK.

TRAINS → BOOKINGS

One Train
Many Bookings

Why?

Many passengers book same train.

But one booking is for only one train.

 STATIONS → ROUTES

One Station
Many Routes

Example:

Hyderabad station can be:

Source in 5 routes

Destination in 7 routes

So station appears many times in routes table.

TRAINS → TRAIN_STATIONS

One Train
Many Train_Stations entries

Example:

Train 101 stops at:

Hyderabad

Warangal

Vijayawada

Chennai

So one train has multiple rows in train_stations.

STATIONS → TRAIN_STATIONS

One Station
Many Train_Stations

Example:

Hyderabad station may have:

Train 101

Train 202

Train 303

So station appears multiple times.

 Important: Many-to-Many Relationship

Train ↔ Station is actually Many-to-Many.

Because:

One train stops at many stations.

One station has many trains.

Relational DB cannot directly store many-to-many.

So we create:

train_stations (Join Table)

This breaks:

Train (1) → TrainStation (M)
Station (1) → TrainStation (M)

That’s why arrows go both ways.

BOOKINGS Table Connections

Bookings connects to:

users

trains

stations (source)

stations (destination)

That means:

Booking is the central transaction table.