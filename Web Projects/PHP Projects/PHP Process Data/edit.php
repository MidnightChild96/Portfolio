<?php
    include('dbfCreate.php');
    $link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);
    //variables used primarily to display in the html
    $msg = null;
    $name = "";
    $description = "";
    $price = "";
    $id = "";
    //if submit it will do certain actions
    if(isset($_POST["submitButton"])){
        //POST is not empty then it will add or update to the database
        if($_POST['name'] != "" || $_POST['description'] != "" || $_POST['price'] != ""){
            //if id is not empty it will choose to update
            if($_POST['id'] != ""){
                //sql update command with post variables
                $sql = "UPDATE menu SET itemname = '" . $_POST['name'] . "', menudescription = '" . $_POST['description']. "', price = " . $_POST['price'] . " WHERE id =" . $_POST['id'];
                mysqli_query($link, $sql);
                //updates text file with new updated table
                updateTable();
                //message to user letting them know it worked
                $msg = "Item updated successfully";
            }
            else{
                //opens the data.txt and appends
                $myfile = fopen("data.txt", "a");
                //message to be written
                $line = $_POST['name'] . "," . $_POST['description'] . "," . $_POST['price'] . "\n";
                //writes to file
                fwrite($myfile, $line);
                fclose($myfile);
                //refreshes database with the new data
                createDatabase();
                //populates the table
                populateTable();
                //message letting user that it was successful
                $msg = "Item added successfully";
            }
        }
        else{
            //none of the inputs can be empty
                $msg = "You cannot have empty values!"; 
        }
    }
    if(isset($_POST["menu"])){
        //on selection this will trigger selecting the item from table
        $sql = "SELECT * FROM menu WHERE id = " . $_POST['menu'];
        $result = mysqli_query($link, $sql);
        $row = mysqli_fetch_array($result);
        //all items are assigned to a variable to be printed down below
        $name = $row[1];
        $description = $row[2];
        $price = $row[3];
        $id = $row[0];
    }
    //deletes item from table
    if(isset($_POST["deleteButton"])){
        //if id is not black it will trigger
        if($_POST['id'] != ""){
            //deletes item from table
            $sql = "DELETE FROM menu WHERE id =" . $_POST['id'];
            mysqli_query($link, $sql);
            //updates the text file with the new data
            updateTable();
            //message letting user know it has been deleted
            $msg = "Item deleted!";
        }
        else{
            //cannot delete if it is not in the table
            $msg = "Cannot delete a nonexistent item!";
        }
    }
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>WebForm</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class = "navbar">
            <a href = "presentation.php">Home</a>
            <a href = "index.php">User View</a>
            <a href = "edit.php">Edit</a>
        </div>
        <div class = "menuselectdiv">
            <form class = "menuselect" action = "edit.php" method = "POST">
                <select class = "itemselect" id=menuselect onchange = "this.form.submit()" name="menu" multiple>
                    <?php
                    //selects all items to be displayed in a select box
                        $sql = "SELECT * FROM menu";
                        $link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);
                        $result = mysqli_query($link, $sql);
                        //echoes the name of all menu items as select options
                        while($row = mysqli_fetch_array($result)){
                            echo "<option value = $row[0]>" . $row[1]. "</option>";
                        }
                    ?>
                </select> 
            </form>
        </div>
        <div class = "menuitemformdiv">
            <form class = "menuitemform" action = "edit.php" method = "POST">
                <div class = "flex-container">
                    <div class = "vertical-flex-container">
                        <div>
                            <label>Name: </label>
                        </div>
                        <div>
                            <label>Description: </label>
                        </div>
                        <div>
                            <label>Price: </label>
                        </div>
                    </div>
                    <div class = "vertical-flex-container">
                        <div>
                            <input type = "text" name = "name" id = "name" value = <?php echo "$name"; ?>>
                        </div>
                        <div>
                            <input type = "text" name = "description" id = "description" value = <?php echo "$description"; ?>>
                        </div>
                        <div>
                            <input type = "text" name = "price" id = "price" value = <?php echo "$price" ?>>
                        </div>
                    </div>
                </div>
                <div>
                     <input type = "hidden" name = "id" value = <?php echo "$id" ?>>
                </div>
                <br>
                <br>
                <input type = "submit" name = "submitButton" value = "Submit">
                <input type = "submit" name = "deleteButton" value = "Delete">
            </form>
            <?php
                if($msg != null){
                    echo $msg;
                }
            ?>
        </div>
    </body>
</html>