<?php
    print_r($_POST);
    $link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD);
    $sql = "DROP DATABASE IF EXISTS restaurant;";
    mysqli_multi_query($link, $sql);
   
    $sql="CREATE DATABASE restaurant;
        USE restaurant;
        CREATE TABLE menu(
            id INT AUTO_INCREMENT PRIMARY KEY,
            itemname VARCHAR(255),
            menudescription LONGTEXT,
            price FLOAT);";

   
   $result = mysqli_multi_query($link, $sql);
   $result = mysqli_store_result($link);
   while($result = mysqli_next_result($link));

   $sql = "INSERT INTO menu(itemname,menudescription,price) VALUES('spaghetti', 'it's good', 14.99);";
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Proof Of Concept</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
    <div class="navbar">
          <a href="presentation.php">Home</a>
          <a href="index.php">User View</a>
          <a href="edit.php">Edit</a>
        </div>

        <select id=menuselect onchange = "this.form.submit()" name="menu" multiple>
                    <?php
                        $sql = "SELECT * FROM menu";
                        $link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);
                        $result = mysqli_query($link, $sql);
                        while($row = mysqli_fetch_array($result)){
                            echo "<option value = $row[0]>" . $row[1]. "</option>";
                        }
                    ?>
        </select> 

        <form class = "menuitemform" action = "edit.php" method = "POST">
                <div class = "flex-container">
                    <div class = "vertical-flex-container">
                        <div>
                            <label>Name: </label>
                        </div>
                    </div>
                    <div class = "vertical-flex-container">
                        <div>
                            <input type = "text" name = "name" id = "name" value = <?php echo "$name"; ?>>
                        </div>
                    </div>
                </div>
                <br>
                <br>
                <input type = "submit" name = "submitButton" value = "Submit">
                <input type = "submit" name = "deleteButton" value = "Delete">
            </form>
    </body>
</html>