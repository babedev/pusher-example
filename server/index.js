let Reader = require('properties-reader')
let Pusher = require('pusher')

let properties = Reader('../local.properties')

let pusher = new Pusher({
	appId: properties.get('pusher.appid'),
	key: properties.get('pusher.key'),
	secret: properties.get('pusher.secret'),
	cluster: properties.get('pusher.cluster'),
	encrypted: true
})

function trigger() {
	console.log("triggered")

	pusher.trigger('my-channel', 'my-event', {
		"message": "hello"
	})
}

setInterval(trigger, 5000, 'room', 20)