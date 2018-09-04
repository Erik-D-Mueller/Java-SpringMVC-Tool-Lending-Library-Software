## Database

This is a demo web-app for a free tool lending community library. I and a team of three other people built it from scratch in about three business days.

It is currently running on heroku:

https://fast-temple-14445.herokuapp.com

It has two user modes: Member or librarian.  A member can log in and edit their personal information and view what tools they currently have checked out.

A librarian can: 

-Sign up members
-Check tools in and out to members
-See the lists of available tools and checked out tools
-See to whom who tools are checked out and see when they're due back
-See what tools are checked out to a particular member

For a librarian to check tools in our out to a member, they first select the member then add the tools to the shopping cart then select "Check Out".

There is a status bar at the top right that always displays the username that is currently logged in, and the username that is being served. (if a librarian is serving a member)

If you want to log in as a librarian too see and play with the functionality use:

Username: Librarian
Password: Librarian


The back end is in the java spring MVC framework.  It uses a postgresql database. The database folder has a bash script and several sql scripts to set up the database.  The app uses the minified versions of jquery and bootstrap.  It has DAO integration tests built in as well.  The database uses salted password hashing.


