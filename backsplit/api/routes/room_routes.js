module.exports = function(app, db){
	app.post('/room', (req,res) =>{
		res.send("hi")
	});
};