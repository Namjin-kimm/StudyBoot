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
    let id = $("#id").val();
    idResult = nullCheck(id, "#idm", "#idm2" , "ID");
    results[0] = idResult;
    //단, id가 ''비어있지 않을 때                                      
    //IDCHECK AJAX
    $.get("./idCheck?id="+id, function(data){
        console.log("data : ", data);
        if(data=='0'){
            $("#idm2").html("사용가능한 ID입니다");
            results[0] = true;
        }else{
            $("#idm").html("중복된 ID입니다");
            results[0] = false;
        }
    })
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

$("#test").click(function(){
    let id = "123";
    let name = "iu";

    $.post("./test", {
        id:id, name:name
    }, function(result){
        console.log("Result : ", result);
        // "{키:밸류}"
        // 그냥 바로 Json형태로 오는 것이 아니라 문자열로 오게 되면 legacy에서 했던 것처럼 Jason으로 바꿔줘야 한다. -> JSON.parse()로
        //result = JSON.parse(result);
        console.log("Name : ", result.name);
    })
})

$("#test2").click(function(){
    let id = "abcd";
    $.ajax({
        type:"GET",
        url:"idCheck",
        data:{
            id:id
        },
        sucess:function(data){
            console.log("Data : ", data);
        },
        error:function(xhr,status,error){
            console.log("Xhr : ", xhr);
            console.log("Status : ", status);
            console.log("Error : ", error);
        }
    });
})

$("#test3").click(function(){
    let id = '1234';
    let name = 'iu';
    let ar = [1,2,3];
    $.ajax({
        type : "POST",
        url : "test",
        traditional:true, //배열을 전송할 때 사용, true
        data:{
            id:id,
            name:name,
            ar:ar
        },
        success:function(result){
            console.log("result : ", result);
        }
    })
})

let count =3;
$("#s1Add").click(function(){
    let add = '<option class="abc" id="abc'+count+'">'+count+'</option>';//문자열로 만들어 주는 것임 
    $("#s1").append(add);
    count++;

    // $("#s1Add").remove();
})

// 자기 자신을 제외하고 자식들을 지우겠다
$("#s1").click(function(){
    //  $("#s1").empty();
 })
