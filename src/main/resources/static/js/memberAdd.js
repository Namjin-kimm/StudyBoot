console.log("memberAdd");

$("#all").click(function(){
    let ch = $(this).prop("checked");
    
    $(".check").prop("checked", ch);
})

$(".check").click(function(){
    let allcheck = true;
    $(".check").each(function(index, c){
        let check = $(c).prop("checked");
        if(!check){
            allcheck = false;
            return false;
        }
        console.log(index + 1,check);
    })
    $("#all").prop("checked", allcheck);
})

console.log($("#id").val().length);

// id, pw, pw2, name, email
let results = [false, false, false, false, false];
let idResult = false;
let pwResult = false;
let pwCheckResult = false;
let nameResult = false;
let emailResult = false;

// 유효성 체크
$("#id").blur(function(){
    idResult = nullCheck($("#id").val(), "#idm", "#idm2" , "ID");
    results[0] = idResult;
})

$("#pw").on({
    blur:function(){
        pwResult = nullCheck($("#pw").val(), "#pwm", "#pwm2" , "PW");
        results[1] = pwResult;
    },
    change:function(){
        $("#pwCheck").val("");
        results[2] = equals($("#pwCheck").val(), $("#pw").val(), "#pwCheckm2", "#pwCheckm");
    }
})

$("#pwCheck").on({
    blur:function(){
        pwCheckResult = equals($("#pwCheck").val(), $("#pw").val(), "#pwCheckm2", "#pwCheckm");
        results[2] = pwCheckResult;
    },
    change:function(){
        results[2] = equals($("#pwCheck").val(), $("#pw").val(), "#pwCheckm2", "#pwCheckm");
    }
})

$("#name").blur(function(){
    nameResult = nullCheck($("#name").val(), "#namem", "#namem2" , "name");
    results[3] = nameResult;
})

$("#email").blur(function(){
    emailResult = nullCheck($("#email").val(), "#emailm", "#emailm2" , "email");
    results[4] = emailResult;
})

$("#joinButton").click(function(){

    if(results.includes(false)){
        alert("필수 입력 조건을 지켜라.... 김도영 같은 놈아...");
    }else{
        alert("전송");
        // $("#joinForm").submit();
    }

    // let c = true;
    // $.each(results, function(idx, item){
    //     if(!item){
    //         alert("필수 입력 조건을 지켜라....");
    //         c = false;
    //         return false;
    //     }
    // })
    // if(c){
    //     $("#joinForm").submit();
    // }

    //event 강제 실행
    // if($("#id").val().length>2 && $("#pw").val().length>2 && $("#pw2").val()==$("#pw").val() && $("#name").val().length>2
    // && $("#email").val().length>2){
    //     $("#joinForm").submit();
    // }else{
    //     alert("조건을 확인해주세요");
    // }
})

