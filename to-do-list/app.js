
const express= require('express');
const bodyParser=require("body-parser");
const mongoose = require("mongoose");
const _= require("lodash");

const app = express();

app.set('view engine', 'ejs');

app.use(bodyParser.urlencoded({extended:true, useNewUrlParser: true }));
app.use(express.static("Public"));

mongoose.connect("mongodb://localhost:27017/todolistdb");

const itemsSchema={
	name: String
};
const Item=mongoose.model("Item", itemsSchema);

const item1=new Item({
	name:" Welcome to to-do-list"
});
const item2=new Item({
	name:" Click on '+' to add a new item"
});
const item3=new Item({
	name:" <-- Hit this to delete an item"
});

const defaultitems=[item1,item2,item3];

const listSchema={
	name: String,
	items:[itemsSchema]
};
const List= mongoose.model("List",listSchema);

app.get('/',function(req,res){
	Item.find({},function(err, founditem){
		if (founditem.length===0) {
			Item.insertMany(defaultitems, function(err){
				if (err){
					console.log(err);
				} else{
					console.log("successfully added default items");
				}
			});
			res.redirect("/");
		} else {
			res.render("list",{day:"Today", items:founditem});
		}
	});

});
app.get("/:customlistName",function(req,res){
	const customListName= _.capitalize(req.params.customlistName);
	List.findOne({name:customListName},function(err,foundlist){
		if(!err){
			if(!foundlist){
				const list= new List({
					name: customListName,
					items: defaultitems
				});
				list.save();
				res.redirect("/" + customListName);
			} else {
				res.render("list",{day:foundlist.name, items:foundlist.items});
			}
		}
	});

});

app.post('/', function(req,res) {
	const newitem = req.body.newitem;
	const listname=req.body.list;

	const additem= new Item({
		name: newitem
	});

	if (listname==="Today") {
		additem.save();
		res.redirect("/");
	} else {
		List.findOne({name:listname},function(err,foundlist){
			foundlist.items.push(additem);
			foundlist.save();
			res.redirect("/" + listname);
		});
	}

});

app.post("/delete",function(req,res){
	const checkeditemId=req.body.checkBox ;
	const listname= req.body.listname;
	if (listname==="Today") {
		Item.findByIdAndRemove(checkeditemId,function(err){
			if(!err){
				console.log(checkeditemId);
				res.redirect("/");
			}
		});
	} else {
		List.findOneAndUpdate({name:listname},{$pull: {items: {_id: checkeditemId}}},function(err,foundlist){
			if(!err){
				res.redirect("/" + listname);
			}
		});
	}

});

app.listen(3000,function(){
	console.log("server started at 3000");
});
