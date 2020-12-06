import React, { Component } from "react";

class ProjectItem extends Component {
  render() {
    const {project} =this.props;
    return (
      <div className="container">
        <div className="card card-body bg-light mb-3">
          <div className="row">
            <div className="col-md-3 mr-auto border-left">
              <span className="text-center">{project.projectIdentifier}</span>
            </div>
            <div className="col-md-3 mr-auto">
              <h3>{project.projectName}</h3>
              <p>{project.description}</p>
            </div>
            <div className="col-md-3 ml-auto border-right">
              <ul className="list-group">
                <a href="#">
                  <li className="list-group-item board">
                    <i className="fa fa-flag-checkered pr-lg-5">
                      {" "}
                      Project Board{" "}
                    </i>
                  </li>
                </a>
                <a href="#">
                  <li className="list-group-item update">
                    <i className="fa fa-edit pr-lg-2"> Update Project Info</i>
                  </li>
                </a>
                <a href="">
                  <li className="list-group-item delete">
                    <i className="fa fa-minus-circle pr-lg-5">
                      {" "}
                      Delete Project
                    </i>
                  </li>
                </a>
              </ul>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default ProjectItem;
