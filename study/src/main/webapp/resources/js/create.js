function validate() {
    var result = true;
    var name = $('#name').val();
    var login = $('#login').val();
    var phone = $('#phone').val();
    var password = $('#password').val();

    if (!validName(name)) {
        alert("please enter correct name\n" + "Example");
        result = false;
    }
    if (!validLogin(login)) {
        alert("please enter correct login\n" + "example");
        result = false;
    }
    if (!validPass(password)) {
        alert("please enter password");
        result = false;
    }
    if (!validPhone(phone)) {
        alert("please enter correct phone\n" + "79061111111");
        result = false;
    }
    return result;
}

function validName(name) {
    var regEx = /^[A-Z]{1}[a-z]{0,15}$/;
    return regEx.test(name);
}

function validLogin(login) {
    var regEx = /[^-\s][a-zA-Z0-9-_\\s]*$/;
    return regEx.test(login);
}

// function validEmail(email) {
//     var regEx = /.+@.+\..+/;
//     return regEx.test(email);
// }

function validPhone(phone) {
    var regEx = /^(7){1}(9){1}(\d){9}$/;
    return regEx.test(phone);
}

function validPass(password) {
    return password != '';
}