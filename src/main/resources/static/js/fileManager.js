//파일 추가 갯수를 지정하는 변수
let count = 0;
$("#fileAddButton").click(function(){
    if(count < 5){
        console.log("Button");
        let add = $("#fileAddForm").html();
        $("#fileAdd").append(add);
        count++;
    }else{
        alert('파일은 최대 5개까지만 추가할 수 있습니다');
    }
})

$("#fileAdd").on("click", ".del", function(){
    $(this).parent().remove();
    count--;
})

///글 수정시 첨부파일 삭제
$(".deleteFile").click(function(){
    //DB, HDD에서 파일 삭제
    let check = confirm("정말 삭제하시겠습니까?");
    let self = $(this);

    if(check){
        //post
        //   /qna/fileDelete
        //파라미터 fileNum
        $.ajax({
            type:"POST",
            url:"./fileDelete",
            data:{
                fileNum:$(this).attr("data-fileNum")
            },
            success:function(result){
                console.log("Result : ",result);
                console.log(self.parent());
                self.parent().remove();
            },
            error:function(){
                console.log("Error 발생");
            }
        })
    }
})