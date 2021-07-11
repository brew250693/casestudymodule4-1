function Login () {
    let username = $('#usernameLog').val();
    let password = $('#passwordLog').val();
    let userAccount = {
        username : username,
        password : password
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
                alert("Xin lỗi tài khoản đã bị khoá!");
            }
            else{
                localStorage.setItem("userdata",JSON.stringify(data));
                if(data.roles[0]=="ROLE_ADMIN"){
                    window.location='admin-home';
                }
                else{
                    window.location='user-home';
                }
                alert("Xin chào " + username + " !");
            }
        },
        error: function(){
            alert("Sai UserName hoặc mật khẩu!");
        }
    });
    event.preventDefault();
};

function Register () {
    let email = $('#emailRes').val();
    let username = $('#userNameRes').val();
    let password = $('#passwordRes').val();
    let userAccount = {
        email : email,
        username : username,
        password : password,
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
            alert("Đăng ký thành công!");

        },
        error:function(){
            alert("UserName đã tồn tại hoặc e-mail không đúng định dạng!");
        }
    });
    event.preventDefault();
};

function LogoutAdmin(){
    localStorage.removeItem("userdata");
    window.location='index';
};