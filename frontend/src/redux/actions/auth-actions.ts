import {AuthErrors} from "../../types/types";
import { RegisterFailureActionType, RegisterSuccessActionType, REGISTER_FAILURE ,REGISTER_SUCCESS} from "../action-types/auth-action-types";


export const registerSuccess=(message:string):RegisterSuccessActionType=>({
    type:REGISTER_SUCCESS,
    payload:message
});

export const registerFailure=(errors:AuthErrors):RegisterFailureActionType=>({
    type:REGISTER_FAILURE,
    payload:errors
})