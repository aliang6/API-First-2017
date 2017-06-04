module.exports = function(app, db){
    app.post('/create_room',(req,res)=>{

        var info;
        for (var property in req.body){
            if (req.body.hasOwnProperty(property)){
                info = JSON.parse(property);
            }
        }
        console.log(info);
    	db.collection('rooms').count().then((roomCount)=>{
					console.log(roomCount + " - HELLO")
				
		var userInfo = {userName: info.userName, total: 0.00, bid: 0.00};

		var roomInfo = {roomId: roomCount, members:[]};
		roomInfo.members.push(userInfo);
   
   		db.collection('rooms').insert(roomInfo, (err,result)=>{
		if (err){
			res.json({"err":err});
		}else{
				res.json(roomInfo);
		    }
		});
		});
	});
    
    app.post('/join_room',(req,res) =>{
        var info;
        for (var property in req.body){
            if (req.body.hasOwnProperty(property)){
                info = JSON.parse(property);
            }
        }
        const userInfo = {userName:info.userName, total:0.00, bid:0.00};
		/*
        var query = {query:{"roomId":parseInt(info.roomId)},
                    update:{$push:{members:userInfo}}
                    };
        */
        db.collection('rooms').findOneAndUpdate({"roomId":parseInt(info.roomId)}, 
            {$push:{members:userInfo}},
            (err,item) => {
    		if (err){
                console.log("nope");
    			res.json({"err":err});
    		}else{
                console.log("ITEM");
                console.log(item);
                item.push(userInfo);
    			res.json(item);
    		}
    	});
    });
};