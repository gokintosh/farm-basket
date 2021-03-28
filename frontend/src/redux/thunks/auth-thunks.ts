import axios from 'axios';



import {API_BASE_URL}from "../../utils/constants/url";

import {
    activateAccountFailure,
    activateAccountSuccess,
    fetchAccountSuccess,
    forgotPasswordFailure,
    forgotPasswordSuccess,
    loginFailure,
    loginSuccess,
    logoutSuccess,
    registerFailure,
    registerSuccess,
    resetPasswordCodeFailure,
    resetPasswordCodeSuccess,
    resetPasswordFailure,
    resetPasswordSuccess,
    showLoader
} from "../actions/auth-actions";
import {UserData,UserRegistration} from "../../types/types";
import {Dispatch} from "redux";

export const registration = (userRegistrationData: UserRegistration) => async (dispatch: Dispatch) => {
    try {
        dispatch(showLoader());
        const response = await axios.post(API_BASE_URL + "/registration", userRegistrationData);
        dispatch(registerSuccess(response.data));
    } catch (error) {
        dispatch(registerFailure(error.response.data));
    }
};