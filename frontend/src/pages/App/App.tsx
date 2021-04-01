import Registration from "../Registration/Registration";
import {Route, Switch} from "react-router-dom";

const App=()=>{
    return(
        <Switch>
            <Route exact path="/registration" component={Registration}></Route>
        </Switch>
    )
}

export default App;