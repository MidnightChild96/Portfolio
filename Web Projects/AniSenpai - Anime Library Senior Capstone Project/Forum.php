<!-- 
Kevin Nguyen
Le Phan
Ethan Thao

AniSenpai The Greatest Webpage

-->


<!-- Connect to the HTML and CSS page-->
<!DOCTYPE html>
<html>

<head>

  <link rel="stylesheet" href="Forum.css">
  <link rel="stylesheet" href="navbar.css">

  <title>Forum</title>

</head>

<body>

  <!-- Navigation Bar-->

  <div class="navbar">
    <div class="dropdown">
      <button class="dropbtn">Profile
        <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-content">
        <a href="reset-password.php">Reset Passowrd</a>
        <a href="logout.php">Logout</a>
      </div>
    </div>
    <a href="AnimeList.php">Anime</a>
    <a href='Homepage.php#ads'>Sites</a>
    <a href="Chatbox.php">Chat</a>

    <div class="AniSenpai">
      <li><a href=Homepage.php>AniSenpai</a></li>
    </div>

  </div>

  
    <div class="border">

      <div class="theForum">

        <!-- Form to post the user input -->
        <!-- User input for the form by getting the title, upvote, downvote, and reasoning-->
        <form action="testTwo.php" method="POST">

          <br><label for="animeTitle">Anime Title:</label><br>
          <input type="text" id="animeTitle" name="animeTitle" value=""><br><br>

          <!--
        <label for="upVote">Upvote</label>
        <input type="int" id="upVote" name="Upvoting"  value="">

        <label for="downVote">Downvote</label>
        <input type="radio" id="downVote" name="Downvoting"  value=""><br><br>
            -->


          <label for="generalVote">Voting</label><br>
                  <label for="upVote">Upvote</label>
        <input type="radio" id="upVote" name="vote" value="1">

        <label for="downVote">Downvote</label>
        <input type="radio" id="downVote" name="vote" value="-1"><br><br>


          <label for="animeBox">Reasoning:</label><br>
          <input type="explaination" id="animeBox" name="animeBox" value=""><br><br>

          <!-- Submit button that goes to a submission page-->
          <input type="submit" id="submitButton" name="submitButton" value="Submit">


          </a>

         
      </div>

      </form>

    </div>
  
  </div>
</body>


</html>