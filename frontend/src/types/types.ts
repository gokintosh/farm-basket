export type User={
    id:number
    username:string
    email:string
    active:boolean
    activationCode:string|null
    passwordResetCode:String|null
    token:String|null
    roles:Array<String>
};

export type UserData={
    email:string
    password:string
};

export type UserRegistration={
    email:string
    username:string
    password:string
    password2:string
    captcha:string|null
};

export type AuthErrors = {
    captchaError: string
    emailError: string
    usernameError: string
    passwordError: string
    password2Error: string
};