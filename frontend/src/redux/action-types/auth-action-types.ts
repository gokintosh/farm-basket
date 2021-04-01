import {AuthErrors} from "../../types/types";


export const REGISTER_FAILURE="REGISTER_FAILURE";
export const REGISTER_SUCCESS="REGISTER_SUCCESS";
export const SHOW_LOADER="SHOW_LOADER";


export type RegisterSuccessActionType={type: typeof REGISTER_SUCCESS,payload:string};
export type RegisterFailureActionType={type:typeof REGISTER_FAILURE,payload:AuthErrors};
export type ShowLoaderActionType={type:typeof SHOW_LOADER}






export type AuthActionTypes=RegisterSuccessActionType|RegisterFailureActionType|ShowLoaderActionType;
