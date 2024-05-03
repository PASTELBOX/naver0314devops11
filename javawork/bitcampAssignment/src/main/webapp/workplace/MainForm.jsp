<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
 <link href="css/style.css" rel="stylesheet">
</head>
<body>
	 <div class="status-bar">
      <div class="status-bar__column">
        <span>No Service</span>
        <i class="fas fa-wifi"></i>
      </div>
      <div class="status-bar__column">
        <span>18:43</span>
      </div>
      <div class="status-bar__column">
        <span>110%</span>
        <i class="fas fa-battery-full fa-lg"></i>
        <i class="fas fa-bolt"></i>
      </div>
    </div>

    <header class="screen-header">
      <h1 class="screen-header__title">Friends</h1>
      <div class="screen-header__icons">
        <span><i class="fas fa-search fa-lg"></i></span>
        <span><i class="fas fa-music fa-lg"></i></span>
        <span><i class="fas fa-cog fa-lg"></i></span>
      </div>
    </header>

    <a id="friends-display-link">
      <i class="fas fa-info-circle"></i> Friends' Names Display
      <i class="fas fa-chevron-right fa-xs"></i>
    </a>

    <main class="friends-screen">
      <div class="user-component">
        <div class="user-component__column">
          <img
            src="https://avatars3.githubusercontent.com/u/3612017"
            class="user-component__avatar user-component__avatar--xl"
          />
          <div class="user-component__text">
            <h4 class="user-component__title">Nicolas</h4>
            <!-- <h6 class="user-component__subtitle">this text whatever</h6> -->
          </div>
        </div>
        <div class="user-component__column"></div>
      </div>
      <div class="friends-screen__channel">
        <div class="friends-screen__channel-header">
          <span>Channel</span>
          <i class="fas fa-chevron-up fa-xs"></i>
        </div>
        <div class="user-component">
          <div class="user-component__column">
            <img
              src="https://avatars3.githubusercontent.com/u/3612017"
              class="user-component__avatar user-component__avatar--sm"
            />
            <div class="user-component__text">
              <h4 class="user-component__title user-component__title--not-bold">
                Channel
              </h4>
            </div>
          </div>
          <div class="user-component__column">
            <div>
              <span>2</span>
              <i class="fas fa-chevron-right fa-xs"></i>
            </div>
          </div>
        </div>
      </div>
    </main>

    <nav class="nav">
      <ul class="nav__list">
        <li class="nav__btn">
          <a class="nav__link" href="friends.html"
            ><i class="fas fa-user fa-2x"></i
          ></a>
        </li>
        <li class="nav__btn">
          <a class="nav__link" href="chats.html">
            <span class="nav__notification badge">1</span>
            <i class="far fa-comment fa-2x"></i>
          </a>
        </li>
        <li class="nav__btn">
          <a class="nav__link" href="find.html"
            ><i class="fas fa-search fa-2x"></i
          ></a>
        </li>
        <li class="nav__btn">
          <a class="nav__link" href="more.html"
            ><i class="fas fa-ellipsis-h fa-2x"></i
          ></a>
        </li>
      </ul>
    </nav>
    <div id="splash-screen">
      <i class="fas fa-comment"></i>
    </div>
</body>
</html>