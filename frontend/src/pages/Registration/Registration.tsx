import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import React, {FormEvent, useEffect, useState} from 'react';
import { useDispatch, useSelector } from "react-redux";
import { AppStateType } from "../../redux/reducers/root-reducer";
import { formReset, registration } from '../../redux/thunks/auth-thunks';
import { AuthErrors, UserRegistration } from "../../types/types";
import {faEnvelope, faLock, faUser, faUserPlus} from "@fortawesome/free-solid-svg-icons";
import PageLoader from '../../components/pageLoader/PageLoader';

const Registration=()=>{
    const dispatch = useDispatch();
    const isRegistered:boolean = useSelector((state:AppStateType) => state.auth.isRegistered);
    const loading:boolean=useSelector((state:AppStateType)=>state.auth.loading);
    const errors:Partial<AuthErrors>=useSelector((state:AppStateType)=>state.auth.errors);

    const{emailError,nameError,passwordError,password2Error}=errors;
    const[email, setEmail] = useState<string>("");
    const [username, setUsername] = useState<string>("");
    const [password, setPassword] = useState<string>("");
    const [password2, setPassword2] = useState<string>("");



    useEffect(()=>{
        dispatch(formReset());
    },[]);

    useEffect(()=>{
        setEmail("");
        setUsername("");
        setPassword("");
        setPassword2("");
    },[isRegistered]);

    const onClickSignUp=(event:FormEvent<HTMLFormElement>):void=>{
        event.preventDefault();
        const userRegistrationData:UserRegistration={email,username,password,password2}
        dispatch(registration(userRegistrationData));

    };


    let pageLoading;
    if(loading){
        pageLoading=(<PageLoader/>)
    }

    return(
        <div className="container mt-5">
            {pageLoading}
            <h4><FontAwesomeIcon className="mr-2" icon={faUserPlus}/>SignUp</h4>
            <hr/>
            {isRegistered?<div className="alert alert-success col-6" role="alert">Activation code has been sent to your Mail</div>:null}
            <form onSubmit={onClickSignUp}>
                <div className="form-group row">
                    <label className="col-sm-2 col-form-label">Email</label>
                    <FontAwesomeIcon style={{position:"relative",top:"8px"}} icon={faEnvelope}/>
                    <div className="col-sm-4">
                        <input type="email" name="email" value={email} className={emailError?"form-control is-invalid":"form-control"}
                            onChange={(event)=>setEmail(event.target.value)}
                        />
                        <div className="invalid-feedback">{emailError}</div>
                    </div>
                </div>
                <div className="form-group row">
                    <label className="col-sm-2 col-form-label">UserName</label>
                    <FontAwesomeIcon style={{position:"relative",top:"8px"}} icon={faUser}/>
                    <div className="col-sm-4">
                        <input type="text" name="name" value={username} className={nameError?"form-control is-invalid":"form-control"}
                        onChange={(event)=>setUsername(event.target.value)}
                        />
                        <div className="invalid-feedback">{nameError}</div>
                    </div>
                </div>
                <div className="form-group row">
                    <label className="col-sm-2 col-form-label">Password</label>
                    <FontAwesomeIcon style={{position:"relative",top:"8px"}} icon={faLock}/>
                    <div className="col-sm-4">
                        <input type="password" name="password" value={password} className={passwordError?"form-control is-invalid":"form-control"}
                        onChange={(event)=>setPassword(event.target.value)}
                        />
                        <div className="invalid-feedback">{passwordError}</div>
                    </div>
                </div>
                <div className="form-group row">
                    <label className="col-sm-2 col-form-label">Confirm Password</label>
                    <FontAwesomeIcon style={{position:"relative",top:"8px"}} icon={faLock}/>
                    <div className="col-sm-4">
                        <input type="password" name="password" value={password2} className={password2Error?"form-control is-invalid":"form-control"}
                        onChange={(event)=>setPassword2(event.target.value)}
                        />
                        <div className="invalid-feedback">{password2Error}</div>
                    </div>
                </div>
                <div className="form-group row">
                    <button className="btn btn-dark mx-3">
                        <FontAwesomeIcon className="mr-2" icon={faUserPlus}/>Sign Up
                    </button>
                </div>
            </form>
        </div>
    );
    
};

export default Registration;