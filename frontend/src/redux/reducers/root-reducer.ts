import {combineReducers} from "redux"


import authReducer from "./auth-reducer";


const rootReducer = combineReducers({
    auth: authReducer,
  
});

type RootReducerType = typeof rootReducer;
export type AppStateType = ReturnType<RootReducerType>;

export default rootReducer;