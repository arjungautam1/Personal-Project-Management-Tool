import React from "react";
import { Link } from "react-router-dom";
import AddProjectMaterial from "./AddProjectMaterial";
import { Add } from "@material-ui/icons";

const CreateProjectButton = () => {
  return (
    <React.Fragment>
      <div className="text-center mb-0">
        <Link to={"/addProject"} className="btn btn-lg btn-info ">
          Create a Project
        </Link>
        {/*<AddProjectMaterial/>*/}
      </div>
    </React.Fragment>
  );
};

export default CreateProjectButton;
