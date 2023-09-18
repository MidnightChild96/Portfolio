<?php
    /* Database credentials. Assuming you are running MySQL
    server with default setting (user 'root' with no password) */
    define('DB_SERVER', 'localhost');
    define('DB_USERNAME', 'root');
    define('DB_PASSWORD', 'mysql');
    define('DB_NAME', 'restaurant');


    //Creates database
    function createDatabase(){
        //connects to server
        $link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD);
        //drops database if exists
        $sql = "DROP DATABASE IF EXISTS restaurant;";
        mysqli_multi_query($link, $sql);
       
        //creats database and table
        $sql="CREATE DATABASE restaurant;
            USE restaurant;
            CREATE TABLE menu(
                id INT AUTO_INCREMENT PRIMARY KEY,
                itemname VARCHAR(255),
                menudescription LONGTEXT,
                price FLOAT);";

       //execute the queries
       mysqli_multi_query($link, $sql);
       mysqli_store_result($link);
       while($result = mysqli_next_result($link));
    }

    //populates the tables
    function populateTable(){
        //connects to the server
        $link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);
        //assigns the data file
        $file = file("data.txt");
        //loops through all lines of the file
        foreach($file as $line){
            //splits each line on the comma
            $array = explode(",", $line);
            //every item is a name, description, and price
            list($name, $description, $price) = $array;
            //converts it into an sql command
            $sql = "INSERT INTO menu(itemname,menudescription,price) VALUES('$name','$description',$price);";
            //sql query
            mysqli_query($link,$sql);
        }
    }

    //updates the tables with the new info
    function updateTable(){
        //connects to the server
        $link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);
        //empties the file
        $file = fopen("data.txt", "w");
        fclose($file);
        //writes the new file with data from the server
        $file = fopen("data.txt", "a");
        $sql = "SELECT * FROM menu";
        $link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);
        $result = mysqli_query($link, $sql);
        //loops through entire table and creating a new text file based on it
        while($row = mysqli_fetch_array($result)){
            $write = $row[1] . "," . $row[2] . "," . $row[3] . "\n"; 
            fwrite($file, $write);
        }
        fclose($file);
    }
?>