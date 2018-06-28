# Pusher example for Android
Demonstration how to use Pusher on Android platform.

This project consists of 1 `Application` and 2 `Activity`. Each `Activity` will subscribe message event from `Application`.

# How to build
Add Pusher configuration in local.properties

```
pusher.appid=<APP_ID>
pusher.key=<KEY>
pusher.secret=<SECRET>
pusher.cluster=<CLUSTER>
```

# Run server

```
node server/index.js
```
