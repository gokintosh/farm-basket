import axios from "axios";
import { Dispatch } from "redux";
import { UserRegistration } from "../../types/types";
import { API_BASE_URL } from "../../utils/constants/url";
import { reset } from "../actions/admin-actions";
import { registerFailure, registerSuccess, showLoader } from "../actions/auth-actions";


export const registration=(userRegistrationData:UserRegistration)=>async(dispatch:Dispatch)=>{
    try{
        dispatch(showLoader());
        const response=await axios.post(API_BASE_URL+"/registration",userRegistrationData);
        dispatch(registerSuccess(response.data));
    }catch(error){
        dispatch(registerFailure(error.response.data));
    }
};

export const formReset=()=>async(dispatch:Dispatch)=>{
    dispatch(reset());
};