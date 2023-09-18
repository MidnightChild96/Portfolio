<?php
    //joins both the product table and manager tables
    function TableJoin($link){
        //Sql code
        $sql = "SELECT * FROM datatable JOIN manager";
        $result = mysqli_query($link, $sql);
                    //table headers used for the table
                    echo '
                    <tr class="table-header">
                        <td>Product ID</td>
                        <td>Product Name</td>
                        <td>Color</td>
                        <td>Price</td>
                        <td>On Hand Quantity</td>
                        <td>Product Page</td>
                        <td>Manager</td>
                        <td>Department</td>
                    </tr>';
                        //loops through all data entries
                        while($row = mysqli_fetch_array($result)){
                            echo '<tr>';
                                echo '<td>';
                                    echo $row[0];
                                echo '</td>';
                                echo '<td>';
                                    echo $row[1];
                                echo '</td>';
                                echo '<td>';
                                    echo $row[2];
                                echo '</td>';
                                echo '<td>';
                                    echo $row[3];
                                echo '</td>';
                                echo '<td>';
                                    echo $row[4];
                                echo '</td>';
                                echo '<td>';
                                    echo '<a href=' . $row[5] . '>' . $row[5] . '</a>';
                                echo '</td>';
                                echo '<td>';
                                    echo $row[9];
                                echo '</td>';
                                echo '<td>';
                                    echo $row[10];
                                echo '</td>';
                            echo '</tr>';
                                }
    }

    //right join with manager table on product table
    function RightJoin($link){
        $sql = "SELECT * FROM manager RIGHT JOIN datatable ON manager.managerid = datatable.managerid";
        $result = mysqli_query($link, $sql);

        //table headers used for the table
        echo '
        <tr class="table-header">
            <td>ID</td>
            <td>Manager</td>  
            <td>Department</td>
            <td>Product ID</td>
            <td>Product Name</td>
            <td>Color</td>
            <td>Price</td>
            <td>On Hand Quantity</td>
            <td>Product Page</td>
        </tr>';
            //loops through all data entries
            while($row = mysqli_fetch_array($result)){
                echo '<tr>';
                    echo '<td>';
                        echo $row[0];
                    echo '</td>';
                    echo '<td>';
                        echo $row[1];
                    echo '</td>';
                    echo '<td>';
                        echo $row[2];
                    echo '</td>';
                    echo '<td>';
                        echo $row[3];
                    echo '</td>';
                    echo '<td>';
                        echo $row[4];
                    echo '</td>';
                    echo '<td>';
                        echo $row[5];
                    echo '</td>';
                    echo '<td>';
                        echo $row[6];
                    echo '</td>';
                    echo '<td>';
                        echo $row[7];
                    echo '</td>';
                    echo '<td>';
                    echo '<a href=' . $row[8] . '>' . $row[8] . '</a>';
                    echo '</td>';
                echo '</tr>';
                    }
    }

    //left join with manufacturer table on product table
    function LeftJoin($link){
        $sql = "SELECT * FROM manufacturer LEFT JOIN datatable ON manufacturer.manufacturerid = datatable.manufacturerid";
        $result = mysqli_query($link, $sql);

        //table headers used for the table
        echo '
        <tr class="table-header">
            <td>ID</td>
            <td>Manufacturer</td>
            <td>Website</td>
            <td>Product ID</td>
            <td>Product Name</td>
            <td>Color</td>
            <td>Price</td>
            <td>On Hand Quantity</td>
            <td>Product Page</td>
        </tr>';
            //loops through all data entries
            while($row = mysqli_fetch_array($result)){
                echo '<tr>';
                    echo '<td>';
                        echo $row[0];
                    echo '</td>';
                    echo '<td>';
                        echo $row[1];
                    echo '</td>';
                    echo '<td>';
                        echo '<a href=' . $row[2] . '>' . $row[2] . '</a>';
                    echo '</td>';
                    echo '<td>';
                        echo $row[3];
                    echo '</td>';
                    echo '<td>';
                        echo $row[4];
                    echo '</td>';
                    echo '<td>';
                        echo $row[5];
                    echo '</td>';
                    echo '<td>';
                        echo $row[6];
                    echo '</td>';
                    echo '<td>';
                        echo $row[7];
                    echo '</td>';
                    echo '<td>';
                        echo '<a href=' . $row[8] . '>' . $row[8] . '</a>';
                    echo '</td>';
                echo '</tr>';
                    }
    }
?>

<?php
    /* Database credentials. Assuming you are running MySQL
    server with default setting (user 'root' with no password) */
    define('DB_SERVER', 'localhost');
    define('DB_USERNAME', 'root');
    define('DB_PASSWORD', 'mysql');
    define('DB_NAME', 'company');
    
    /* Attempt to connect to MySQL database */
    $link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);
    
    // Check connection
    if($link === false){
        die("ERROR: Could not connect. " . mysqli_connect_error());
    }
?>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
</head>
    <body>
        <h2>Join</h2>
            <table cellpadding="0" cellspacing="0" width="100%">
                <?php TableJoin($link) ?>
            </table>
        <h2>Left Outer Join</h2>
            <table cellpadding="0" cellspacing="0" width="100%">
                <?php LeftJoin($link) ?>
            </table>
        <h2>Right Outer Join</h2>
            <table cellpadding="0" cellspacing="0" width="100%">
                <?php RightJoin($link) ?>
            </table>
        <p>The first table is joining both the product table and the manager table. This wouldn't be as useful as a left or right join 
            but could be useful to see what department products could be placed in or which manager should be assigned. The left outer 
            join on the hand is much more useful in that it combines both the manufacturer and product tables. This sorts out what item 
            each manufacturer produces in the product table. This can be useful if a customer is looking for a particular item, but only 
            knows the manufacturer's name. The right outer join is similar to the join mentioned above, but instead it organizes the managers 
            based on what product they manage. This would be useful for a company to identify who is in charge of what product, and ask 
            about their knowledge in that particular area. These individuals should have an understanding what is in stock and descriptions 
            of their products that they are in charge of.
        </p>
    </body>
</html>