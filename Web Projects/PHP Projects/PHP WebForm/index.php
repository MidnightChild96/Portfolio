<?php
//This is the index file used to allow users to input username, passwords, hints, and sex into a table. This is used instead of a database for this project.
//I claim this work, PRJWEBFORM,  as my own work created by Kevin Nguyen (Nguyenk10@csp.edu). The file was created 11/04/2022.
//Revisions: 11/06/2022 Project is finished to standards of the project outlined.

//session start for use of session variables
session_start();
//pulls user array from session variable
$userArray = $_SESSION['userArray'];
//used for sending messages to user
$msg = null;

//prints debug statement of what is contained in the POST array
print_r($_POST);
//will trigger if the submit button was clicked
if(isset($_POST['submit'])){
    //will trigger if passwords match and other fields are not empty
    if($_POST['password'] === $_POST['confirmPassword'] && $_POST['username'] != "" && $_POST['password'] != "" && $_POST['confirmPassword'] != "" && $_POST['hint'] != "" && isset($_POST['sex'])){
        //assigns variables
        $username = $_POST['username'];
        $password = $_POST['password'];
        $hint = $_POST['hint'];
        $sex = $_POST['sex'];
        $id = $_POST['id'];
        //creates the first array storing username, password, hint, and sex
        $user = array($id, $username, $password, $hint, $sex);
        //adds the new array to the session array
        array_push($_SESSION['userArray'], $user);
        //user array will be assigned to the session array
        $userArray = $_SESSION['userArray'];
    }
    else{
        //if passwords do not match then this message is given
        if($_POST['password'] != $_POST['confirmPassword']){
            $msg = 'Passwords do not match!';
        }
        //if blank field was given then this message is displayed
        else{
            $msg = 'Do not leave any blank fields!';
        }
    }
}
//deletes user
elseif(isset($_POST['delete'])){
    //splices array and reindexes session array
    array_splice($_SESSION['userArray'],$_POST['listbox'],1);
    //assigns array to new session array
    $userArray = $_SESSION['userArray'];
}
//if it is a fresh page or a cleared page then the array is empty
else{
    //creates an empty session array
    $_SESSION['userArray'] = array();
    //asigns array to new empty session array
    $userArray = $_SESSION['userArray'];

    //Assigns id to -1
    $id = -1;
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
<!-- Wrapper for input fields -->
<div class="wrapper">
        <h2>Sign Up</h2>
        <p>Please fill this form to create an account.</p>
        <!-- Form will post and redirect back to this file -->
        <form method="POST" action="index.php">
            <!-- Labels and inputs for each label from username, password, hint, and sex -->
            <div class="form-group">
                <label>Username:</label>
                <input type="text" name="username" class="form-control ">
            </div>
            <div class="form-group">
                <label>Password:</label>
                <input type="password" name="password" class="form-control">
            </div>
            <div class="form-group">
                <label>Confirm Password:</label>
                <input type="password" name="confirmPassword" class="form-control">
            </div>
            <div class="form-group">
                <label>Password Hint:</label>
                <input type="text" name="hint" class="form-control">
            </div>
            <div class="form-group">
                <label>Sex:</label>
                <input type="radio" name="sex" value ="M">
                <label>Male</label>
                <input type="radio" name ="sex" value ="F">
                <label>Female</label>
            </div>
            <div class="form-group">
                <input type="hidden" name="id" value="<?php echo ++$id; ?>">
            </div>
            <!-- Buttons to either submit, clear inputs, or clear table -->
            <div class="form-group">
                <input name = "submit" type="submit" value="Submit">
                <input type="reset" value="Reset">
                <input type="submit" name = "clear" value="Clear Table">
            </div>
            <div class="form-group">
                <?php 
                    if($userArray != null){
                        echo '<select name="listbox">';
                        //checks if it's an array
                        if(is_array($userArray)){
                            //Loops through the user Array for every user
                            for($x=0; $x < count($userArray);$x++){
                                //checks if it's an array
                                if(is_array($userArray[$x])){
                                    //puts all usernames into an array to select from
                                    echo '<option name="index" value=' . $x . '>' . $x . ': '. $userArray[$x][1] . '</option>';  
                                }
                            }
                        }
                        echo '</select>';
                    //will submit to post to delete user from array
                    echo'<div class="form-group">
                    <input name ="delete" type="submit" value="Delete">
                </div>';
                    }
            ?>
            </div>
            <!-- Displays message if msg is not empty -->
            <?php
                if($msg != null){
                    echo $msg;
                }
            ?>
        </form>

        <!-- table showing all users that have been inputted -->
        <table cellpadding="0" cellspacing="0" width="100%" class="animeList">
            <caption class="header" style="text-align:center"></caption>
            <!-- Table headers -->
            <tr class="table-header">
                <td class="id">id</td>
                <td class="username">Username</td>
                <td class="password">Password</td>
                <td class="hint">Password Hint</td>
                <td class="sex">Sex</td>
            </tr>
            <?php 
            if($userArray != null){
                //checks if it's an array
                if(is_array($userArray)){
                    //Loops through the user Array for every user
                    for($x=0; $x < count($userArray);$x++){
                        //starts a new row for each array
                        echo '<tr>';
                        //checks if it's an array
                        if(is_array($userArray[$x])){
                            //Will loop through the user array to pull data for each column
                            for($i=0; $i < count($userArray[$x]); $i++){
                                echo '<td>' . $userArray[$x][$i] . '</td>';   
                            }
                        }
                        //lets the html know the row is ending
                        echo '</tr>';
                    }
                }
            }
            ?>
        </table>
    </div>
</body>

</html>
