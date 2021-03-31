import {AuthErrors, User} from "../../types/types";

import {REGISTER_SUCCESS,REGISTER_FAILURE, AuthActionTypes} from "../action-types/auth-action-types";





type InitialStateType={
    user:Partial<User>
    userRole:string|null
    isLoggedIn:boolean
    isRegistered:boolean
    loading:boolean
    success:string
    error:string
    errors:Partial<AuthErrors>
};


const intialState:InitialStateType={
    user:{},
    userRole:"",
    isLoggedIn:false,
    isRegistered:false,
    loading:false,
    success:"",
    error:"",
    errors:{}
};


const reducer=(state:InitialStateType=intialState,action:AuthActionTypes):InitialStateType=>{
    switch (action.type){
        case REGISTER_SUCCESS:
            return{...state,isRegistered:true,loading:false,errors:{}};

        case REGISTER_FAILURE:
            return{...state,errors:action.payload,loading:false};


        default:
            return state;
    }
}

export default reducer;