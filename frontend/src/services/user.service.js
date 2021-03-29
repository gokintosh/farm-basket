import axios from "axios";
import authHeader from "./auth-header";
import authService from "./auth.service";




const API_URL='http://localhost:8080/api/';

class UserService{
    

    getUserProfile(){
        const user=JSON.parse(localStorage.getItem('user'));
        return axios.get(API_URL+'profile',{
            params:{
                email:user.account
            },
            headers:authHeader()

        });
    }
}

export default new UserService();