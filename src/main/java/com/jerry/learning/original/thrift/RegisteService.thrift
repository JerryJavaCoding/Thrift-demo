namespace java learning.thrif
struct Userinfo{
   1: i32 id
    2:string name
    3:double registe_price
}
service RegisteService{
    i32 registe(1:Userinfo userinfo)
    list <Userinfo> getUserInfo()
}