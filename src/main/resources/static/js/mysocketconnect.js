/**
 *  Den 8.3.2024
 */

 var stompClient = null;
 function connect() {

    var socket = new SockJS('/register');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame) {
        setConnected(true);

        stompClient.subscribe('/messages/receive/', function (message) {
            var messageOutput = JSON.parse(message.body);

            // message Ausgabe
            showMessage(messageOutput);
        });
    });
 }

 function disconnect() {
    if(stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    //console.log("Disconnected");
 }

 function setConnected(connected) {
     $("#connect").prop("disabled", connected);
     $("#disconnect").prop("disabled", !connected);
     if (connected) {
         $("#conversation").show();
     }
     else {
         $("#conversation").hide();
     }
     $("#textAusgabe").html("");
 }

 function sendMessage(){

    stompClient.send("/app/messages", {}, JSON.stringify({'name' : $("#name").val(), 'text': new Date }));
 }

 function showMessage(message){

    $("#textAusgabe").append("<tr><td>" + message.text + ": &#160;&#160;" + message.name + "</td></tr>");
 }

 $(function () {
     $("form").on('submit', (e) => e.preventDefault());
     $( "#connect" ).click(() => connect());
     $( "#disconnect" ).click(() => disconnect());
     $( "#send" ).click(() => sendMessage());
 });