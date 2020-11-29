import React from 'react';
import {Link} from "react-router-dom";

const CreateProjectButton = () => {
    return (
        <React.Fragment>
            <div className="text-center mb-0">

            <Link to={"/addProject"} className="btn btn-lg btn-info ">
                Create a Project
            </Link>


            </div>
        </React.Fragment>
    );
};

export default CreateProjectButton;
