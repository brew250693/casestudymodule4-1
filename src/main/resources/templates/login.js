function Login () {
    let userName = $('#userName-login').val();
    let passWord = $('#passWord-login').val();
    let userAccount = {
        userName : userName,
        passWord : passWord
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(userAccount),
        //tên API
        url: "http://localhost:8080/api/auth/signin",

        success: function (data){
            if(data.message!=null){
                alert("Xin lỗi tài khoản dã bị khoá");
            }
            else{
                localStorage.setItem("userdata",JSON.stringify(data));

                if(data.roles[0]=="ROLE_ADMIN"){
                    window.location='adminHome.html';
                }
                else{
                    window.location='index.html';
                }
                alert("đăng nhập thành công");
            }
        },
        error: function(){

            alert("đăng nhập thất bại sai tài khoản hoặc mật khẩu");

        }


    });
    event.preventDefault();
};

function Register () {
    let userName = $('#userName-register').val();
    let passWord = $('#passWord-register').val();
    let email = $('#email-register').val();
    let name = $('#name-register').val();
    let userAccount = {
        userName : userName,
        passWord : passWord,
        email : email,
        name : name,
        role : ['user']
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(userAccount),
        //tên API
        url: "http://localhost:8080/api/auth/signup",

        success: function (){
            alert("đăng ký thành công");

        },
        error:function(){
            alert("đăng ký thất bại, tài khoản đã tồn tại hoặc sai định dạng email");
        }


    });
    event.preventDefault();
};
