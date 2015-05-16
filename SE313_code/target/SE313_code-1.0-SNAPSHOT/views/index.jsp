<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html lang="en" ng-app="watApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Wat Phar Singh</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bower_components/html5-boilerplate/css/normalize.css">
    <link rel="stylesheet" href="bower_components/html5-boilerplate/css/main.css">
    <link rel="stylesheet" href="app.css">
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css">
    <script src="bower_components/html5-boilerplate/js/vendor/modernizr-2.6.2.min.js"></script>
    <script src="bower_components/angular/angular.js"></script>
    <script src="bower_components/angular-route/angular-route.js"></script>
    <script src="bower_components/angular-resource/angular-resource.js"></script>
    <script src="bower_components/angular-cookies/angular-cookies.js"></script>
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="bower_components/ng-flow/dist/ng-flow-standalone.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.14/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.14/angular-animate.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/gsap/1.10.3/TweenMax.min.js"></script>
    <script src="app.js"></script>
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>




    <!-- add i18n script -->
    <script src="bower_components/angular-translate/angular-translate.js"></script>
    <script src="bower_components/angular-translate-loader-url/angular-translate-loader-url.js"></script>
    <script src="js/homeController.js"></script>
    <script src="js/ActivityController.js"></script>
    <script src="js/activityServices.js"></script>
    <script src="js/securityController.js"></script>
<<<<<<< HEAD
=======
    <script src="js/registerController.js"></script>
    <script src="js/historyService.js"></script>
    <script src="js/historyController.js"></script>
    <script src="js/registerService.js"></script>
    <script src="js/activityServices.js"></script>
    <script src="js/ActivityController.js"></script>
    <script src="js/languageServices.js"></script>
    <script src="js/languageControllers.js"></script>



>>>>>>> 4e641d249dfedc80ad3a8e9e290e54f041169748
</head>
<body style="background-color: #000000;">
<div ng-controller="languageController">
    <div class="container-fluid">
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li ><a href="" ng-click="changeLanguage('en')" translate>langBar.eng</a></li>
                <li><a href="" ng-click="changeLanguage('th')" translate>langBar.thai</a></li>

            </ul>
        </div>
    </div>
</div>
<div class="whole-page">
            <div ng-include src="'template/topnav.html'"></div>


    <div class="container-fluid">
        <div class="row">

            <div class="col-md-10">
                <ng-view>Loading...</ng-view>

            </div>
        </div>
    </div>


    <!-- In production use:
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/x.x.x/angular.min.js"></script>
    -->
    <div><footer>Copyright @ 2015 Aslan,CAMT,CMU</footer></div>
</div>
</body>
</html>
