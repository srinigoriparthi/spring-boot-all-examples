$(document).ready( function () {
	var table = $('#personsTable').DataTable({
		"scrollY":400,
		"sAjaxSource": "/getpersons",
		"sAjaxDataProp": "",
		"order": [[ 0, "asc" ]],
		"aoColumns": [
			{ "mData": "id"},
			{ "mData": "firstName" },
			{ "mData": "lastName" },
			{ "mData": "phone" },
			{ "mData": "email" },
			{ "mData": "address" }
		]
	})


});













































































/*
$(document).ready( function () {
	 var table = $('#personsTable').DataTable({
		 	"scrollY":400,
			"sAjaxSource": "/getpersons",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			      { "mData": "id"},
		          { "mData": "firstName" },
				  { "mData": "lastName" },
				  { "mData": "phone" },
				  { "mData": "email" },
				  { "mData": "address" }
			]
	 })


});*/
