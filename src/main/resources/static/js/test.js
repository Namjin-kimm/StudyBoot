console.log("start");

$("#btn").click(function(){
    console.log('click');
})

$(".buttons").click(function(){
    console.log('buttons');
})

$("#test").on("click", "#btn2", function(){});

