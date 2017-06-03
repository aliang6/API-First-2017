const express = require('express');
const MongoDb = require('mongodb').Db;
const MongoClient = require('mongodb').MongoClient;
const bodyParser = require('body-parser');

const app = express()
const port = 8004

app.use(bodyParser.urlencoded({extended:true}));


MongoClient.connect("mongodb://localhost:27015/rooms", (err,database)=>{
	if (err) return console.log(err)
		//sudo mongod --dbpath=/data --port 27015
	console.log("DB created at 27015");

	require('./api/routes')(app,database);

	app.listen(port, () => {
		console.log('Located at port ' + port);
	});
});


