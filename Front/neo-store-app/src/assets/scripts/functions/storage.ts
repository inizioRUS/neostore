function CheckLogin() : boolean {
    if(localStorage.getItem("login")){
        return true;
    }
    return false;
}

function SetLogin(id : number) : void {
    localStorage.setItem("login", `${id}`);
}

function GetLogin() : number {
    let res = localStorage.getItem("login");
    return parseInt(res ? res : '0');
}

export default{
    CheckLogin,
    SetLogin,
    GetLogin
}