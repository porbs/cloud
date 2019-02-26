var express = require('express');
var http = require('http');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  // res.render('index', { title: 'Express' });

  var userServiceUri = process.env.USER_SERVICE_URI;

  if (!userServiceUri) {
    userServiceUri = 'user-service:7211';
  }

  userServiceUri = `http://${userServiceUri}/`;

  console.log(`User service URI: ${userServiceUri}`);

  http.get(userServiceUri, (r) => {
    let data = '';

    r.on('data', (chunk) => {
      data += chunk;
    });
  
    r.on('end', () => {
      console.log(`Received: ${data}`);
      res.send(`Got from user-service: ${data}`);
    });
  }).on('error', (err) => {
    console.log("Error: " + err.message);
  });
});

module.exports = router;
