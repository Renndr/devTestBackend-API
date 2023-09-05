# devTest Backend
Solution for the technical test in java, the application does a fetch to save the data from the api in the database to later make custom queries, automatically checks if there are new announcements in the api, in case new announcements are found, it saves them.

**WEB API:**
https://www.bitmex.com/api/explorer/#!/Announcement/Announcement_get

**End points**
1. GET /announcement
2. GET /announcement/{id}
3. DEL /announcement/{id}
4. GET /announcement/sorted-by-id
5. GET /announcement/filter-by-title
6. etc..

**Database Script**
Database script resources/db/migrations
