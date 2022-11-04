function nullCheck(data, dest, dest2, kind){
    if(data == null || data == ''){
        $(dest).html(kind + "은 필수입니다");
        $(dest2).html("");
        return false;
    }else{
        $(dest2).html("정상입니다");
        $(dest).html("");
        return true;
    }
}

function equals(data, checkData, m1, m2){
    if(data == checkData){
        $(m2).html("비밀번호가 일치합니다");
        $(m1).html("");
        return true;
    }else if(data == '' && checkData == ''){
        $(m1).html("비밀번호를 입력해주세요");
        $(m2).html("");
        return false;
    }else{
        $(m1).html("비밀번호가 일치하지 않습니다");
        $(m2).html("");
        return false;
    }
}