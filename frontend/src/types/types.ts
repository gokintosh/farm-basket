export type User={
    id:number
    name:string
    email:string
    active:boolean
    activationCode:String|null

};

export type UserRegistration={
    email:string
    name:string
    password:string
    password2:string
};

export type AuthErrors={
    emailError:string
    nameError:string
    passwordError:string
    password2Error:string
};