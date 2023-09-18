<?php
    include("dbfCreate.php");
    //creates and populates the database
    createDatabase();
    populateTable();
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Proof Of Concept</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class = "navbar">
              <a href="presentation.php">Home</a>
              <a href="index.php">User View</a>
              <a href="edit.php">Edit</a>
        </div>

        <div class = "menudiv">
            <div class = "flex-container">
                <div class = "vertical-flex-container">
                    <div class="item-flex-container">
                        <div > Item </div>
                        <div>Description </div>
                        <div> Price </div>
                    </div>
                    <?php
                        $link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);
                        $sql = "SELECT * FROM menu";
                        $result = mysqli_query($link, $sql);
                        //left side of the menu will be shown all odd numbered items
                        while($row = mysqli_fetch_array($result)){
                            if($row[0] % 2 != 0){
                            echo "
                            <div class = 'item-flex-container'>
                                <div> 
                                    $row[1] 
                                </div>
                                <div>
                                    $row[2]
                                </div>
                                <div>
                                    $$row[3]
                                </div>
                            </div>";
                            }
                        }
                    ?>
                </div>
                <div class = "vertical-flex-container">
                    <div class="item-flex-container">
                        <div>  Item </div>
                        <div>  Description </div>
                        <div>  Price </div>
                    </div>
                <?php
                        $link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);
                        $sql = "SELECT * FROM menu";
                        $result = mysqli_query($link, $sql);
                        //right side will show all even numbered items
                        while($row = mysqli_fetch_array($result)){
                            if($row[0] % 2 == 0){
                                echo "
                                <div class = 'item-flex-container'>
                                    <div> 
                                        $row[1] 
                                    </div>
                                    <div>
                                        $row[2]
                                    </div>
                                    <div>
                                        $$row[3]
                                    </div>
                                </div>";
                            }
                        }
                    ?>
                </div>
            </div>
        </div>
    </body>
</html>