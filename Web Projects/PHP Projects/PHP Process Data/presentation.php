<?php

?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Presentation</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
             <!-- Navigation Bar-->
   
        <div class="navbar">
          <a href="presentation.php">Home</a>
          <a href="index.php">User View</a>
          <a href="edit.php">Edit</a>
        </div>
        
        <h2>Presentation</h2>
        <p>There's a few ways we can implement. The less efficient way is to allow the staff to go into the PHP file and identify where the SQL code 
            is stored on the PHP file. This could be a hassle for those not familiar with the format of files. The ideal situation for all restaurant 
            employees is to store the data in a text document where limited knowledge of SQL language is necessary. It is easier accessible to see 
            what lines are being added to the menu as well makes it simpler to remove SQL code based on the client needs. Saving the file and refreshing 
            the page will update the tables as the PHP will automatically repopulate the database during a page load, and in this manner it is also 
            more modifiable compared to a static table that is already implemented into the database. The text file  with the menu doesn't necessarily 
            have to be in the same directory as the website files making it more convenient for the restaurant to maintain. This file can also be updated 
            using the edit page allowing for an easier interface for users to inpute data, but if the webpage is not working for whatever reason, simply 
            opening up the text file will also allow the same modification without the interface. The text file also allows for a local storage of the 
            information instead of requiring the server to access the file. 
        </p>
        <h2>Homepage</h2>
        <img src = 'graphic/index.jpg'>
        <h2>Edit Page</h2>
        <img src = 'graphic/edit.jpg'>
    </body>
</html>