import React, {FC} from 'react';
import {Route, Switch} from "react-router-dom";
import {useSelector} from "react-redux";

import {AppStateType} from "../../redux/reducers/root-reducer";
import Registration from "../Registration/Registration";

const App:FC=()=>{

    return(
        <div>
            <Switch>
                <Route exact path="/registration" component={Registration}/>
            </Switch>
        </div>
    );


};

export default App;