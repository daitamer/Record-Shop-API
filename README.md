**Record Shop API**

Welcome to the Record Shop API! This API provides a simple interface for managing a collection of music albums. 

You can use it to add, view, update, and delete albums, as well as to search for albums by various criteria like artist, genre, or release year.

**Features**
List All Albums: Retrieve a complete list of albums in the collection.

Add a New Album: Add a new album to the collection with details like title, artist, genre, and release year.

Update an Existing Album: Modify details of an existing album.

Delete an Album: Remove an album from the collection.

Search Albums: Find albums by various criteria such as artist, genre, or release year.

**API Endpoints**

Get All Albums
Retrieves a list of all albums.
URL: /albums
Method: GET
Response: A JSON array of album objects.

Get Album by ID
Retrieves a specific album by its ID.
URL: /albums/{id}
Method: GET
Response: A JSON object of the album details.

Add a New Album
Adds a new album to the collection.
URL: /albums
Method: POST
Request Body:

//json:
{
  "title": "Album Title",
  "artist": "Artist Name",
  "genre": "Genre",
  "releaseYear": "2024"
}
Response: The created album object with its unique ID.

Update an Album
Updates an existing album by ID.
URL: /albums/{id}
Method: PUT
Request Body:

//json:
{
  "title": "Updated Title",
  "artist": "Updated Artist",
  "genre": "Updated Genre",
  "releaseYear": "Updated Year"
}
Response: The updated album object.

Delete an Album
Deletes an album by ID.
URL: /albums/{id}
Method: DELETE
Response: A success message confirming the deletion.

**Example Usage**

To fetch all albums, send a GET request to /albums.
To add a new album, send a POST request with album details in the body to /albums.
To update an album, send a PUT request with updated data to /albums/{id}.
To delete an album, send a DELETE request to /albums/{id}.
