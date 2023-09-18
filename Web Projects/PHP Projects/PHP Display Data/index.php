<?php
    /* Database credentials. Assuming you are running MySQL
    server with default setting (user 'root' with no password) */
    define('DB_SERVER', 'localhost');
    define('DB_USERNAME', 'root');
    define('DB_PASSWORD', 'mysql');
    define('DB_NAME', 'displaydata');
    
    /* Attempt to connect to MySQL database */
    $link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);
    
    // Check connection
    if($link === false){
        die("ERROR: Could not connect. " . mysqli_connect_error());
    }
    //Checks for submit is iset
    if(isset($_POST['submit'])){
        //table variable used to display whatever table was submitted
        $table = $_POST['listbox'];
        //will assign to the manufacturer table
        if($table == 3){
            echo 'working';
            $query = "SELECT * FROM manufacturer";
        }
        //Will assign the manager table
        if($table == 2){
            $query = "SELECT * FROM manager";
        }
        //will default to the datatable
        if($table != 2 && $table != 3){
            $query = "SELECT * FROM datatable";
        }
    }
    //Page will always start on the datatable
    else{
        $table = 1;
        $query = "SELECT * FROM datatable";
    }
    $result = mysqli_query($link, $query);
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Data Table</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <table cellpadding="0" cellspacing="0" width="100%">
        <!-- form to submit the tables using a list box -->
        <form  method="POST" action="index.php">
            <select name="listbox">
                <option name = 'table' value='1'>
                    Product Table
                </option>
                <option name = 'table' value='2'>
                    Manager Table
                </option>
                <option name = 'table' value='3'>
                    Manufacturer Table
                </option>
             </select>
             <input type="submit" name="submit" value="Submit">
        </form>
                <caption class="header" style="text-align:center"></caption>
                <?php 
                //Fills table if it is the manufacturer table
                if($table == 3){
                    //table headers fo rthe manufactrer table
                    echo '<tr class="table-header">
                    <td>ID</td>
                    <td>Manufacturer</td>
                    <td>Website</td>
                    </tr>';
                    //loops through all data entries in the table
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
                        echo '</tr>';
                    }
                }
                //Fills table if its the manager table
                if($table == 2){
                    //table header for manager table
                    echo '<tr class="table-header">
                    <td>ID</td>
                    <td>Manager</td>
                    <td>Department</td>
                    </tr>';
                    //loops through all data entries in the table
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
                    echo '</tr>';
                    }
                }
                //defaults on the datatable
                else{
                    if($table == 1){
                    //table headers used for the table
                    echo '<tr class="table-header">
                    <td>Product ID</td>
                    <td>Product Name</td>
                    <td>Color</td>
                    <td>Price</td>
                    <td>On Hand Quantity</td>
                    <td>Product Page</td>
                    <td>Manager ID</td>
                    <td>Manufacturer ID</td>
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
                            echo $row[6];
                        echo '</td>';
                        echo '<td>';
                            echo $row[7];
                        echo '</td>';
                    echo '</tr>';
                    }
                }
            }
                ?>
        </table>
        <p>The first stage of the design process was to create a model for the tables. This included how each table was related and which data should be grouped together.
        The next stage was to create the SQL tables in MySQL which was simply manually inputted through the MySQL tools in MyPHPAdmin. The following stage was to 
        create a php file that would pull from the table. This included defining the table, password, database, and username. Each table was assigned a value and would be 
        sent to the post on submit through the list box. The tables were purely visual and did not include any way to change data in the tables. 
        </p>
    </body>
</html>