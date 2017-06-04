module.exports = function(app, db){
    app.post('/create_room',(req,res)=>{
    	console.log(req);
    	var roomInfo = {name: req.body.roomName, roomId: req.body.roomId, members:[]};
		var userInfo = {name: req.body.userName, userId: req.body.userId}
		roomInfo.members.push(userInfo);
		db.collection('rooms').insert(roomInfo, (err,result)=>{
		if (err){
			res.json({"success":"no"});
			//res.send({"error":"An error has occurred"});
		}else{
				console.log(db.collection('rooms').count());
				//res.send("Successfully created room");
			res.json({"success":"yees"});
		    }
		});
	});
    
    app.post('/join_room',(req,res) =>{
		const query = {roomId:req.body.roomId}
    	db.collection('rooms').findOne(query, (err,item) => {
    		if (err){
    			res.json({"excess":"yar"});
    			//res.send({'error':'An error has occurred'});
    		}else{
    			//res.send(item);
    			res.json({"excess":"nop"});
    		}
    	});
    });
};