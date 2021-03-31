import {AuthErrors} from "../../types/types";


export const REGISTER_FAILURE="REGISTER_FAILURE";
export const REGISTER_SUCCESS="REGISTER_SUCCESS";



export type RegisterSuccessActionType={type: typeof REGISTER_SUCCESS,payload:string};
export type RegisterFailureActionType={type:typeof REGISTER_FAILURE,payload:AuthErrors};






export type AuthActionTypes=RegisterSuccessActionType|RegisterFailureActionType;
