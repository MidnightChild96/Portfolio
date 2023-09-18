<?php
    //creates the database
    function createDatabase($link){
        //drops database if it exists
        $sql = "DROP DATABASE IF EXISTS company;";
        mysqli_multi_query($link, $sql);
       //creates and uses the new database
        $sql="CREATE DATABASE company;
            USE company;";
       //queries and stores the results
       mysqli_multi_query($link, $sql);
       mysqli_store_result($link);
       while($result = mysqli_next_result($link));
    }

    //populates the tables with data
    function populateTable($link){
        //creates tables of manager, manufacturer, and product then inserts data into the tables
        $sql = "CREATE TABLE manager(
            managerid INT AUTO_INCREMENT PRIMARY KEY,
            manager VARCHAR(255),
            department VARCHAR(255));
       
            CREATE TABLE manufacturer(
            manufacturerid int AUTO_INCREMENT PRIMARY KEY,
            manufacturer varchar(255),
            website varchar(255));
            
            CREATE TABLE datatable(
            id int AUTO_INCREMENT PRIMARY KEY,
            product varchar(255),
            color varchar(255),
            price float,
            quantity int,
            page varchar(255),
            managerid INT,
            manufacturerid INT,
            FOREIGN KEY(managerid) REFERENCES manager(managerid),
            FOREIGN KEY(manufacturerid) REFERENCES manufacturer(manufacturerid));
            
            INSERT INTO manager(manager, department) VALUES ('Michael Howard', 'Bath');
            INSERT INTO manager(manager, department) VALUES ('John Fritz', 'Kitchen');
            INSERT INTO manager(manager, department) VALUES ('Liz Tabor', 'Bedbroom');
       
            INSERT INTO manufacturer(manufacturer, website) VALUES ('Cannon', 'http://www.cannonhome.com/');
            INSERT INTO manufacturer(manufacturer, website) VALUES ('InterDesign', 'http://www.interdesignusa.com/');
            INSERT INTO manufacturer(manufacturer, website) VALUES ('LinenSpa', 'http://www.interdesignusa.com/');
       
            INSERT INTO datatable(product, color, price, quantity, page, managerid, manufacturerid) VALUES ('Bath Towel', 'Black', '5.75', '75', 'http://MyStore.com/bathtowel.php', '1', '1');
            INSERT INTO datatable(product, color, price, quantity, page, managerid, manufacturerid) VALUES ('Wash Cloth', 'White', '0.99', '225', 'http://MyStore.com/washcloth.php', '1', '1');
            INSERT INTO datatable(product, color, price, quantity, page, managerid, manufacturerid) VALUES ('Shower Curtain', 'White', '11.99', '73', 'http://MyStore.com/showercurtain.php', '1', '2');
            INSERT INTO datatable(product, color, price, quantity, page, managerid, manufacturerid) VALUES ('Pantry Organizer', 'Clear', '3.99', '52', 'http://MyStore.com/pantryorganizer.php', '2', '2');
            INSERT INTO datatable(product, color, price, quantity, page, managerid, manufacturerid) VALUES ('Storage Jar', 'Clear', '5.99', '18', 'http://MyStore.com/pantryorganizer.php', '2', '2');
            INSERT INTO datatable(product, color, price, quantity, page, managerid, manufacturerid) VALUES ('Firm Pillow', 'White', '12.99', '24', 'http://MyStore.com/pillow.php', '3', '1');
            INSERT INTO datatable(product, color, price, quantity, page, managerid, manufacturerid) VALUES ('Comforter', 'White', '34.99', '12', 'http://MyStore.com/comforter.php', '3', '3');
            INSERT INTO datatable(product, color, price, quantity, page, managerid, manufacturerid) VALUES ('Rollaway Bed', 'Black', '249.99', '3', 'http://MyStore.com/rollaway.php', '3', '3');";
       
          //queries the code into mysqli
           mysqli_multi_query($link, $sql);
           while($result = mysqli_next_result($link));
    }
    //function to display the table
    function displayTable($link){

        //Checks for submit is iset
        if(isset($_POST['submit'])){
            //table variable used to display whatever table was submitted
            $table = $_POST['listbox'];
            //will assign to the manufacturer table
            if($table == 3){
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
                    echo '</tr>';
                        }
            }
        }
    }
?>

<?php
    /* Database credentials. Assuming you are running MySQL
    server with default setting (user 'root' with no password) */
    define('DB_SERVER', 'localhost');
    define('DB_USERNAME', 'root');
    define('DB_PASSWORD', 'mysql');
    
    /* Attempt to connect to MySQL database */
    $link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD);
    
    // Check connection
    if($link === false){
        die("ERROR: Could not connect. " . mysqli_connect_error());
    }

    createDatabase($link);
    populateTable($link);

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
        <form  method="POST" action= "dbfCreate.php">
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
                    displayTable($link);
                ?>
        </table>
    </body>
</html>